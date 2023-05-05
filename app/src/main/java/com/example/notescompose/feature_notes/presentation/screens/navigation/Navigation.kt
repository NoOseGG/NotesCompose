package com.example.notescompose.feature_notes.presentation.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notescompose.feature_notes.presentation.screens.FeedScreen
import com.example.notescompose.feature_notes.presentation.screens.FeedViewModel
import com.example.notescompose.feature_notes.presentation.screens.HomeScreen
import com.example.notescompose.feature_notes.presentation.screens.screens.AddEditScreen

sealed class Screen(val route: String) {

    object HomeScreen: Screen("home_screen")
    object AddEditScreen: Screen("add_edit_screen")
}

@Composable
fun Navigation(feedViewModel: FeedViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        composable(Screen.HomeScreen.route) {
            HomeScreen(feedViewModel = feedViewModel, navController = navController)
        }

        composable(Screen.AddEditScreen.route) { entry ->
            AddEditScreen()
        }
    }
}