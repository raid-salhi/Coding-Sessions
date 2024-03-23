package com.example.noteapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.room.dao.CategoryDao
import com.example.noteapp.room.dao.NoteDao
import com.example.noteapp.room.entities.Category
import com.example.noteapp.room.entities.Note

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