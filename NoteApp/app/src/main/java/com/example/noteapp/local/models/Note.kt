package com.example.noteapp.local.models

data class Note(
    val title:String,
    val body : String,
    val category: String,
    var isFav : Boolean = false
)
