package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tile(
                        topMessage1Title = "Text composable",
                        topMessage1 = "Displays text and follows the recommended Material Design guidelines.",
                        topMessage2Title = "Image composable",
                        topMessage2 = "Creates a composable that lays out and draws a given Painter class object.",
                        bottomMessage1Title = "Row composable",
                        bottomMessage1 = "A layout composable that places its children in a horizontal sequence.",
                        bottomMessage2Title = "Column composable",
                        bottomMessage2 = "A layout composable that places its children in a vertical sequence.",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Tile(
    topMessage1Title: String,
    topMessage1: String,
    topMessage2Title: String,
    topMessage2: String,
    bottomMessage1Title: String,
    bottomMessage1: String,
    bottomMessage2Title: String,
    bottomMessage2: String,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopMessage(topMessage1Title, topMessage1, topMessage2Title, topMessage2, modifier = Modifier.weight(1f))
        BottomMessage(bottomMessage1Title, bottomMessage1, bottomMessage2Title, bottomMessage2, modifier = Modifier.weight(1f))
    }
}

@Composable
fun TopMessage(topMessage1Title: String, topMessage1: String, topMessage2Title: String, topMessage2: String, modifier: Modifier){
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(
                    color = Color(0xFFEADDFF)
                )
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = topMessage1Title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = topMessage1,
                textAlign = TextAlign.Justify
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .background(
                    color = Color(0xFFD0BCFF)
                )
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = topMessage2Title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = topMessage2,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun BottomMessage(bottomMessage1Title: String, bottomMessage1: String, bottomMessage2Title: String, bottomMessage2: String, modifier: Modifier){
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(
                    color = Color(0xFFB69DF8)
                )
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = bottomMessage1Title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = bottomMessage1,
                textAlign = TextAlign.Justify
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .background(
                    color = Color(0xFFF6EDFF)
                )
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = bottomMessage2Title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = bottomMessage2,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TilePreview() {
    ComposeQuadrantTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Tile(
                topMessage1Title = "Text composable",
                topMessage1 = "Displays text and follows the recommended Material Design guidelines.",
                topMessage2Title = "Image composable",
                topMessage2 = "Creates a composable that lays out and draws a given Painter class object.",
                bottomMessage1Title = "Row composable",
                bottomMessage1 = "A layout composable that places its children in a horizontal sequence.",
                bottomMessage2Title = "Column composable",
                bottomMessage2 = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}