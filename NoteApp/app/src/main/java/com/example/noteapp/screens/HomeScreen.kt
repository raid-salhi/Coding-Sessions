package com.example.noteapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.noteapp.R
import com.example.noteapp.local.LocalDatabase
import com.example.noteapp.local.models.Note
import com.example.noteapp.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val context= LocalContext.current
    val database=LocalDatabase.getInstance(context)
    val notes=database.NoteDao().getAllNotes()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_medium))),
                        color = Color.Black,
                    )
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screens.AddNoteScreen.name)
                },
                contentColor = Color.White,
                containerColor = Black,
                shape = CircleShape,
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "add",
                )
            }
        },
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding(), end = 20.dp, start = 20.dp, bottom = 20.dp),
        ) {
            SearchBar()

            LazyColumn(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
            ) {
                items(notes) { note ->
                    NoteCard(note, isHomeScreen = true)
                }
            }
        }
    }
}

@Composable
fun NoteCard(
    note: Note,
    isHomeScreen: Boolean,
) {
    var isFav by remember {
        mutableStateOf(note.isFav)
    }
    Card(
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = note.title,
                fontSize = 16.sp,
                fontFamily = FontFamily(listOf(Font(R.font.poppins_medium))),
            )
            if (isHomeScreen) {
                IconButton(
                    onClick = {
                        isFav = !isFav
                        note.isFav = isFav
                    },
                    colors = IconButtonDefaults.iconButtonColors(contentColor = Color(0xffFFE500)),
                ) {
                    Icon(
                        painter = painterResource(id = if (isFav) R.drawable.star_rate_filled else R.drawable.star_rate_emptry),
                        contentDescription = "fav",
                        modifier = Modifier.size(30.dp),
                    )
                }
            }
        }
        Text(
            text = note.body,
            fontSize = 14.sp,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
            fontFamily = FontFamily(listOf(Font(R.font.poppins_regular))),
        )
        Box(
            modifier =
                Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (note.category == "University") {
                            Color(0xffFFBCBC)
                        } else {
                            Color(0xffFFECBC)
                        },
                    )
                    .align(Alignment.End),
        ) {
            Text(
                text = note.category,
                fontSize = 13.sp,
                modifier =
                    Modifier
                        .padding(vertical = 6.dp, horizontal = 12.dp),
                fontFamily = FontFamily(listOf(Font(R.font.poppins_regular))),
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(onSearch: (String) -> Unit = {}) {
    var value by remember {
        mutableStateOf(TextFieldValue())
    }
    val keyboard = LocalSoftwareKeyboardController.current
    TextField(
        value = value,
        onValueChange = {
            value = it
        },
        modifier =
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
        placeholder = {
            Text(
                text = "Search a title",
                fontSize = 14.sp,
                fontFamily = FontFamily(listOf(Font(R.font.poppins_medium))),
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Srarch",
                modifier = Modifier.size(24.dp),
            )
        },
        keyboardActions =
            KeyboardActions {
                onSearch(value.text)
                value = TextFieldValue(text = "")
                keyboard?.hide()
            },
        singleLine = true,
        colors =
            TextFieldDefaults.colors(
                focusedContainerColor = Color(0xffECECEC),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTrailingIconColor = Color(0xff323232),
                unfocusedTrailingIconColor = Color(0xff323232),
                unfocusedPlaceholderColor = Color(0xff898989),
                focusedLabelColor = Color.Transparent,
                unfocusedLabelColor = Color.Transparent,
            ),
    )
}
