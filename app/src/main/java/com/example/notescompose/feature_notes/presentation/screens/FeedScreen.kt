package com.example.notescompose.feature_notes.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notescompose.feature_notes.data.repository.NoteRepositoryImpl
import com.example.notescompose.feature_notes.domain.model.Note
import com.example.notescompose.feature_notes.domain.repository.NoteRepository
import com.example.notescompose.feature_notes.domain.use_case.GetNotesUseCase

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
    feedViewModel: FeedViewModel
) {

    val notes = feedViewModel.notes.collectAsState(initial = listOf()).value

    Box(modifier = modifier.fillMaxSize()) {
        MyListNote(modifier = modifier, notes = notes)

        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.BottomEnd,

        ) {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                contentColor = Color.White,
                backgroundColor = Color.Cyan
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    }


    MyListNote(modifier = modifier, notes = notes)

}

@Composable
fun MyListNote(modifier: Modifier, notes: List<Note>) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(notes.size) {
            MyItemRow(note = notes[it], modifier = modifier)
        }
    }
}

@Composable
fun MyItemRow(
    modifier: Modifier,
    note: Note
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                println(note.id)
            },
        elevation = 10.dp,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(width = 2.dp, color = Color.Black)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = note.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = modifier.height(6.dp))
            Text(text = note.content)
        }
    }
}