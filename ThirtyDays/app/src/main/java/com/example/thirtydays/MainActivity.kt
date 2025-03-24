package com.example.thirtydays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thirtydays.data.Datasource
import com.example.thirtydays.ui.theme.ThirtyDaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirtyDaysTheme {
                Scaffold(
                    topBar = { ThirtyDaysTopAppBar() },
                    content = { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            ThirtyDaysApp()
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysTopAppBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "30 Days of Wellness",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 28.sp
            )
        }
    )
}

@Composable
fun ThirtyDaysApp() {
    val layoutDirection = LocalLayoutDirection.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding(layoutDirection)
            )
    ) {
        WellnessList(wellnessList = Datasource().loadWellness(), modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp))
    }
}