package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.*
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ConstraintLayout


import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class BussinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
                    BussinessCard(name = "My Page")
                }
            }
        }
    }
}

@Composable
fun BussinessCard(name: String) {
//    Text(text = "Hello $name!")
    ConstraintLayout(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        val (title, image, quote, eImg, email, border1, share, shareTxt, border2, border3, call, callTxt,cnTitle,cnQuote) = createRefs()

        var context = LocalContext.current
        val img = painterResource(id = R.drawable.ic_android_black_24dp)

        Image(painter = img, contentDescription = null, contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { context.startActivity(Intent(context,TipCalculatorActivity::class.java)) }
                .size(height = 120.dp, width = 120.dp)
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .constrainAs(image) {
                    bottom.linkTo(title.top)
                }
                .padding(0.dp))

        Text(text = name, fontSize = 14.sp, color = Color.Black, modifier = Modifier
            .constrainAs(title) {
                top.linkTo(parent.bottom)
//                start.linkTo(parent.start)
//                end.linkTo(parent.l)
                bottom.linkTo(parent.bottom)
            }
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .fillMaxHeight()
            .padding(0.dp))
        
        Text(text = "Great developer thank you", fontSize = 24.sp,fontWeight = FontWeight.SemiBold, modifier = Modifier
            .constrainAs(cnTitle) {
                top.linkTo(image.bottom)
            }
            .padding(top = 20.dp)
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .fillMaxHeight())
        
        Text(text = "Android developer extraordinaire", color = Color.Gray, fontSize = 14.sp, modifier = Modifier
            .constrainAs(cnQuote) {
                top.linkTo(image.bottom)
            }
            .padding(top = 60.dp)
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .fillMaxHeight())


        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(quote) {
                bottom.linkTo(parent.bottom)
            }
            .padding(bottom = 30.dp)) {

            val emailImg = painterResource(id = R.drawable.ic_baseline_email_24)
            Image(painter = emailImg, contentDescription = null, modifier = Modifier
                .constrainAs(eImg) {
                    start.linkTo(parent.start)
                }
                .padding(start = 55.dp, bottom = 25.dp, top = 10.dp))

            Text(text = "umapathir2@gmail.com", modifier = Modifier
                .constrainAs(email)
                {
                    start.linkTo(eImg.end)
                }
                .padding(start = 10.dp, bottom = 5.dp, top = 10.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(border1) {
                        bottom.linkTo(email.top)
                    }
                    .height(1.5.dp)
                    .background(Color.Gray)
                    .padding(bottom = 150.dp, top = 50.dp)
            )

            val shareImg = painterResource(id = R.drawable.ic_baseline_share_24)
            Image(painter = shareImg, contentDescription = null, modifier = Modifier
                .constrainAs(share) {
                    bottom.linkTo(border1.top)
                }
                .padding(start = 55.dp, bottom = 10.dp, top = 10.dp))

            Text(text = "@Android Dev", modifier = Modifier
                .constrainAs(shareTxt) {
                    start.linkTo(share.end)
                    bottom.linkTo(email.top)
                }
                .padding(start = 10.dp, bottom = 15.dp, top = 10.dp))

            Box(
                modifier = Modifier
                    .constrainAs(border2) {
                        bottom.linkTo(shareTxt.top)
                    }
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray)
                    .padding(bottom = 15.dp)
            )

            val callImage = painterResource(id = R.drawable.ic_baseline_call_24)
            Image(painter = callImage, contentDescription = null, modifier = Modifier
                .constrainAs(call) {
                    start.linkTo(parent.start)
                    bottom.linkTo(border2.top)
                }
                .padding(start = 55.dp, bottom = 10.dp, top = 10.dp))

            Text(text = "+91 7382782302", modifier = Modifier
                .constrainAs(callTxt) {
                    start.linkTo(call.end)
                    bottom.linkTo(border2.top)
                }
                .padding(start = 10.dp, top = 10.dp, bottom = 16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(border3) {
                        bottom.linkTo(callTxt.top)
                    }
                    .height(1.dp)
                    .background(Color.Gray)
            )

        }
    }

}

@Composable
fun NavigateToCalculatorActivity() {
    val context = LocalContext.current
    val intent = Intent(context, TipCalculatorActivity::class.java)
    context.startActivity(intent)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview5() {
    TipCalculatorTheme() {
//        Greeting4("Android")
        BussinessCard(name = "Umapathi")
    }
}