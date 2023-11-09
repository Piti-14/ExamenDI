package com.example.examendi

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


data class PlaceImage(
    var name: String,
    @DrawableRes var image: Int
)

@Composable
fun AppContent(images: List<PlaceImage>, actualImage: PlaceImage, navController: NavController) {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(images) {
            CreateCard(image = it, navController = navController)
        }
    }
}

@Composable
fun CreateCard(image: PlaceImage, navController: NavController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                navController.navigate("ImagePage")
            }
    ) {
        
        Text(text = image.name)

        Image(
            painter = painterResource(id = image.image),
            contentDescription = image.name,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,

        )
    }
}