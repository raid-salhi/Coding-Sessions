package com.example.noteapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Favorite",
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
                containerColor = Color.Black,
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

            LazyColumn (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)){
                val notes = listOf(
                    Note(title = "Note title", body = "Lorem Ipsuum placeholder text for use in your graphic, print and web layouts, and discover plugins for your favorite writing, design and blogging tools.", category = "University",),
                    Note(title = "Note title", body = "Lorem Ipsuum placeholder text for use in your graphic, print and web layouts, and discover plugins for your favorite writing, design and blogging tools.", category = "Research"),
                    Note(title = "Note title", body = "Lorem Ipsuum placeholder text for use in your graphic, print and web layouts, and discover plugins for your favorite writing, design and blogging tools.", category = "University"),
                    Note(title = "Note title", body = "Lorem Ipsuum placeholder text for use in your graphic, print and web layouts, and discover plugins for your favorite writing, design and blogging tools.", category = "Research")
                )
                items(notes){ note ->
                    NoteCard(note,isHomeScreen = false)
                }
            }
        }
    }
}