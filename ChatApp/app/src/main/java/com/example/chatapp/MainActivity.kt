package com.example.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.window.Dialog
import com.example.chatapp.ui.theme.ChatAppTheme
import com.example.chatapp.ui.theme.background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
             Content()

            }
        }
    }
}

@Composable
fun Content(){
    var name by remember {
        mutableStateOf("User")
    }
    var showDialog by remember {
        mutableStateOf(false)
    }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Column(
            Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "")
            Text(
                text = "Say Hi!",
                color = Color.White,
                fontSize = 20.sp,

            )

        }
        Text(
            text = name,
            color = Color.White,
            fontSize = 16.sp,

        )
        Button(
            onClick = {
                      showDialog=true
                      },
            modifier = Modifier.clip(RoundedCornerShape(20.dp)),
            colors =ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
            ) {
            Text(
                text = "Enter your name",
                color = background,
                fontSize = 16.sp,
               )



        }

    }
    if(showDialog) {
        var dialogName by remember {
            mutableStateOf("")
        }
        Dialog(onDismissRequest = {
            showDialog=false
        }) {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ){
                Column {
                    Text(
                        text = "Enter your name",
                        color = background,
                        fontSize = 16.sp,
                        )


                    TextField(
                        value = dialogName,
                        onValueChange = {
                            dialogName=it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        placeholder = {
                            Text(
                                text = "Name",
                                color = Color.Gray,
                                fontSize = 16.sp,
                                fontFamily = FontFamily(listOf(
                                    Font(R.font.poppins_medium)
                                ))

                            )
                        }
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Cancel",
                            color = Color.Gray,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(listOf(
                                Font(R.font.poppins_medium),
                            )),
                            modifier = Modifier
                                .clickable {
                                    showDialog = false
                                }
                                .padding(10.dp),


                        )
                        Text(
                            text = "Set",
                            color = background,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .clickable {
                                    name = dialogName
                                    showDialog = false
                                }
                                .padding(top = 10.dp)

                        )

                    }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChatAppTheme {
       Content()

    }
}