package com.example.challenge1

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge1.data.Card
import com.example.challenge1.data.Finance
import com.example.challenge1.ui.theme.Challenge1Theme

class MainActivity2: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Challenge1Theme {

                HomeScreen()

            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun HomeScreen() {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            WalletSection()
            CardsSection()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSection()

        }
    }
    @Composable
    fun WalletSection() {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(
                    text = "Wallet",
                    fontSize = 10.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$ 44.475",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }

            Box(
                modifier = Modifier
                    .clip(RectangleShape)
                    .background(Color.LightGray)
                    .padding(6.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search",
                    tint = Color.Black
                )
            }

        }
    }
    val cards = listOf(

        Card(
            cardType = "VISA",
            cardNumber = "3664 7865 3786 3976",
            cardName = "Business",
            balance = 46.467,
        ),

        Card(
            cardType = "MASTER CARD",
            cardNumber = "234 7583 7899 2223",
            cardName = "Savings",
            balance = 6.467,
        ),

        Card(
            cardType = "VISA",
            cardNumber = "0078 3467 3446 7899",
            cardName = "School",
            balance = 3.467,
        ),

        Card(
            cardType = "MASTER CARD",
            cardNumber = "3567 7865 3786 3976",
            cardName = "Trips",
            balance = 26.47,
        ),
    )



    @Composable
    fun CardsSection() {
        LazyRow {
            items(cards.size) { index ->
                CardItem(index)
            }
        }
    }

    @Composable
    fun CardItem(
        index: Int
    ) {
        val card = cards[index]

        val image = if (card.cardType == "MASTER CARD") {
            painterResource(id = R.drawable.ic_mastercard)
        } else{
            painterResource(id = R.drawable.ic_visa)
        }
        Box(
            Modifier.padding(0.dp)
        ){
            Column(
                modifier = Modifier
                    .clip(RectangleShape)
                    .background(Color.Blue)
                    .width(250.dp)
                    .height(160.dp)
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    painter = image,
                    contentDescription = card.cardName,
                    modifier = Modifier.width(60.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = card.cardName,
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$ ${card.balance}",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = card.cardNumber,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }

    @Composable
    fun FinanceSection() {
        val financeList = listOf(
            Finance(
                icon = Icons.Rounded.Star,
                name = "My\nBusiness",
                background = Color.Red
            ),

            Finance(
                icon = Icons.Rounded.Star,
                name = "My\nWallet",
                background = Color.Blue
            ),

            Finance(
                icon = Icons.Rounded.Star,
                name = "Finance\nAnalytics",
                background =Color.Green
            ),

            Finance(
                icon = Icons.Rounded.Star,
                name = "My\nTransactions",
                background = Color.Cyan
            ),
        )

       //Hint: add the new item to this list
        var list by remember {
            mutableStateOf(financeList)
        }
        Column {
            Text(
                text = "Finance",
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            //TODO("implement the horizontal cards here")

            //TODO("Than make the add button here, when click show the dialog,good luck :)")

        }

    }


}
