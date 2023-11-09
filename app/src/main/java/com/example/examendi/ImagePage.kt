package com.example.examendi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.examendi.ui.theme.letraExamen

@Composable
fun ShowImage(image: PlaceImage) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = image.name,
            fontWeight = FontWeight.Bold
        )

        Image(painter = painterResource(id = image.image), contentDescription = image.name)
    }
}