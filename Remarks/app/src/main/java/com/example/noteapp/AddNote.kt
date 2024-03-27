package com.example.noteapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun AddNote(){
    //TODO("add a mutableStateOf for both note title and body")
    var categoryName = "Title"
//TODO(It's preferable to use a scaffold with actions...)
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.keyboard_arrow_left),
                contentDescription = "arrow hh",
                tint = Color(0xff323232),
                modifier = Modifier.padding(start = 11.dp).weight(1f)
            )
            Icon(
                painterResource(id = R.drawable.restore_from_trash),
                contentDescription = "arrow hh",
                tint = Color(0xff323232),
                //TODO(".padding(start = 252.dp) is not recommended")
                modifier = Modifier.padding(start = 252.dp)
            )
            Icon(
                painterResource(id = R.drawable.star),
                contentDescription = "arrow hh",
                tint = Color(0xff323232),
                //TODO("add end padding")
                modifier = Modifier.padding(start = 23.dp)
            )
        }
        //TODO("This is not a box it 's just a special text field")
        Box(
            modifier = Modifier
                .padding(top = 19.dp)
                .size(width = 322.dp, height = 47.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = Color(0xffECECEC))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Choose a category",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(listOf(Font(R.font.poppins_medium))),
                    color = Color(0xff898989),
                    modifier = Modifier.padding(top = 13.dp, start = 22.dp)
                )
                Icon(
                    painterResource(id = R.drawable.keyboard_arrow_left),
                    contentDescription = "search",
                    tint = Color(0xff898989),
                    modifier = Modifier
                        .padding(start = 125.dp, top = 9.dp)
                        .graphicsLayer { rotationZ = -90f }
                )
            }
        }
        Spacer(modifier = Modifier.size(height= 28.dp, width = 317.dp))
//TODO("This title is for the Note title not for the category")
        TextField(
            value = categoryName,
            onValueChange = { categoryName = it },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color(0xFF8B8B8B),
                focusedTextColor = Color(0xFF250055),
                unfocusedIndicatorColor = Color(0xFF8B8B8B),
                focusedIndicatorColor = Color(0xFF250055),
            ),

            placeholder = {
                Text(
                    text = "Title",
                    fontSize = 16.sp,
                    color = Color(0xFF8B8B8B),
                    modifier = Modifier.padding(5.dp),
                    fontFamily = FontFamily(listOf(Font(R.font.poppins_medium)))

                )
            },
            modifier = Modifier.padding(bottom = 6.28.dp)
        )
        //TODO("And this is for the note body")
            Text(
                text = "Lorem Ipsum placeholder text for use in your graphic, print and web layouts, and discover plugins for your favorite writing, design and blogging tools.\n" +
                        "Lorem Ipsum placeholder text for use in your graphic, print and web layouts, and discover plugins for your favorite writing, design and blogging tools.\n" +
                        "Lorem Ipsum placeholder text for use in your graphic, print and web layouts, and discover plugins for your favorite writing, design and blogging tools.\n" +
                        "Lorem Ipsum placeholder text for use in your graphic, print and web layouts, and discover plugins for your favorite writing, design and blogging tools.",
                fontSize = 14.sp,
                color = Color.Black,
                fontFamily = FontFamily(listOf(Font(R.font.poppins_regular))),
                modifier = Modifier
                    .size(width = 299.dp, height = 591.dp)
                    .padding(top = 28.dp),
            )
    }
  }
