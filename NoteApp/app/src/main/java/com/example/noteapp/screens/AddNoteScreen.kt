package com.example.noteapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.noteapp.R
import com.example.noteapp.local.models.Category

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun AddNoteScreen(navController: NavHostController) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_left),
                        contentDescription = "back",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {
                                navController.navigateUp()
                            }
                        )
                },
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.trash),
                        contentDescription = "delete",
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .clickable {
                                //TODO("delete note")
                            }
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.star_rate_emptry),
                        contentDescription = "fav",
                        tint = Color.Black,
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .clickable {
                                //TODO("make note favorite")
                            }
                    )

                }
            )
        },
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding(), end = 20.dp, start = 20.dp, bottom = 20.dp)
        ){
            var expanded by remember {
                mutableStateOf(false)
            }
            var category by remember {
                mutableStateOf("")
            }
            var title by remember {
                mutableStateOf("")
            }
            var description by remember {
                mutableStateOf("")
            }
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                },
            ) {


                TextField(value = category, onValueChange = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                        .clip(RoundedCornerShape(10.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xffECECEC),
                        unfocusedContainerColor = Color(0xffECECEC),
                        unfocusedIndicatorColor = Color.Black,
                        focusedIndicatorColor = Color.Black
                    ),
                    placeholder = {
                        Text(
                            text = "Choose a category",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            fontFamily = FontFamily(listOf(Font(R.font.poppins_medium)))
                            )
                    },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )
                    }, readOnly = true

                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    },
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                ) {
                        listOf(
                            Category("University",0xff123456),
                            Category("University",0xff123456),
                            Category("University",0xff123456),
                            Category("University",0xff123456),
                            ).forEachIndexed() { position, selectionOption ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = selectionOption.name,
                                        color = Color.Black,
                                        fontSize = 16.sp
                                    )
                                },
                                onClick = {
                                    category =  selectionOption.name
                                    expanded = false
                                }
                            )
                        }

                }
            }
            TextField(value = title, onValueChange = {
                title=it
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .padding(top = 10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.Black,
                    focusedIndicatorColor = Color.Black
                ),
                placeholder = {
                    Text(
                        text = "Title",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_regular)))
                    )
                }
            )
            TextField(value = description, onValueChange = {
                description=it
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .padding(top = 10.dp),
                minLines = 20,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.Black,
                    focusedIndicatorColor = Color.Black
                ),
                placeholder = {
                    Text(
                        text = "Description",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_regular)))
                    )
                }
            )
        }
    }}