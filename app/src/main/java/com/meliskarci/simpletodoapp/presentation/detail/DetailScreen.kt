package com.meliskarci.simpletodoapp.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.meliskarci.simpletodoapp.ui.theme.ArkaPlan
import com.meliskarci.simpletodoapp.ui.theme.CardRenk1
import com.meliskarci.simpletodoapp.ui.theme.CardRenk2
import com.meliskarci.simpletodoapp.ui.theme.GetPlayfairDisplay
import com.meliskarci.simpletodoapp.ui.theme.YazıRengi

//@Composable
//fun DetailScreen(navController: NavController) {
//
//    val viewModel = hiltViewModel<DetailViewModel>()
//    val todo = viewModel.todo.collectAsStateWithLifecycle()
//
//    Column (modifier = Modifier
//        .fillMaxSize()
//        .background(color = ArkaPlan)
//        .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        Card(
//            modifier = Modifier.fillMaxSize()
//                .fillMaxWidth(0.9f)
//                .heightIn(min = 200.dp, max = 400.dp),
//            shape = RoundedCornerShape(12.dp)
//
//        ) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.fillMaxWidth()
//            ) {Column(modifier = Modifier
//                .fillMaxSize()
//                .background(color = CardRenk1)
//                .padding(16.dp)
//                .alpha(0.6f)
//            ) {
//                Text(
//                    todo.value.title,
//                    color = YazıRengi,
//                    fontFamily = GetPlayfairDisplay(),
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                Text(
//                    todo.value.description,
//                    color = YazıRengi,
//                    fontFamily = GetPlayfairDisplay(),
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//
//
//                Switch(
//                    checked = todo.value.isCompleted,
//                    onCheckedChange = {
//                    }
//                )
//            }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Button(onClick = { navController.navigateUp() }) { Text("Back")
//        }
//    }
//
//
//}

@Composable
fun DetailScreen(navController: NavController) {

    val viewModel = hiltViewModel<DetailViewModel>()
    val todo = viewModel.todo.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ArkaPlan),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.85f).background(color = ArkaPlan)        // genişlik ekranın %85’i kadar
                    .heightIn(min = 200.dp, max = 250.dp).alpha(0.7f), // yükseklik sınırlı
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = ArkaPlan)
                        .padding(16.dp)

                    //horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {

                        Spacer(modifier = Modifier.width(8.dp))
                        Switch(
                            checked = todo.value.isCompleted,
                            onCheckedChange = {
                                // viewModel.onCheckChanged(it)
                            }
                        )
                    }
                    Text(
                        todo.value.title,
                        color = YazıRengi,
                        fontFamily = GetPlayfairDisplay(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        todo.value.description,
                        color = YazıRengi,
                        fontFamily = GetPlayfairDisplay(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )


                    Spacer(modifier = Modifier.height(24.dp))

                    Button(onClick = { navController.navigateUp() }) {
                        Text("Back")
                    }
                }


                }
            }


    }
}


