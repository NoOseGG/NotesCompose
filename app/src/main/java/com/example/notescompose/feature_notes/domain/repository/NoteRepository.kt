package com.example.notescompose.feature_notes.domain.repository

import com.example.notescompose.feature_notes.domain.model.Note

interface NoteRepository {

    suspend fun getNotes(): List<Note>

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun findById(id: Int): Note
}