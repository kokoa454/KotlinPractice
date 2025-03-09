package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonadeTextAndImage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LemonadeTextAndImage(modifier: Modifier = Modifier) {
    var currentOrder by remember { mutableIntStateOf(0) }
    var randomNum by remember { mutableIntStateOf((2..4).random()) }

    val imageResource = when(currentOrder){
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val textResource = when(currentOrder){
        0 -> R.string.first
        1 -> R.string.second
        2 -> R.string.third
        else -> R.string.forth
    }

    val descResource = when(currentOrder){
        0 -> R.string.firstDesc
        1 -> R.string.secondDesc
        2 -> R.string.thirdDesc
        else -> R.string.forthDesc
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF2D12A))
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Lemonade",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Button(
                onClick = {
                    if(currentOrder in 0..2){
                        if(currentOrder == 1 && randomNum > 1){
                            randomNum--
                        } else {
                            currentOrder++
                        }
                    } else {
                        currentOrder = 0
                        randomNum = (2..4).random()
                    }
                },
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xDDCAE5CD),
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(20.dp)
                ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = stringResource(descResource)
                )
            }
            Text(
                text = stringResource(textResource),
                modifier = Modifier.padding(top = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadePreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LemonadeTextAndImage(
            modifier = Modifier.padding(innerPadding)
        )
    }
}