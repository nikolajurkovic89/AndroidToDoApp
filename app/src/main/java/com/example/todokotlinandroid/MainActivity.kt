package com.example.todokotlinandroid

import android.app.Activity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
               NavHost(
                   navController = navController,
                   startDestination = "categories"
               ) {
                   composable("categories") {
                       CategoriesView(
                           categoriesList = emptyList(),
                           onCategoryClick = {  navController.navigate("tasks") }
                       )
                   }

                   composable("tasks") {

                   }

               }
            }
        }

    }
}