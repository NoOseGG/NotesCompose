package com.example.notescompose.di

import com.example.notescompose.feature_notes.data.repository.NoteRepositoryImpl
import com.example.notescompose.feature_notes.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindNoteRepository(impl: NoteRepositoryImpl): NoteRepository
}