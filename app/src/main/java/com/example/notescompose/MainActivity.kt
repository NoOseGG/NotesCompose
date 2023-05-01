package com.example.notescompose

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notescompose.di.AppComponent
import com.example.notescompose.di.DaggerAppComponent
import com.example.notescompose.feature_notes.data.data_source.NoteDao
import com.example.notescompose.feature_notes.domain.model.Note
import com.example.notescompose.ui.theme.NotesComposeTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var noteDao: NoteDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent = DaggerAppComponent.factory().create(this)
        appComponent.inject(this)

        setContent {
            NotesComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesComposeTheme {
        Greeting("Android")
    }
}