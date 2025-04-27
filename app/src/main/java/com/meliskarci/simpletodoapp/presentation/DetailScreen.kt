package com.meliskarci.simpletodoapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController) {

    val viewModel = hiltViewModel<DetailViewModel>()
    val todo = viewModel.todo.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(todo.value.title)
        Text(todo.value.description)
        Switch(
            checked = todo.value.isCompleted,
            onCheckedChange = {

            }
        )
        Button(
            onClick = {
                navController.navigateUp()
            }
        ) {
            Text("Geri Dön")
        }
    }
}