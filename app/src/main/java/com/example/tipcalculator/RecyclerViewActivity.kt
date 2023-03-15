package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class RecyclerViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting4("Android")

                    ListItem(
                        list = arrayOf(
                            "Item 1",
                            "Item 2",
                            "Item 3",
                            "Item 4",
                            "Item 5",
                            "Item 6",
                            "Item 7",
                            "Item 8",
                            "Item 9",
                            "Item 10",
                            "Item 11",
                            "Item 12",
                            "Item 13",
                            "Item 14",
                            "Item 15",
                            "Item 16",
                            "Item 17",
                            "Item 18",
                            "Item 19",
                            "Item 20",
                            "Item 21",
                            "Item 22",
                            "Item 23",
                            "Item 24",
                            "Item 25",
                            "Item 26",
                            "Item 27",
                            "Item 28",
                            "Item 29",
                            "Item 30"
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ListItem(list: Array<String>) {

    val context = LocalContext.current

    LazyColumn {
        items(list.size) { item ->

            Card(modifier = Modifier.padding(10.dp), elevation = 10.dp) {

                ConstraintLayout() {

                    val (img, title) = createRefs()

                    val image = painterResource(id = R.drawable.people)
                    Image(
                        painter = image,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                Toast
                                    .makeText(
                                        context,
                                        "${list[item]} image clicked",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                                context.startActivity(Intent(context, LoginActivity::class.java))
                            }
                            .constrainAs(img) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }
                            .fillMaxWidth()
                            .height(200.dp), contentScale = ContentScale.Crop
                    )
                    Text(
                        text = list[item],
                        modifier = Modifier
                            .clickable {
                                Toast
                                    .makeText(
                                        context,
                                        "${list[item]} text clicked",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                            .padding(10.dp)
                            .constrainAs(title) {
                                top.linkTo(img.bottom)
                            }
                            .padding(top = 10.dp),
                        style = MaterialTheme.typography.h6,
                    )
                }
            }


//            Text(
//                text = item.toString(), fontSize = 24.sp,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(20.dp)
//                    .size(height = 50.dp, width = Dp.Infinity)
//                    .background(Color.Gray)
//            )
        }
    }
//    LazyColumn(content = {
//        list(list){
//
//        }
//    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview6() {
    TipCalculatorTheme {
//        Greeting4("Android")
    }
}