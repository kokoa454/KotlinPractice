package com.example.businesscard

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Card(
                        name = stringResource(R.string.name),
                        title = stringResource(R.string.title),
                        phoneNumber = stringResource(R.string.phoneNumber),
                        id = stringResource(R.string.id),
                        email = stringResource(R.string.email),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Card(name: String, title: String, phoneNumber: String, id: String, email: String, modifier: Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF00053a))
            .padding(start = 40.dp, end = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Top(name, title, modifier)
        Bottom(phoneNumber, id, email, modifier)
    }
}

@Composable
fun Top(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.image),
            contentDescription = null,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Text(
            text = name,
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
fun Bottom(phoneNumber: String, id: String, email: String, modifier: Modifier = Modifier){
    Column{
        Row(
            modifier = Modifier.padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.phone),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = phoneNumber,
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.lightbulb),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = id,
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.email),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = email,
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Card(
                name = "Inari Goro",
                title = "Student Developer",
                phoneNumber = "+81 (000) 000 0000",
                id = "@kokoa454",
                email = "inariGoro@aiueo.co.jp",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}