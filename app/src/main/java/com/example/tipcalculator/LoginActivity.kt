package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.tipcalculator.movies.MoviesActivity
import com.example.tipcalculator.ui.theme.TipCalculatorTheme


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        var context = LocalContext.current

        var passwordVisibilityValue by remember { mutableStateOf(false) }
        var userName by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val (txtLogin, name, txtPassword, btnLogin, sp1, sp2, forgetPassword, uname, pass, pnote) = createRefs()

        Text(text = "Login",
            fontSize = 40.sp,
            style = androidx.compose.ui.text.TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .constrainAs(txtLogin) {
                    top.linkTo(parent.top)
                }
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(top = 70.dp))

//        Box( modifier = Modifier
//            .fillMaxWidth()
//            .constrainAs(name) {
//                top.linkTo(txtLogin.bottom)
//                end.linkTo(parent.end)
//            }.padding(start = 10.dp, end = 10.dp, top = 40.dp)) {
//
//            EditTextAlign(userName = userName,c = {userName = it})
//        }


        OutlinedTextField(value = userName,
            onValueChange = { userName = it },
            label = { Text(text = "User name") },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(name) {
                    top.linkTo(txtLogin.bottom)
                }
                .padding(start = 10.dp, end = 10.dp, top = 70.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text))

        Spacer(modifier = Modifier
            .constrainAs(sp1) {
                top.linkTo(name.bottom)
            }
            .padding(bottom = 20.dp))
        OutlinedTextField(value = password,
            onValueChange = { password = it },
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
//            trailingIcon = {
//                IconButton(onClick = {passwordVisibilityValue = !passwordVisibilityValue}) {
//
//                    val icon = if (passwordVisibilityValue){
////                        Icons.Filled.
//                        Icons.Filled
//                    }else Icons.Default.Vis
//                }
//            },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(txtPassword) {
                    top.linkTo(sp1.bottom)
                }
                .padding(start = 10.dp, end = 10.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

        Text(text = "Forget password", color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
                .constrainAs(forgetPassword) {
                    top.linkTo(txtPassword.bottom)
                }
                .padding(end = 13.dp, top = 10.dp)
                .clickable {
                    Toast
                        .makeText(context, "Forget clicked", Toast.LENGTH_SHORT)
                        .show()
                })

        Spacer(modifier = Modifier
            .padding(top = 20.dp)
            .constrainAs(sp2) {
                top.linkTo(forgetPassword.bottom)
            })

        Button(onClick = {
            if (userName.trim().isEmpty()) {
                Toast.makeText(context, "Please enter valid user name", Toast.LENGTH_SHORT).show()
            }else if (password.trim().isEmpty()){
                Toast.makeText(context, "Please enter valid password", Toast.LENGTH_SHORT).show()
            }else{
                if (userName == "Admin" && password == "Test123"){
                    Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
                    context.startActivity(Intent(context,MoviesActivity::class.java))
                }else{
                    Toast.makeText(context, "User name or password incorrect", Toast.LENGTH_SHORT).show()
                }
            }

        }, modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .shadow(shape = RoundedCornerShape(30.dp), elevation = 19.dp)
            .constrainAs(btnLogin) {
                top.linkTo(sp2.bottom)
            }
            .padding(10.dp)
        ) {
            Text(text = "Login")
        }

        Text(text = "Use the below User name and password to login:", modifier = Modifier
            .constrainAs(pnote) {
                bottom.linkTo(uname.top)
            }
            .fillMaxWidth()
            .padding(bottom = 5.dp, start = 15.dp), color = Color.Blue)
        Text(text = "User name : Admin", modifier = Modifier
            .constrainAs(uname) {
                bottom.linkTo(pass.top)
            }
            .fillMaxWidth()
            .padding(bottom = 5.dp, start = 15.dp), color = Color.Blue)
        Text(text = "Password : Test123", modifier = Modifier
            .constrainAs(pass) {
                bottom.linkTo(parent.bottom)
            }
            .fillMaxWidth()
            .padding(bottom = 20.dp, start = 15.dp), color = Color.Blue)
//        OutlinedButton(onClick = { }, modifier = Modifier.fillMaxWidth()
//            .constrainAs(btnLogin){
//                top.linkTo(forgetPassword.bottom)
//            }.padding(10.dp)
//            .background(color = Color.Blue)) {
//            Text(text = "Button")
//        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview7() {
    TipCalculatorTheme {
        Login()
    }
}

@Composable
fun EditTextAlign(userName: String, c: (String) -> Unit) {
    OutlinedTextField(
        value = userName,
        onValueChange = c,
        label = { Text(text = "User name") },
        shape = RoundedCornerShape(10.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )

//    modifier = Modifier
//        .fillMaxWidth()
//        .constrainAs(name) {
//            top.linkTo(txtLogin.bottom)
//        }.padding(start = 10.dp, end = 10.dp, top = 40.dp),
}

@Composable
fun EditNumberFields(
    value: String, onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(stringResource(R.string.app_name)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )

//

}