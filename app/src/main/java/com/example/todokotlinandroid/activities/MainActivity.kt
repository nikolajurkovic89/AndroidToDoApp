package com.example.todokotlinandroid

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todokotlinandroid.features.categories.CategoriesScreen
import com.example.todokotlinandroid.features.categories.CategoriesViewModel

class MainActivity : AppCompatActivity() {

    companion object{
        const val CATEGORIES = "categories"
        const val ADD_CATEGORY = "add_category"
    }

    @ExperimentalUnitApi
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
                   composable(CATEGORIES) {
                       val viewModel = CategoriesViewModel(
                           onAddCategory = {navController.navigate(ADD_CATEGORY)}
                       )
                       CategoriesScreen(viewModel)
                   }

                   composable("tasks") {

                   }

               }
            }
        }

    }
}