package com.example.notescompose.feature_notes.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.notescompose.feature_notes.domain.model.Note

@Composable
fun FeedScreen(feedViewModel: FeedViewModel) {

    val notes = feedViewModel.notes.collectAsState(initial = listOf()).value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(notes.size) {
            MyItemRow(note = notes[it])
        }
    }
}

@Composable
fun MyItemRow(note: Note) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                println(note.id)
            },
        elevation = 5.dp,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(width = 2.dp, color = Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = note.title)
            Text(text = note.content)
        }
    }
}