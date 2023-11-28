package com.example.mlkitexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mlkitexample.ui.theme.MLKitExampleTheme
import com.example.mlkitexample.View.BottomBar
import androidx.compose.material.Scaffold
import com.example.mlkitexample.View.SingleVideoPicker

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MLKitExampleTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "single") {
                    composable("home") {
                        Scaffold(
                            bottomBar = {
                                BottomBar(
                                    navController = navController
                                )
                            },
                        ) { contentPadding ->
                            Home()
                        }
                    }
                    composable("single") {
                        Scaffold(
                            bottomBar = {
                                BottomBar(
                                    navController = navController
                                )
                            },
                        ) { contentPadding ->
                            SinglePhotoPicker()
                        }
                    }
//                    composable("multi") {
//                        Scaffold(
//                            bottomBar = {
//                                BottomBar(navController = navController)
//                            },
//                        ){ contentPadding ->
//                            MultiplePhotoPicker()
//                        }
//                    }

                    composable("video") {
                        Scaffold(
                            bottomBar = {
                                BottomBar(navController = navController)
                            },
                        ){ contentPadding ->
                            SingleVideoPicker()
                        }
                    }
                    /*...*/
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MLKitExampleTheme {
        Greeting("Android")
    }
}