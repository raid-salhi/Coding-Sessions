package com.example.noteapp.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.local.dao.CategoryDao
import com.example.noteapp.local.dao.NoteDao
import com.example.noteapp.local.models.Category
import com.example.noteapp.local.models.Note

@Database(
    entities = [
        Category::class,
        Note::class
               ],
    version = 1
)
abstract class LocalDatabase:RoomDatabase() {
    abstract fun NoteDao():NoteDao
    abstract fun CategoryDao():CategoryDao
    companion object{
        @Volatile
        private var db:LocalDatabase?=null
        fun getInstance(c: Context):LocalDatabase{
            if(db==null){
                synchronized(this) {
                    db = Room
                        .databaseBuilder(c, LocalDatabase::class.java, "local_database")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return db!!
        }
    }




}