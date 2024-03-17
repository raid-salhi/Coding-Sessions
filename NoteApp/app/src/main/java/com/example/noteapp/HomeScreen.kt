package com.example.noteapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = "Home",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_medium))),
                        color = Color.Black
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                contentColor = Color.White,
                containerColor = Black,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription ="add",
                )
            }
        }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding(), end = 20.dp, start = 20.dp, bottom = 20.dp)
        ){
            SearchBar()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(onSearch:  (String) -> Unit = {}) {
    var value by remember {
        mutableStateOf(TextFieldValue())
    }
    val keyboard= LocalSoftwareKeyboardController.current
    TextField(
        value = value ,
        onValueChange = {
            value=it
        },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        placeholder = {
            Text(
                text = "Search a title",
                fontSize =14.sp,
                fontFamily = FontFamily(listOf(Font(R.font.poppins_medium)))
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Srarch",
                modifier = Modifier.size(24.dp)
            )
                       },
        keyboardActions = KeyboardActions {
            onSearch(value.text)
            value= TextFieldValue(text = "")
            keyboard?.hide()
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xffECECEC),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTrailingIconColor = Color(0xff323232),
            unfocusedTrailingIconColor = Color(0xff323232),
            unfocusedPlaceholderColor = Color(0xff898989),
            focusedLabelColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent
        ),
    )
}