package com.example.planty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planty.ui.theme.MyBlack
import com.example.planty.ui.theme.MyGray
import com.example.planty.ui.theme.MyGreen
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
    val listOfPlants =
        listOf(
            Plant("Spider Plant","Great Plant",R.drawable.spider_plant),
            Plant("Song of India","Great Plant",R.drawable.song_of_india),
            Plant("Pink Anthurium","Great Plant",R.drawable.pink_anthurium),
            Plant("Black Love Anthurium","Great Plant",R.drawable.black_star),
            Plant("Grey Star Calarthea","Great Plant",R.drawable.grey_star),
            Plant("Banana Plant","Great Plant",R.drawable.banana_plant),
            )
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
                    end = 25.dp
                )
                .fillMaxSize(),
            ) {
            Text(
                text = "My Plants",
                fontSize = 24.sp,
                color = MyGreen,
                fontFamily = FontFamily(listOf(Font(R.font.lato_bold))),
                modifier = Modifier.padding(bottom = 15.dp)
            )
            LazyVerticalGrid(modifier = Modifier.fillMaxWidth(),columns = GridCells.Fixed(2), horizontalArrangement = Arrangement.SpaceBetween){
                items(items = listOfPlants){ plant ->
                    PlantCard(plant=plant)
                }
            }
        }
    }
}

@Composable
fun PlantCard(plant: Plant) {
    Column (Modifier.padding(bottom = 15.dp)) {
        Box (
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xffF2F2F2))

        ){
            Image(
                painter = painterResource(id = plant.img),
                contentDescription = "plant img",
                contentScale = ContentScale.Crop,
                modifier = Modifier.align(Alignment.BottomCenter).width(170.dp)
            )
        }
        Text(
            text = plant.name,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 5.dp),
            fontFamily = FontFamily(listOf(Font(R.font.lato_bold)))
        )
        Text(
            text = plant.description,
            fontSize = 14.sp,
            color = MyGray,
            fontFamily = FontFamily(listOf(Font(R.font.lato_reg)))
        )
    }
}

