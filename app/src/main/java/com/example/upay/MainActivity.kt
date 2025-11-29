package com.example.upay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.upay.ui.screens.HomeScreen
import com.example.upay.ui.screens.PinInputScreen
import com.example.upay.ui.theme.UpayTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Routes {
    const val PIN_INPUT = "pin_input_screen"
    const val HOME = "home_screen"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UpayTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                       UpayNavGraph()
                    }
            }
        }
    }
}

//Navigation Graph
@Composable
fun UpayNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.PIN_INPUT
    ) {
        //Pin Input Screen
        composable(Routes.PIN_INPUT) {
            PinInputScreen(
                //Navigate to Home Screen
                onPinVerified = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.PIN_INPUT) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        //Home Screen
        composable(Routes.HOME) {
            HomeScreen()
        }
    }
}