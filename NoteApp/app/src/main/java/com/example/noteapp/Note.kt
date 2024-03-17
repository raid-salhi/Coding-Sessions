package com.example.noteapp

data class Note(
    val title:String,
    val body : String,
    val category: String,
    var isFav : Boolean = false
)
