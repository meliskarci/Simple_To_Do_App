package com.meliskarci.simpletodoapp.presentation.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.meliskarci.simpletodoapp.data.local.TodoEntity


@Composable
fun AddScreen(navController: NavController) {

    val viewModel = hiltViewModel<AddViewModel>()

    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.surface).padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        TextField(modifier = Modifier.background(color = MaterialTheme.colorScheme.surfaceContainer),
            value = title.value,
            placeholder = { Text ("Title", color = LightGray) },
            onValueChange = {
                title.value = it
            }
        )
        Spacer(Modifier.height(30.dp))
        TextField(modifier = Modifier.background(color = MaterialTheme.colorScheme.surfaceContainer),
            value = description.value,
            placeholder = { Text("Description", color = LightGray) },
            onValueChange = {
                description.value = it
            }
        )
        Spacer(Modifier.height(15.dp))

        Row(horizontalArrangement = Arrangement.Center , modifier = Modifier.padding(16.dp)) {
        Button(colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            onClick = {
                val todo = TodoEntity(title = title.value, description = description.value)
                viewModel.insertTodo(todo)
                navController.navigateUp()
            }
        ) {
            Text("Add", color = MaterialTheme.colorScheme.onPrimary)
        }
            Spacer(Modifier.width(10.dp))

            Button(colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                onClick = {
                    navController.navigateUp()
                }
            ){
                Text("Back", color = MaterialTheme.colorScheme.onPrimary)
            } }

    }
}