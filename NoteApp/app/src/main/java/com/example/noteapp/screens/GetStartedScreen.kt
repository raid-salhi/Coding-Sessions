package com.example.noteapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.noteapp.R
import com.example.noteapp.navigation.Screens

@Composable
fun GetStartedScreen(navController: NavHostController) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.get_started_img),
            contentDescription = "logo",
            modifier = Modifier.width(200.dp),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = "Welcome",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 10.dp),
        )
        Text(
            text = "Capture your ideas quickly and\n access them offline from\n anywhere",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xff4B4B4B),
        )
        Spacer(modifier = Modifier.height(80.dp))
        GetStartedButton {
            navController.navigate(Screens.HomeScreen.name)
        }
    }
}

@Composable
fun GetStartedButton(onclick: () -> Unit) {
    Box(
        modifier =
            Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Black)
                .clickable { onclick() },
    ) {
        Text(
            text = "Get started",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(vertical = 17.dp, horizontal = 38.dp),
        )
    }
}
