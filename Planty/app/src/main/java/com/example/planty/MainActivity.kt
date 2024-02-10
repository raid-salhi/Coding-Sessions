package com.example.planty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planty.ui.theme.MyBlack
import com.example.planty.ui.theme.PlantyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlantyTheme {
                AppScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        text = "Planty App",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.lato_reg)))
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(id = R.drawable.back), contentDescription = "back button")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(painter = painterResource(id = R.drawable.cart), contentDescription = "back button")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White,
                    navigationIconContentColor = MyBlack,
                    actionIconContentColor = MyBlack,
                    titleContentColor = MyBlack
                    )
            )
        },
        containerColor = Color.White
    ) {
        Column (
            modifier = Modifier
                .padding(
                    top = it.calculateTopPadding() + 20.dp,
                    bottom = 25.dp,
                    start = 25.dp,
                    end= 25.dp
                    )
                .fillMaxSize(),
            ) {

        }
    }
}

