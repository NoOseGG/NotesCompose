package com.example.notescompose.feature_notes.data.data_source

import androidx.room.*
import com.example.notescompose.feature_notes.domain.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    suspend fun getNotes(): List<Note>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun findById(id: Int): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}