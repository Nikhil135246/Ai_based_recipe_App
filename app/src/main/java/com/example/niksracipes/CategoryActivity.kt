package com.example.niksracipes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.niksracipes.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private  lateinit var rvAdapter:CategoryAdapter
    private lateinit var dataList:ArrayList<Recipe>
    private val binding by lazy {
        ActivityCategoryBinding.inflate(layoutInflater)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        title=intent.getStringExtra("TITTLE")
        setUpRecyclerView()
        binding.goBackHome.setOnClickListener{
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun setUpRecyclerView() {
        dataList= ArrayList()

        binding.rvCategory?.layoutManager=
            LinearLayoutManager(this)
        var db= Room.databaseBuilder(this@CategoryActivity,AppDatabase::class.java,"db_name")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigrationFrom()
            .createFromAsset("recipe.db")
            .build()
        var daoObject=db.getDao()
        var recipes=daoObject.getALL()
        for (i in recipes!!.indices) {
            if (recipes[i]!!.category.contains(intent.getStringExtra("CATEGORY")!!)) {
                dataList.add(recipes[i]!!)
            }
            rvAdapter = CategoryAdapter(dataList, this)
            binding.rvCategory?.adapter= rvAdapter
        }

    }
}