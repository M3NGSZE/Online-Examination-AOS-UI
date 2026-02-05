package com.m3ngsze.sentry.online_examination_aos_ui.feature.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.m3ngsze.sentry.online_examination_aos_ui.R
import com.m3ngsze.sentry.online_examination_aos_ui.common.data.AuthItem
import com.m3ngsze.sentry.online_examination_aos_ui.common.data.AuthItemList
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.ROOT_GRAPH_ROUT
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.AUTH_GRAPH_ROUT

@Composable
fun LoginScreen(
    navController : NavHostController,
    viewModel: AuthViewModel = hiltViewModel()
){
    Column (
        modifier = Modifier
            .padding(start = 25.dp, bottom = 25.dp, end = 25.dp)
            .background(Color(0xFFFCFCFC))
            .fillMaxWidth()
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

        LoginForm(viewModel)

        val errorState = viewModel.errorState
        if (errorState != null) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = errorState,
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(75.dp))

        Oauth2Form()

        Spacer(modifier = Modifier.height(75.dp))

        Signup("Don't have an account?","Sign up")
    }

    val authState = viewModel.authState

    LaunchedEffect(authState) {
        if (authState != null) {
            navController.navigate(ROOT_GRAPH_ROUT) {
                popUpTo(AUTH_GRAPH_ROUT) { inclusive = true }
            }
        }
    }
}

@Composable
fun LoginForm(
    viewModel: AuthViewModel = hiltViewModel()
){

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
            viewModel.login(email, password)
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
    Column {
        Text(
            text = "- Or sign in with -",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = Color(0x8849494A)
        )

        Spacer(modifier = Modifier.height(25.dp))

        LazyVerticalGrid (
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ) {
            items(AuthItemList, key = {item -> item.id}){
                    it -> AuthItemRender(it)
            }
        }
    }
}

@Composable
fun AuthItemRender(item: AuthItem){
    Card(
        modifier = Modifier
            .width(70.dp)
            .height(40.dp)
            .padding(horizontal = 10.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, Color(0x611A1A1A))
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(item.img),
                contentDescription = item.name,
                modifier = Modifier.size(item.size)
            )
        }
    }
}

@Composable
fun Signup(des1: String, des2: String){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = des1,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = " $des2",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF1E319B),
        )
    }
}