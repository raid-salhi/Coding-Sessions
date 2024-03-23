package com.example.noteapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.noteapp.R
import com.example.noteapp.navigation.Screens
import com.example.noteapp.sharedPref.SharedPreferencesManager
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val context= LocalContext.current
    val pref=SharedPreferencesManager(context)
    LaunchedEffect(key1 = 1) {
        delay(2000)
        if(pref.started=="started"){
            navController.navigate(Screens.HomeScreen.name)
        }else{
            pref.started="started"
            navController.navigate(Screens.GetStartedScreen.name)
        }

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.width(120.dp),
            contentScale = ContentScale.Crop,
        )
    }
}
