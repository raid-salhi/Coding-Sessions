package com.example.noteapp.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.screens.CategoriesScreen
import com.example.noteapp.screens.FavoriteScreen
import com.example.noteapp.screens.GetStartedScreen
import com.example.noteapp.screens.HomeScreen
import com.example.noteapp.R
import com.example.noteapp.screens.AddNoteScreen
import com.example.noteapp.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        if (
            navController.currentBackStackEntryAsState().value?.destination?.route == Screens.HomeScreen.name ||
            navController.currentBackStackEntryAsState().value?.destination?.route == Screens.FavoriteScreen.name ||
            navController.currentBackStackEntryAsState().value?.destination?.route == Screens.CategoriesScreen.name
        ){
                MyBottomBar(navController)
        }

    }){
        NavHost(navController = navController, startDestination = Screens.SplashScreen.name, modifier = Modifier.padding(it)) {
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
        composable(route = Screens.CategoriesScreen.name) {
           CategoriesScreen(navController)
        }
        composable(route = Screens.AddNoteScreen.name) {
            AddNoteScreen(navController)
        }
        }
    }

}
@Composable
fun MyBottomBar(navController: NavController) {

    BottomAppBar(
        modifier = Modifier.fillMaxWidth().shadow(10.dp),
        containerColor = Color.White,
    ) {
        val bottomNavItems = listOf(
            BottomNavItem("Favorite",R.drawable.fav, Screens.FavoriteScreen.name),
            BottomNavItem("Home",R.drawable.home, Screens.HomeScreen.name),
            BottomNavItem("Category",R.drawable.cat, Screens.CategoriesScreen.name),
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