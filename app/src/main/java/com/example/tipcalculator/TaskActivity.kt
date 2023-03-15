package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class TaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
//                    Column {
//                        Greeting2("Android")
                    UsingConstraint()
//                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}


@Composable
fun UsingConstraint() {

    ConstraintLayout {

        val (img, text, title) = createRefs()

        val image = painterResource(id = R.drawable.ic_launcher_background)

        Image(painter = image, contentDescription = null, modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .constrainAs(img) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
//            end.linkTo(parent.end)
//            start.linkTo(parent.start)
            })

        Text(text = "Hello Hello Hello", modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .constrainAs(title) {
                top.linkTo(img.bottom)
//            start.linkTo(parent.start)
//            end.linkTo(parent.end)
            })

        Text(text = "Nice work!",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .constrainAs(text) {
                    top.linkTo(title.bottom)
//            start.linkTo(parent.start)
//            end.linkTo(parent.end)
                }
                .padding(10.dp))

        val ctx = LocalContext.current
        val intent = Intent(ctx, ListActivity::class.java)

        Button(
            onClick = { ctx.startActivity(intent) },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .wrapContentHeight(align = Alignment.Bottom)
                .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
        ) {

            Text(text = "List Activity")
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3() {
    TipCalculatorTheme() {
//        Greeting2("Android")
        UsingConstraint()
    }
}