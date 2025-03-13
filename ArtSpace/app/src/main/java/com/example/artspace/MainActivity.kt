package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtSpaceTheme
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtContent(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun loadBitmapWithRotation(context: Context, resId: Int): Bitmap {
    val inputStream = context.resources.openRawResource(resId)
    val bitmap = BitmapFactory.decodeStream(inputStream) ?: return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)

    val matrix = Matrix().apply {
        postRotate(90f)  // rotate 90 degrees to right
    }

    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
}


@Composable
fun ArtContent(modifier: Modifier = Modifier) {
    var currentOrder by remember { mutableIntStateOf(0) }
    val context = LocalContext.current

    val imageResource = when(currentOrder){
        0 -> R.drawable.steak
        1 -> R.drawable.napoleon
        2 -> R.drawable.whitehouse
        3 -> R.drawable.national_theater
        4 -> R.drawable.osh_bazar
        5 -> R.drawable.fake_kumamon
        else -> R.drawable.bishkek_meltdown
    }

    val titleResource = when(currentOrder){
        0 -> R.string.steak
        1 -> R.string.napoleon
        2 -> R.string.whitehouse
        3 -> R.string.national_theater
        4 -> R.string.osh_bazar
        5 -> R.string.fake_kumamon
        else -> R.string.bishkek_meltdown
    }

    val artistResource = when(currentOrder){
        0 -> R.string.steak_artist
        1 -> R.string.napoleon_artist
        2 -> R.string.whitehouse_artist
        3 -> R.string.national_theater_artist
        4 -> R.string.osh_bazar_artist
        5 -> R.string.fake_kumamon_artist
        else -> R.string.bishkek_meltdown_artist
    }

    val bitmap = remember(imageResource) { loadBitmapWithRotation(context, imageResource) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 40.dp, start = 20.dp, end = 20.dp)
                .shadow(elevation = 20.dp)
                .background(Color.White)
        ){
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier.padding(24.dp)
            )
        }
        Column(
            modifier = Modifier
                .background(Color(0xFFD2D0E8))
                .padding(12.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Text(
                text = stringResource(titleResource),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(artistResource),
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        Row(
            modifier = Modifier.padding(top = 80.dp)
        ) {
            Button(
                modifier = Modifier.width(120.dp),
                onClick = {
                if(currentOrder in 1..6){
                    currentOrder--
                } else {
                    Toast.makeText(context, "前の写真はありません", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text(
                    text = "Previous"
                )
            }
            Spacer(modifier = Modifier.padding(28.dp))
            Button(
                modifier = Modifier.width(120.dp),
                onClick = {
                if(currentOrder in 0..5){
                    currentOrder++
                } else {
                    Toast.makeText(context, "後の写真はありません", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text(
                    text = "Next"
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtContentPreview() {
    ArtSpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ArtContent(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}