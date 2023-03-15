package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting3("Android")
                    ListLayout()
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ListLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

        val (b1, b2, b3, b4, b1t1, b1t2, b1t3, b1t4) = createRefs()
        val context = LocalContext.current

        Box(modifier = Modifier
            .fillMaxWidth(.5f)
            .fillMaxHeight(.5f)
            .constrainAs(b1) {
                start.linkTo(parent.start)
            }
            .background(color = Color.Blue)) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .fillMaxHeight()
                    .wrapContentHeight(align = Alignment.CenterVertically)
            ) {


                Text(
                    text = "hello", modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                        .clickable {
                            context.startActivity(
                                Intent(
                                    context,
                                    BussinessCardActivity::class.java
                                )
                            )
                            Toast
                                .makeText(context, "Clicked", Toast.LENGTH_SHORT)
                                .show()
                        },
                    fontSize = 24.sp,
                    color = Color.White
                )

                Text(
                    text = "Center align all of the content vertically and " +
                            "horizontally in each quadrant.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 5.dp),
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }

        Box(modifier = Modifier
            .fillMaxWidth(.5f)
            .fillMaxHeight(.5f)
            .background(color = Color.Green)
            .constrainAs(b2) {
                start.linkTo(b1.end)
            }) {

            Text(
                text = "Box 2",
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxHeight(.5f)
                .fillMaxWidth(.5f)
                .constrainAs(b3) {
                    start.linkTo(parent.start)
                    top.linkTo(b1.bottom)
                }
                .background(color = Color.Magenta)
        ) {
            Text(
                text = "Box 3",
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .fillMaxHeight()
                    .wrapContentHeight(align = Alignment.CenterVertically)

            )
        }

        Box(modifier = Modifier
            .fillMaxWidth(.5f)
            .fillMaxHeight(.5f)
            .constrainAs(b4) {
                start.linkTo(b3.end)
                top.linkTo(b2.bottom)
            }
            .background(color = Color.Red)
        ) {
            Text(
                text = "Box 4", modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Uma")
@Composable
fun DefaultPreview4() {
    TipCalculatorTheme() {
//        Greeting3("Android")
        ListLayout()
    }
}