package com.example.tipcalculator

import android.content.Context
import android.graphics.Color.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class ViewPager2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyViewPager()
                }
            }
        }
    }
}

@Composable
fun MyViewPager() {
    val pageList = listOf(
        "Page 1",
        "Page 2",
        "Page 3"
    )

    var currentPage by remember { mutableStateOf(0) }
    val context = LocalContext.current

    Box(Modifier.fillMaxSize()) {
//        ViewPager2(
//            modfier = Modifier.fillMaxSize(),
//            orientation  = ViewPager2.ORIENTATION_HORIZONTAL){
//            pageList.forEach { text ->
//                val index = pageList.indexOf(text)
//                Text(
//                    text = text,
//                    fontSize = 24.sp,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(getColorFromResource(context, getBackgroundColor(index)))
//                )
//            }
//            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//                override fun onPageSelected(position: Int) {
//                    currentPage = position
//                }
//            })
//        }



        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                itemsIndexed(pageList) { index, text ->
                    Button(
                        onClick = {
                            currentPage = index
                            // Scroll to the selected page
//                            (parent.parent as ViewPager2).setCurrentItem(index, true)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        Text(
                            text = text,
                            color = getColorFromResource(context, getTextColor(index)),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

fun getBackgroundColor(index: Int): Int {
    return when (index) {
        0 -> R.color.purple_200
        1 -> R.color.teal_200
        2 -> R.color.teal_700
        else -> R.color.white
    }
}

fun getTextColor(index: Int): Int {
    return when (index) {
        0, 1, 2 -> android.R.color.white
        else -> android.R.color.black
    }
}

fun getColorFromResource(context: Context, resId: Int): Color {
    return Color(ContextCompat.getColor(context, resId))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview11() {
    TipCalculatorTheme {
    }
}