package com.example.noteapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun Favorite() {
    //TODO("The same remarks mentioned in the Home screen")
    var homeList = remember {
        mutableListOf(
            "reaserch",
            "univerity",
            "reaserch"
        )
    }
    var list by remember { mutableStateOf<List<String>>(homeList) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = "Favorite",
            fontSize = 16.sp,
            fontFamily = FontFamily(listOf(Font(R.font.poppins_medium))),
            modifier = Modifier.padding(top = 19.dp, end = 294.dp)
        )
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(width = 322.dp, height = 47.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = Color(0xffECECEC))


        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Search a title",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(listOf(Font(R.font.poppins_medium))),
                    color = Color(0xff898989),
                    modifier = Modifier.padding(top = 13.dp, start = 22.dp)
                )
                Icon(
                    painterResource(id = R.drawable.search),
                    contentDescription = "search",
                    tint = Color(0xff323232),
                    modifier = Modifier.padding(start = 180.dp, top = 14.dp)
                )

            }
        }
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(top = 45.dp)
        ) {
            itemsIndexed(items = list) { index, item ->
                FavoriteCard(name = item, index = index)
            }
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .customshadow(color = Color.Gray, blurRadius = 9.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.star_rate),
                        contentDescription = "starlogo",
                        modifier = Modifier.size(30.dp),
                        tint = Color.Black
                    )
                    Text(
                        text = "Favorite",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_regular)))
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.home2),
                        contentDescription = "starlogo",
                        modifier = Modifier.size(30.dp),
                        tint = Color.Black
                    )
                    Text(
                        text = "Home",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_regular)))
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painterResource(id = R.drawable.achkal),
                        contentDescription = "starlogo",
                        modifier = Modifier.size(30.dp),
                        tint = Color(0xff323232)
                    )
                    Text(
                        text = "Categories",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_regular)))
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteCard(name:String = "category",index:Int =0) {
    Surface(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(bottom = 10.dp)
            .customshadow(color = Color.Gray, blurRadius = 5.dp, offsetY = 3.dp, offsetX = 2.dp)


    ) {
        Box(
            modifier = Modifier
                .padding(start = 19.dp)
                .size(width = 322.dp, height = 176.dp)
                .clip(RoundedCornerShape(5.dp))


        ) {


            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                        text = "Note Title",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_medium))),
                        modifier = Modifier.padding(start = 11.dp, top = 7.dp)
                    )

                Text(
                    text = "Lorem Ipsum placeholder text for use in   your graphic, print and web layouts, and discover plugins for your favorite writing, design and blogging tools.",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(listOf(Font(R.font.poppins_regular))),
                    color = Color(0xff4B4B4B),
                    modifier = Modifier.padding(start = 11.dp, top = 6.dp)
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 212.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(if(index%2==0){Color(0xffFFECBC)} else{ Color(0xffFFBCBC)})
                        .size(width = 98.dp, height = 32.dp)

                ) {
                    Text(
                        text = name,
                        fontSize = 13.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_regular))),
                        color = Color.Black,
                    )
                }
            }
        }
    }
}