package com.example.niksracipes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.niksracipes.databinding.CategoryRvBinding
import com.example.niksracipes.databinding.SearchRvBinding

class CategoryAdapter(var dataList:ArrayList<Recipe>,var context: Context) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
    inner class ViewHolder(var binding: CategoryRvBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = CategoryRvBinding.inflate(LayoutInflater.from(context),parent,false)
        return  ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    private fun startRecipeActivity(position: Int) {
        val intent = Intent(context, RecipeActivity::class.java).apply {
            putExtra("img", dataList[position].img)
            putExtra("tittle", dataList[position].tittle)
            putExtra("des", dataList[position].des)
            putExtra("ing", dataList[position].ing)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(intent)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(dataList.get(position).img).into(holder.binding.img)
        holder.binding.tittle.text=dataList.get(position).tittle
        var temp=dataList.get(position).ing.split("\n").dropLastWhile { it.isEmpty() }.toTypedArray()
        holder.binding.time.text=temp[0]
//

        // Define the common method


// In your onBindViewHolder or equivalent method
        holder.binding.next.setOnClickListener {
            startRecipeActivity(position)
        }

        holder.binding.nikExtra.setOnClickListener {
            startRecipeActivity(position)
        }


    }
}