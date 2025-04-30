package com.meliskarci.simpletodoapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.meliskarci.simpletodoapp.navigation.Screen
import com.meliskarci.simpletodoapp.ui.theme.ArkaPlan
import com.meliskarci.simpletodoapp.ui.theme.CardRenk1
import com.meliskarci.simpletodoapp.ui.theme.GetPlayfairDisplay
import com.meliskarci.simpletodoapp.ui.theme.YazıRengi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val viewModel = hiltViewModel<HomeScreenViewModel>()
    val todoList = viewModel.list.collectAsStateWithLifecycle()


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("To Do List", color = YazıRengi, fontFamily = GetPlayfairDisplay(), fontSize = 25.sp, fontWeight = FontWeight.Bold)


                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = ArkaPlan )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.Add)
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        containerColor = ArkaPlan
    ) { paddings ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(color = ArkaPlan).padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),

            contentPadding = paddings
        ) {
            items(todoList.value.size) {
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxSize()
                        .shadow(15.dp)
                        .clickable { navController.navigate(Screen.Detail(todoList.value[it].id)) },
                    shape = RoundedCornerShape(12.dp)) {





                        Column(
                        modifier = Modifier
                            .background(color = CardRenk1)
                            .fillMaxSize()
                            .padding(15.dp)
                    )
                    {
                        IconButton(
                            onClick = {
                                viewModel.deleteTodo(todoList.value[it].id)
                            },modifier = Modifier.align(Alignment.End)

                        ) { Icon(imageVector = Icons.Default.Delete,
                            contentDescription = "Edit", tint = YazıRengi)}
                        //Spacer(modifier = Modifier.height(1.dp))

                        Text(text = todoList.value[it].title,
                            color = YazıRengi,
                            fontFamily = GetPlayfairDisplay(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = todoList.value[it].description,
                            color = YazıRengi,
                            fontFamily = GetPlayfairDisplay())
                        //Spacer(modifier = Modifier.height(1.dp))
                        IconButton(
                            onClick = {
                                navController.navigate(Screen.Detail(todoList.value[it].id))
                            },modifier = Modifier.align(Alignment.End)

                        ) { Icon(imageVector = Icons.Default.Edit,
                            contentDescription = "Edit", tint = YazıRengi)}
                    }


                }

            }
        }
    }
}

