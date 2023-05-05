package com.example.notescompose.feature_notes.presentation.screens.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AddEditScreen(
    modifier: Modifier = Modifier
) {

    val title = remember {
        mutableStateOf("")
    }
    val content = remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        Row(
            modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Cyan)
        ) {



        }



        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(0.1f),
                value = title.value,
                onValueChange = { title.value = it },
                singleLine = true
            )

            TextField(
                modifier = modifier
                    .fillMaxSize()
                    .weight(0.8f)
                    .verticalScroll(rememberScrollState()),
                value = content.value,
                onValueChange = {content.value = it}
            )

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(0.1f),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    modifier = modifier
                        .width(120.dp)
                        .height(40.dp),
                    onClick = { /*TODO*/ },

                    ) {
                    Text(text = "Create note")
                }
            }
        }
    }

}