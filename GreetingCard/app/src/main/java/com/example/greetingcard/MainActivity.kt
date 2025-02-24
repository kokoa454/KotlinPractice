package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //use onCreate() instead of main()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Greeting(
                    name = "Android",
                )
            }
        }
    }
}

@Composable //all composable functions should be done in setContent() and they cant return anything
fun Greeting(name: String) {
    Surface(color = Color.Magenta) {
        Text(
            text = "Hi, my name is $name!",
            modifier = Modifier.padding(24.dp) //Modifier is used for its design
        )
    }
}

@Preview(showBackground = true) //preview functions can be displayed in design panel
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        Greeting("Inari Goro")
    }
}