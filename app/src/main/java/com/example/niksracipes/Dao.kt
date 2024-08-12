package com.example.niksracipes

import androidx.room.Dao
import androidx.room.Query
@Dao
interface Dao {
    @Query("SELECT * FROM recipe")

    fun getALL():List<Recipe?>?
}