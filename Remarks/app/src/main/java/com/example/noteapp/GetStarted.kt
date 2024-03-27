package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.ui.theme.NoteAppTheme

@Preview(showBackground = true)
@Composable
fun GetStarted() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.checklist),
            contentDescription = "checklist",
            modifier = Modifier.padding(top = 192.dp)
        )
        Text(
            text = "Welcome !",
            fontSize = 30.sp,
            fontFamily = FontFamily(listOf(Font(R.font.inter_bold))),
            color = Color.Black,
            modifier = Modifier.padding(top = 11.dp)
        )
        Text(
            text = "Capture your ideas quickly and \n access them offline from \n anywhere",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontFamily = FontFamily(listOf(Font(R.font.inter_medium))),
            color = Color(0xff4B4B4B)
        )
        Button(
            onClick = {},
            shape = RectangleShape,
            modifier = Modifier
                .padding(top = 87.dp)
                //TODO("Don't set the width,use paddings in the Get Started Text and let the button take the appropriate size ")
                .size(height = 65.dp, width = 169.dp)
                .clip(RoundedCornerShape(20.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)

        ) {
            Text(
                text = "Get Started",
                fontSize = 16.sp,
                fontFamily = FontFamily(listOf(Font(R.font.poppins_medium))),
            )
        }

    }
}

