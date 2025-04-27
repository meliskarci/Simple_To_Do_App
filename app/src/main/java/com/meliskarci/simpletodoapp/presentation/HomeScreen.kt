package com.meliskarci.simpletodoapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val viewModel = hiltViewModel<HomeScreenViewModel>()
    val todoList = viewModel.list.collectAsStateWithLifecycle()


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Home Screen")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.Add)
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddings ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = paddings
        ) {
            items(todoList.value.size) {
                Card(modifier = Modifier.clickable { navController.navigate(Screen.Detail(todoList.value[it].id)) }) {
                    Column {
                        Text(text = todoList.value[it].title)
                        Text(text = todoList.value[it].description)
                    }

                }
            }
        }
    }
}