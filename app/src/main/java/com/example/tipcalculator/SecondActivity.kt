package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoLayout(title = "", description = "")
                }
            }
        }
    }
}


@Composable
fun DemoLayout(title: String, description: String) {

    Box() {
        Column {
            val rainbowColor = remember {
                Brush.sweepGradient(
                    listOf(
                        Color(0xFF9575CD),
                        Color(0xFFBA68C8),
                        Color(0xFFE57373),
                        Color(0xFFFFB74D),
                        Color(0xFFFFF176),
                        Color(0xFFAED581),
                        Color(0xFF4DD0E1),
                        Color(0xFF9575CD)
                    )
                )
            }

            val image = painterResource(id = R.drawable.people)
            Image(
                painter = image,
                contentDescription = "Uma garu",
//                modifier = Modifier.size(250.dp)
                modifier = Modifier
                    .size(height = 300.dp, width = 3000.dp)
                    .fillMaxWidth()
                    .aspectRatio(7f / 4f)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .clip(CircleShape)
                    .border(BorderStroke(7.dp, rainbowColor), CircleShape)
            )

            Text(
                text = "Hello Uma Garu", fontSize = 24.sp, color = Color.Black,
                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
            )
            Text(
                text = "In this exercise, you need to apply most of the concepts that" +
                        " you learned so far and then go a step further to explore a new Modifier" +
                        " and properties. This might look like an extra challenge, but don't worry!" +
                        " You can check the References section for this problem, " +
                        "where you can find the links to these Modifier classes and properties, " +
                        "and use them for implementation.", fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(10.dp)
            )

            val ctx = LocalContext.current
            val intent = Intent(ctx, TaskActivity::class.java)
            Button(
                onClick = { ctx.startActivity(intent) },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .wrapContentHeight(align = Alignment.Bottom)
                    .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
            ) {
                Text(text = "Task activity")
            }
        }


    }
}


@Preview(showBackground = false, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    TipCalculatorTheme() {
        DemoLayout(title = "", description = "")
//        Text(text = "Hello")
    }
}