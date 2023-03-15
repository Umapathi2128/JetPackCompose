package com.example.tipcalculator.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.example.tipcalculator.data.model.Article
import com.example.tipcalculator.data.model.Movie
import com.example.tipcalculator.data.network.ApiHelper
import com.example.tipcalculator.data.repository.DataManager
import com.example.tipcalculator.movies.MovieItem
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import com.example.tipcalculator.utils.NetworkHelper

class NewsListActivity : ComponentActivity() {

    lateinit var newsList: List<Article>
    lateinit var viewmodel: NewsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsList = ArrayList()
        viewmodel = NewsListViewModel(NetworkHelper(this), DataManager(ApiHelper()))


        getObservables()
        setContent {
            var context = LocalContext.current
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    viewmodel.getNews("in", "sports")
                    Movies(movies = viewmodel.moviesResponse)
//                    ConstraintLayout(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .fillMaxHeight()
//                    ) {
//
//                        val (sp1, sp2, recycler) = createRefs()
//                        CustomSpinner("in", modifier = Modifier
//                            .constrainAs(sp1) {
//                                top.linkTo(parent.top)
//                                start.linkTo(parent.start)
//                            }
//                            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
//                            .fillMaxWidth(.5f))
//
//                        CategorySpinner("sports",
//                            modifier = Modifier
//                                .constrainAs(sp2) {
//                                    top.linkTo(parent.top)
//                                    start.linkTo(sp1.end)
//                                }
//                                .fillMaxWidth(.5f)
//                                .padding(top = 10.dp, end = 10.dp)
//                        )
//
//                        LazyColumn(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .fillMaxHeight()
//                                .constrainAs(recycler) {
//                                    top.linkTo(sp1.bottom)
//                                }
//                                .padding(10.dp)
//                        ) {
//
//                            itemsIndexed(newsList) { index,item ->
//                                Card(modifier = Modifier.padding(10.dp)) {
//
//                                    ConstraintLayout {
//                                        val (img, txt) = createRefs()
//
//                                        val image = painterResource(id = R.drawable.people)
//                                        Image(
//                                            painter = image,
//                                            contentDescription = null,
//                                            modifier = Modifier
//                                                .fillMaxHeight()
//                                                .width(100.dp)
//                                                .constrainAs(img) {
//                                                    top.linkTo(parent.top)
//                                                    start.linkTo(parent.start)
//                                                }
//                                                .padding(10.dp)
//                                        )
//                                        Text(text = item.title)
//                                    }
//                                }
//                            }
//
//                        }
//                    }
                }
            }
        }
    }


    fun getObservables() {
//        viewmodel.newList.observe(this, Observer {
//            when (it.status) {
//                Status.Loading -> {}
//                Status.Error -> {}
//                Status.Success -> {
//                    newsList.clear()
//                    newsList =  it.data?.articles as ArrayList<Article>
//                }
//            }
//        })
    }

}

@Composable
fun Movies(movies : List<Article>){
    LazyColumn{
        itemsIndexed(movies){index, item ->
            val data = Movie(name = item.title, imageUrl = "", desc = item.description?:"Uma","")
            MovieItem(movie = data)
        }
    }
}

@Composable
fun CustomSpinner(type: String, modifier: Modifier) {
    val options = listOf("Option 1", "Option 2", "Option 3")
    val selectedOption = remember { mutableStateOf("Option1") }
    val countryOption = remember { mutableStateOf("Option1") }
    val isMenuOpen = remember { mutableStateOf(false) }


    OutlinedTextField(value = countryOption.value,
        onValueChange = { countryOption.value = it },
        enabled = false,
        label = { Text(text = "select an Option") }, trailingIcon = {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown icon",
                tint = Color.Gray
            )
        }, modifier = modifier.clickable { isMenuOpen.value = true },
        singleLine = true,
        readOnly = true
    )
    Popup(properties = PopupProperties(focusable = false), alignment = Alignment.BottomEnd) {

        DropdownMenu(
            expanded = isMenuOpen.value,
            onDismissRequest = { isMenuOpen.value = false },
            modifier = Modifier
                .wrapContentHeight(align = Alignment.Top),
            offset = DpOffset(x = (110).dp, y = (130).dp)
        ) {
            options.forEach { option ->
                DropdownMenuItem(onClick = {
                    countryOption.value = option
                    isMenuOpen.value = false
                }) {
                    Text(text = option)
                }
            }
        }
    }
}

@Composable
fun CategorySpinner(type: String, modifier: Modifier) {
    val options = listOf("Option 1", "Option 2", "Option 3")
    val selectedOption = remember { mutableStateOf("Option1") }
    val countryOption = remember { mutableStateOf("Option1") }
    var isMenuOpen = remember { mutableStateOf(false) }


    OutlinedTextField(value = countryOption.value,
        onValueChange = { countryOption.value = it },
        enabled = false,
        label = { Text(text = "select an Option") }, trailingIcon = {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown icon",
                tint = Color.Gray
            )
        }, modifier = modifier.clickable { isMenuOpen.value = true },
        singleLine = true,
        readOnly = true
    )
    Popup(properties = PopupProperties(focusable = false), alignment = Alignment.BottomEnd) {

        DropdownMenu(
            expanded = isMenuOpen.value,
            onDismissRequest = { isMenuOpen.value = false },
            modifier = Modifier
                .wrapContentHeight(align = Alignment.Top),
            offset = DpOffset(x = (550).dp, y = (130).dp)
        ) {
            options.forEach { option ->
                DropdownMenuItem(onClick = {
                    countryOption.value = option
                    isMenuOpen.value = false
                }) {
                    Text(text = option)
                }
            }
        }
    }
}

@Composable
fun DropdownMenuContainer(
    expanded: Boolean,
    onDismiss: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
//    DropdownMenu(
//        expanded = expanded,
//        onDismissRequest = { onDismiss.invoke() },
//        modifier = Modifier.fillMaxWidth(),
//        content = content
//    )
}

@Composable
fun Greeting5(name: String) {
//    Text(text = "Hello $name!")
//    CustomSpinner()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview8() {
    TipCalculatorTheme {
//        Greeting5("Android")
        CustomSpinner("", modifier = Modifier)
    }
}