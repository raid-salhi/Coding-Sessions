package com.example.noteapp.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.room.entities.Note

@Dao
interface NoteDao {
    @Insert
    fun addNote(note: Note)

    @Query("SELECT * FROM note")
    fun getAllNotes():List<Note>

    @Query("SELECT * FROM note WHERE id = :noteId")
    fun getNoteById(noteId: Int): Note?
    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)
}