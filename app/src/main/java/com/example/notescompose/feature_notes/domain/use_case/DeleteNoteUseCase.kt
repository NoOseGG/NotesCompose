package com.example.notescompose.feature_notes.domain.use_case

import com.example.notescompose.feature_notes.domain.model.Note
import com.example.notescompose.feature_notes.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note)
    }
}