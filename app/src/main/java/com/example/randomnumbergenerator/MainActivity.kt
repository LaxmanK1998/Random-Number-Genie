package com.example.randomnumbergenerator // Ensure this matches your actual package name exactly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomnumbergenerator.ui.theme.RandomNumberGeneratorTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Wraps your app in your project's styling theme
            RandomNumberGeneratorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // This explicitly tells Android to show your custom screen
                    NumberGeneratorScreen()
                }
            }
        }
    }
}

@Composable
fun NumberGeneratorScreen() {
    var randomNumber by remember { mutableStateOf("-") }

    // Box allows elements to layer directly on top of each other
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Layer 1: The textbook math image spanning the full background
        Image(
            painter = painterResource(id = R.drawable.math_bg),
            contentDescription = "Mathematical Textbook Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Fits your screen without warping proportions
        )

        // Layer 2: Your text and buttons arranged cleanly down the middle
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Your Random Number:",
                fontSize = 20.sp,

                fontWeight = FontWeight.Medium,
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = randomNumber,
                fontSize = 72.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    // Pulls a random value up to (and including) 100
                    val randomVal = Random.nextInt(1, 101)
                    randomNumber = randomVal.toString()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = androidx.compose.ui.graphics.Color.Red, // Background color
                    contentColor = androidx.compose.ui.graphics.Color.White   // Text color inside the button
                )
            ) {
                Text(text = "Generate", fontSize = 18.sp)
            }
        }
    }
}