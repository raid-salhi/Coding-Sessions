package com.example.noteapp

import android.graphics.BlurMaskFilter
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun Categories() {
    //TODO("create category data class which contains title and color and create a list of this data class")
//TODO("use mutableStateListOf instead of mutableListOf and remove list")
    var categoryList = remember {
        mutableListOf(
            "university",
            "research",
            "university",
            "reaserch"
        )
    }
    var list by remember { mutableStateOf<List<String>>(categoryList) }



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Categories",
            fontSize = 16.sp,
            fontFamily = FontFamily(listOf(Font(R.font.poppins_medium))),
            modifier = Modifier.padding(top = 19.dp, end = 253.dp)
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(top = 27.dp)
        ) {
            itemsIndexed(items = list) { index, item ->
                CategoryCard(name = item, index = index)
            }
        }
        //TODO("You can use a scaffold and pass this  FloatingActionButton as attribute")
        FloatingActionButton(
            containerColor = Color.Black,
            shape = CircleShape,
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(start = 300.dp, bottom = 20.dp)
                .size(70.dp)
            //TODO("Or add .align(Alignment.End) to it , padding(start=300.dp) is not recommended")
        ) {
            //TODO("The + icon should be in one drawable,my bad i didn't create the group in figma :')")
            Icon(
                painterResource(id = R.drawable.line1),
                contentDescription = "line",
                tint = Color.White
            )
            Icon(
                painterResource(id = R.drawable.line2),
                contentDescription = "line",
                tint = Color.White
            )
        }
        //TODO("The implementation of this bottom navigation bar will change after implementing the navigation,good job anyway!")
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .customshadow(color = Color.Gray, blurRadius = 9.dp)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        painterResource(id = R.drawable.star),
                        contentDescription = "starlogo",
                        modifier=Modifier.size(30.dp),
                        tint=Color(0xff323232)
                    )
                    Text(
                        text = "Favorite",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_regular)))
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        painterResource(id = R.drawable.home),
                        contentDescription = "starlogo",
                        modifier = Modifier.size(30.dp),
                        tint = Color(0xff323232)
                    )
                    Text(
                        text="Home",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_regular)))
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(
                        painterResource(id = R.drawable.achkal),
                        contentDescription = "starlogo",
                        modifier = Modifier.size(30.dp),
                        tint=Color(0xff323232)
                    )
                    Text(
                        text="Categories",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.poppins_regular))))
                }
            }
        }
        //TODO("Don't forget to implement the add Category dialog")
    }
}



@Composable
fun CategoryCard(name:String = "category",index:Int =0){
    Surface(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(bottom = 10.dp)
            //TODO("Don't set the width")
            .size(height = 70.dp, width = 322.dp)
            .customshadow(color = Color.Gray, blurRadius = 5.dp, offsetY = 3.dp, offsetX = 2.dp)


    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ){
            Box(
                modifier = Modifier
                    .padding(start = 14.dp)
                    .size(35.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        if (index % 2 == 0) {
                            Color(0xffFFBCBC)
                        } else {
                            Color(0xffFFECBC)
                        }
                    )
            )
            Text(
                text = name,
                fontSize = 16.sp,
                fontFamily = FontFamily(listOf(Font(R.font.poppins_medium))),
                modifier = Modifier.padding(start=10.dp)
            )

        }
    }
}


fun Modifier.customshadow(
    color: Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
) = then(
    drawBehind {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter = (BlurMaskFilter(blurRadius.toPx(),BlurMaskFilter.Blur.NORMAL))
            }
            frameworkPaint.color = color.toArgb()

            val leftPixel = offsetX.toPx()
            val topPixel = offsetY.toPx()
            val rightPixel = size.width + topPixel
            val bottomPixel = size.height + leftPixel

            canvas.drawRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                paint = paint,
            )
        }
    }
)