package com.m3ngsze.sentry.online_examination_aos_ui.feature.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.m3ngsze.sentry.online_examination_aos_ui.R
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.InvalidInput
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.Oauth2Form
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.PasswordBox
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.TextBox
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.AUTH_GRAPH_ROUT
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen

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

        HeaderLogin()

        LoginForm(viewModel)

        Oauth2Form()

        Spacer(
            modifier = Modifier
                .height(75.dp)
        )

        Signup(
            des1 = "Don't have an account?",
            des2 = "Sign up",
            navController = navController)
    }

    val authState = viewModel.authState

    LaunchedEffect(authState) {
        if (authState != null) {
            navController.navigate(Screen.Room.route) {
                popUpTo(AUTH_GRAPH_ROUT) { inclusive = true }
            }
        }
    }
}

@Composable
fun HeaderLogin(){
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
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

    Spacer(
        modifier = Modifier
            .height(35.dp)
    )
}

@Composable
fun LoginForm(
    viewModel: AuthViewModel = hiltViewModel()
){

    val errorState: String? = viewModel.errorState

    val borderColor by remember(errorState) {
        mutableStateOf(if (errorState != null) Color(0x73FF0000) else Color(0x73919090))
    }


    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    TextBox(
        label = "email",
        outline = borderColor
    ) { e -> email = e }

    Spacer(
        modifier = Modifier
            .height(10.dp)
    )

    PasswordBox(
        label = "password",
        outline = borderColor
    ) { p -> password = p }

    Spacer(
        modifier = Modifier
            .height(25.dp)
    )

    if (errorState != null) {
        InvalidInput(msg = viewModel.errorState!!)

        Spacer(
            modifier = Modifier
                .height(25.dp)
        )
    }

    Button(
        onClick = {
            viewModel.login(email, password)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(25),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1E319C)
        ),
    ) {
        Text(
            text = "Sign in",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

    Spacer(
        modifier = Modifier
            .height(55.dp)
    )
}

@Composable
fun Signup(des1: String, des2: String, navController: NavHostController){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = des1,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            modifier = Modifier
                .clickable(
                    enabled = true
                ){
                    navController.navigate(Screen.Signup.route)
                },
            text = " $des2",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF1E319B),
        )
    }
}