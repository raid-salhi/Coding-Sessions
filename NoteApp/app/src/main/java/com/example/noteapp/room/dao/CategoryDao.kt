package com.example.noteapp.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.noteapp.room.entities.Category

@Dao
interface CategoryDao {
    @Insert
    fun addCategory(category: Category)

    @Query("SELECT * FROM category")
    fun getAllCategories():List<Category>

    @Delete
    fun deleteCategory(category: Category)
}