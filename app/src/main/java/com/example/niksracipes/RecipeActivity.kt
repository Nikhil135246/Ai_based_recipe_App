package com.example.niksracipes

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.niksracipes.databinding.ActivityCategoryBinding
import com.example.niksracipes.databinding.ActivityRecipeBinding

class RecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeBinding
    private val emojis  = listOf(
        "🍕",  // Pizza
        "🍔",  // Burger
        "🍟",  // Fries
        "🌭",  // Hot dog
        "🍣",  // Sushi
        "🍜",  // Ramen
        "🍲",  // Stew
        "🍰",  // Cake
        "🍦",  // Ice cream
        "🍩",  // Doughnut
        "🥖",  // Baguette bread
        "🍪",  // Cookie
        "🍫",  // Chocolate bar
        "🍿",  // Popcorn
        "🥨",  // Pretzel
        "🍉",  // Watermelon
        "🍇",  // Grapes
        "🍓",  // Strawberry
        "🍑",  // Peach
        "🍍"   // Pineapple
    )
    private fun getRandomEmoji(): String {
        return emojis.random()
    }
    var imgCrop=true
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRecipeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImg)
        binding.tittle.text=intent.getStringExtra("tittle")
//        binding.ingData.text=intent.getStringExtra("ing")
        binding.stepsData.text=intent.getStringExtra("des")
        var ing = intent.getStringExtra("ing")?.split("\n".toRegex())?.dropLastWhile { it.isEmpty() }
            ?.toTypedArray()
        binding.time.text=ing?.get(0)
        val emoji = getRandomEmoji()
        for (i in 1 until ing!!.size)
        {
            binding.ingData.text=
                """${binding.ingData.text} $emoji ${ing[i]}
                    
                """.trimIndent()

        }
        binding.steps.background=null
        binding.steps.setTextColor(getColor(R.color.black))
        binding.steps.setOnClickListener{
            binding.steps.setBackgroundResource(R.drawable.btn_ing)
            binding.steps.setTextColor(getColor(R.color.white))
            binding.ing.setTextColor(getColor(R.color.black))
            binding.ing.background=null
            binding.stepScroll.visibility=View.VISIBLE
            binding.ingScroll.visibility=View.GONE
        }

        binding.ing.setOnClickListener{
            binding.ing.setBackgroundResource(R.drawable.btn_ing)
            binding.ing.setTextColor(getColor(R.color.white))
            binding.steps.setTextColor(getColor(R.color.black))
            binding.steps.background=null
            binding.ingScroll.visibility=View.VISIBLE
            binding.stepScroll.visibility=View.GONE
        }

        binding.fullScreen.setOnClickListener{
            if(imgCrop)
            {
                binding.itemImg.scaleType=ImageView.ScaleType.FIT_CENTER
                Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImg)
                binding.shadow.visibility=View.GONE
                binding.fullScreen.setColorFilter(Color.BLACK,PorterDuff.Mode.SRC_ATOP)

                imgCrop=!imgCrop

            }else{
                binding.itemImg.scaleType=ImageView.ScaleType.CENTER_CROP
                Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImg)
                binding.shadow.visibility=View.GONE
                binding.fullScreen.setColorFilter(null)

                imgCrop=!imgCrop

            }
        }
        binding.backBtn.setOnClickListener{
            finish()
        }
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}