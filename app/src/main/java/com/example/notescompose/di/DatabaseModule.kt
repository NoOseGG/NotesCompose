package com.example.notescompose.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notescompose.feature_notes.data.data_source.NoteDao
import com.example.notescompose.feature_notes.data.data_source.NoteDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(
        context: Context
    ): NoteDatabase {
        return Room.databaseBuilder(
            context = context,
            NoteDatabase::class.java,
            "note_db"
        ).build()
    }

    @Provides
    fun provideNoteDao(
        noteDatabase: NoteDatabase
    ): NoteDao {
        return noteDatabase.noteDao()
    }
}