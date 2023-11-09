package com.example.examendi

import android.content.res.Resources.Theme
import android.graphics.drawable.Icon
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.examendi.ui.theme.ExamenDITheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var images by rememberSaveable {
                mutableStateOf(
                    listOf(
                        PlaceImage("Morella", R.drawable.image),
                        PlaceImage("Lugo", R.drawable.image1),
                        PlaceImage("Bangkok", R.drawable.image2),
                        PlaceImage("Peru", R.drawable.image3),
                        PlaceImage("Pekin", R.drawable.image4),
                        PlaceImage("Granada", R.drawable.image5),
                        PlaceImage("Atenas", R.drawable.image6),
                        PlaceImage("Yucatan", R.drawable.image7),
                        PlaceImage("Seychelles", R.drawable.image8),
                    )
                )
            }

            var actualImage by rememberSaveable {
                mutableStateOf(images.get(0))
            }
            ExamenDITheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Scaffold(
                    topBar = { MyTopBar() },
                    floatingActionButton = { FAB(navController) },
                    floatingActionButtonPosition = FabPosition.End

                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = it.calculateBottomPadding())
                    ) {
                        NavHost(navController = navController, startDestination = "MainScreen") {
                            composable("MainScreen") { AppContent(images, actualImage, navController) }
                            composable("ImagePage") { ShowImage(actualImage) }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun FAB(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.BottomEnd
    ){
        var context = LocalContext.current

        Button(
            onClick = {
                navController.navigate("MainScreen")
            }
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Previous")
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    TopAppBar(
        title = { Text(text = "PlacesInTheWorld")},
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Options")
            }
        }
    )
}