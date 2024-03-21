package com.example.noteapp.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Category(
    val name:String,
    val color: Long,
    @PrimaryKey(autoGenerate = true) val id:Int
)
