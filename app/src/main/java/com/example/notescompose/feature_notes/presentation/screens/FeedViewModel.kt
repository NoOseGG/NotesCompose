package com.example.notescompose.feature_notes.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notescompose.feature_notes.domain.use_case.GetNotesUseCase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FeedViewModel(
    private val getNotesUseCase: GetNotesUseCase
): ViewModel() {

    val notes = flow {
        val result = getNotesUseCase()
        emit(result)
    }

    class Factory @Inject constructor(
        private val getNotesUseCase: GetNotesUseCase
    ): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == FeedViewModel::class.java)
            return FeedViewModel(getNotesUseCase) as T
        }
    }
}