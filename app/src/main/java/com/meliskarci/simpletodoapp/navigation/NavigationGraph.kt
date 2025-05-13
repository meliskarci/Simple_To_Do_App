package com.meliskarci.simpletodoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meliskarci.simpletodoapp.navigation.Screen.Add
import com.meliskarci.simpletodoapp.navigation.Screen.Detail
import com.meliskarci.simpletodoapp.navigation.Screen.Home
import com.meliskarci.simpletodoapp.presentation.add.AddScreen
import com.meliskarci.simpletodoapp.presentation.detail.DetailScreen
import com.meliskarci.simpletodoapp.presentation.home.HomeScreen
import com.meliskarci.simpletodoapp.presentation.update.UpdateScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home,
    ) {
        composable<Home> {
            HomeScreen(navController)
        }
        composable<Detail> {
            DetailScreen(navController)
        }
        composable<Add> {
            AddScreen(navController)
        }
        composable<Screen.Update> {
            UpdateScreen(navController)
        }

    }
}