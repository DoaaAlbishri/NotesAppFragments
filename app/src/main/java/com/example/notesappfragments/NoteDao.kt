package com.example.notesappfragments

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Update

@Dao
interface NoteDao {

    @Query("SELECT * FROM Note")
    fun getNote(): LiveData<List<Note>>

    @Insert
    fun insertNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)

}