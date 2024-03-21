package com.example.noteapp.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title:String,
    val body : String,
    val category: String,
    var isFav : Boolean = false,
    @PrimaryKey(autoGenerate = true) val id:Int
)
