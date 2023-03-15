package com.example.tipcalculator

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.movies.MoviesActivity
import com.example.tipcalculator.news.NewsListActivity
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import java.util.*

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greetings(name = "Uma")
                }
            }
        }

    }
}

@Composable
fun NavigateToSecondActivity() {
    val context = LocalContext.current
    val intent = Intent(context, SecondActivity::class.java)
    context.startActivity(intent)
}

@Composable
fun Greetings(name: String) {
    Box {
        val image = painterResource(id = R.drawable.jpg_44)
        Image(
            painter = image, contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Column {
            Text(
                text = "Hello $name!",
                fontSize = 44.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(
                        align = Alignment.CenterHorizontally
                    )
                    .padding(start = 10.dp, top = 50.dp)
            )

            Text(
                text = "By Abc ltd..,",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.End)
                    .padding(end = 10.dp, top = 1.dp)
            )
            val context = LocalContext.current
            Button(
                onClick = { context.startActivity(Intent(context, SecondActivity::class.java)) },
                Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(align = Alignment.Bottom)
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
            ) {
                Text(text = "Click next")
            }
        }
    }
}

@Preview(showBackground = true, name = "Uma", showSystemUi = true)
@Composable
fun DefaultPreviews() {
    TipCalculatorTheme() {
        Greeting("Android")
    }
}
