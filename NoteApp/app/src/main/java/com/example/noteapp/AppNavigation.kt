package com.example.noteapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashScreen.name) {
        composable(route = Screens.SplashScreen.name) {
            SplashScreen(navController)
        }
        composable(route = Screens.HomeScreen.name) {
            HomeScreen(navController)
        }
        composable(route = Screens.GetStartedScreen.name) {
            GetStartedScreen(navController)
        }
        composable(route = Screens.FavoriteScreen.name) {
            FavoriteScreen(navController)
        }
//        composable(route = Screens.CategoryScreen.name) {
//            CategoryScreen(navController)
//        }
//        composable(route = Screens.AddNoteScreen.name) {
//            AddNoteScreen(navController)
//        }
    }
}
@Composable
fun MyBottomBar(navController: NavController) {

    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White,
        tonalElevation = 10.dp
    ) {
        val bottomNavItems = listOf(
            BottomNavItem("Favorite",R.drawable.fav,Screens.FavoriteScreen.name),
            BottomNavItem("Home",R.drawable.home,Screens.HomeScreen.name),
            BottomNavItem("Category",R.drawable.cat,Screens.CategoryScreen.name),
        )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination=navBackStackEntry?.destination
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 38.dp, end = 38.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            bottomNavItems.forEach {
                BottomNavItemOption(
                    item=it,
                    selected=it.route== currentDestination?.route?.split("?")?.get(0),
                ){
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            }

        }
    }

}

@Composable
fun BottomNavItemOption(item: BottomNavItem, selected: Boolean, onClick: () -> Unit) {
    Column(modifier = Modifier.clickable { onClick() }, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription ="icon" ,
            modifier = Modifier.size(26.dp),
            tint = if (selected) Black else Color(0xff323232)
        )
        Text(
            text = item.name,
            fontSize = 12.sp,
            color =  if (selected) Black else Color(0xff323232),
            fontFamily = FontFamily(listOf(Font(R.font.poppins_regular)))
        )
    }

}