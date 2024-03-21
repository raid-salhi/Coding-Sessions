package com.example.noteapp.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.local.models.Category

@Dao
interface CategoryDao {
    @Insert
    fun addCategory(category: Category)

    @Query("SELECT * FROM category")
    fun getAllCategories():List<Category>

    @Delete
    fun deleteCategory(category: Category)
}