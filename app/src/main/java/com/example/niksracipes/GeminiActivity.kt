package com.example.niksracipes

import android.os.Bundle
import android.view.animation.RotateAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.withContext

class GeminiActivity : AppCompatActivity() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gemini)

        val prompt = findViewById<EditText>(R.id.prompt)
        val tVResult = findViewById<TextView>(R.id.tVResult)
        val btnSubmit = findViewById<ImageView>(R.id.gemini)
        val backbtn = findViewById<ImageView>(R.id.back_btn)
        backbtn.setOnClickListener{
            finish()
        }
        btnSubmit.setOnClickListener {
            // Hide the keyboard and clear focus immediately
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            prompt.clearFocus()

            // Start rotating the ImageView
            val rotateAnimation = RotateAnimation(
                0f, 360f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f
            ).apply {
                duration = 1200 // 1 second per full rotation
                repeatCount = RotateAnimation.INFINITE // Keep rotating indefinitely
            }
            btnSubmit.startAnimation(rotateAnimation)

            // Perform the content generation task
            coroutineScope.launch {
                try {
                    val originalPromptText = prompt.text.toString()
                    
                    // Check if prompt is empty
                    if (originalPromptText.trim().isEmpty()) {
                        btnSubmit.clearAnimation()
                        Toast.makeText(this@GeminiActivity, "Please enter a recipe name", Toast.LENGTH_SHORT).show()
                        return@launch
                    }
                    
                    val extraTextBefore = "assume you are a chef now i want u to give me recipes in format (ingredients then steps (1,2...) as heading and contents inside these 2 headings (and noting else emojis allowed,even though headings and content should also be in plain text no bold or highlighted text) , (and remember imp note dont use any kind of formatting like bullets , bold, etc. response in plain text only except emojis) any language depend on in which language the below sentence is or take english default \" "
                    val extraTextAfter = "\" if it is not related to cooking or kitchen help just give simple one line answer its not related to cooking or something, and every time at start use emoji if you can and you have to use emoji as bullets for ingredients and don't forget you don't have to use text formatting like bold, bullets only (emojis and plain text allowed)"

                    // Concatenate the extra text before and after the original prompt text
                    val modifiedPromptText = "$extraTextBefore$originalPromptText$extraTextAfter"

                    val generativeModel = GenerativeModel(
                        modelName = "gemini-1.5-flash",
                        apiKey = "Enter your api key i used from google  studio 1.5falsh model"
                    )
                    
                    val response = withContext(Dispatchers.IO) {
                        generativeModel.generateContent(modifiedPromptText)
                    }

                    // Stop the rotation once the response is generated
                    btnSubmit.clearAnimation()

                    // Display the generated content
                    tVResult.text = response.text ?: "Sorry, couldn't generate recipe. Please try again."
                    
                } catch (e: Exception) {
                    // Stop the rotation and show error
                    btnSubmit.clearAnimation()
                    
                    // Handle different types of errors
                    val errorMessage = when {
                        e.message?.contains("API_KEY") == true -> "API key issue. Please check your connection."
                        e.message?.contains("quota") == true -> "API quota exceeded. Please try again later."
                        e.message?.contains("network") == true -> "Network error. Please check your internet connection."
                        else -> "Something went wrong. Please try again."
                    }
                    
                    tVResult.text = "❌ $errorMessage"
                    Toast.makeText(this@GeminiActivity, errorMessage, Toast.LENGTH_LONG).show()
                }
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
