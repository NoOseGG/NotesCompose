package com.example.notescompose.feature_notes.data.repository

import com.example.notescompose.feature_notes.data.data_source.NoteDao
import com.example.notescompose.feature_notes.domain.model.Note
import com.example.notescompose.feature_notes.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {

    override suspend fun getNotes(): List<Note> {
        return noteDao.getNotes()
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    override suspend fun findById(id: Int): Note {
        return noteDao.findById(id)
    }
}