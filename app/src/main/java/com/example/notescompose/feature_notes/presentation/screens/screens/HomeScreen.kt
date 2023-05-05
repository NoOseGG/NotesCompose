package com.example.notescompose.feature_notes.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.notescompose.feature_notes.domain.model.Note
import com.example.notescompose.feature_notes.presentation.screens.navigation.Screen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(feedViewModel: FeedViewModel, navController: NavHostController) {

    Scaffold(
        floatingActionButton = { FloatingActionButtonCompose(navController = navController)},
        floatingActionButtonPosition = FabPosition.End
    ) {

        FeedScreen(feedViewModel = feedViewModel, navController = navController)
    }
}
@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
    feedViewModel: FeedViewModel,
    navController: NavHostController
) {

    val notes = feedViewModel.notes.collectAsState(initial = listOf()).value

    Box(modifier = modifier.fillMaxSize()) {
        MyListNote(modifier = modifier, notes = notes)

    }
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

@Composable
fun FloatingActionButtonCompose(navController: NavHostController) {
    FloatingActionButton(
        onClick = {
            navController.navigate(Screen.AddEditScreen.route)
            println("Floating button clicked")
        },
        contentColor = Color.White,
        backgroundColor = Color.Cyan
    ) {
        Icon(Icons.Filled.Add, contentDescription = null)
    }
}