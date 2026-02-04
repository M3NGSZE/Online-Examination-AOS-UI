package com.m3ngsze.sentry.online_examination_aos_ui.feature.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.m3ngsze.sentry.online_examination_aos_ui.R

@Composable
fun LoginScreen(navController : NavHostController){
    Column (
        modifier = Modifier
            .padding(start = 25.dp, bottom = 25.dp, end = 25.dp)
            .background(Color(0xFFFCFCFC))
    ){

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter =painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(180.dp)
            )
        }

        Text(
            text = "Login to your Account",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xD049494A)
        )

        Spacer(modifier = Modifier.height(35.dp))

        LoginForm()

        Spacer(modifier = Modifier.height(75.dp))

        Oauth2Form()


    }
}

@Composable
fun LoginForm(){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.visible_icon)
    else
        painterResource(id = R.drawable.invisible_icon)

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        onValueChange = {email = it},
        placeholder = {Text("email")},
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFF305EAF),
            unfocusedIndicatorColor = Color(0x73919090)
        ),
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 18.sp
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        )
    )

    Spacer(modifier = Modifier.height(15.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = {password = it},
        placeholder = {Text("password")},
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFF305EAF),
            unfocusedIndicatorColor = Color(0x73919090)
        ),
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 18.sp
        ),
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisibility = !passwordVisibility
                }
            ) {
                Icon(
                    painter = icon,
                    contentDescription = "Visible Icon",
                    modifier = Modifier.size(20.dp),
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),

        visualTransformation = if (passwordVisibility)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),
    )

    Spacer(modifier = Modifier.height(25.dp))

    Button(
        onClick = {

        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(10),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1E319C)
        ),
    ) {
        Text("Sign in")
    }
}

@Composable
@Preview
fun Oauth2Form(){
    Text(
        text = "- Or sign in with -",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth(),
        color = Color(0x8849494A)
    )

    Spacer(modifier = Modifier.height(15.dp))

    Row (
        modifier = Modifier
                .fillMaxWidth(),
    ){
        Card (
            modifier = Modifier
                .clickable {}
                .width(70.dp)
                .height(50.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ){
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "",
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.CenterHorizontally),

            )
        }

    }
}
