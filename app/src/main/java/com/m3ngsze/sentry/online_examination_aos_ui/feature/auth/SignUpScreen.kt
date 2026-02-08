package com.m3ngsze.sentry.online_examination_aos_ui.feature.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.InvalidInput
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.Oauth2Form
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.PasswordBox
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.TextBox
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.RegisterRequest

@Composable
fun SignUpScreen(
    navController : NavHostController,
    viewModel: AuthViewModel = hiltViewModel()
){
    var email by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .padding(start = 25.dp, bottom = 25.dp, end = 25.dp)
            .background(Color(0xFFFCFCFC))
            .fillMaxWidth()
    ) {
        SignUpHeader(navController = navController)

        SignUpForm(viewModel = viewModel){email = it}

        Oauth2Form()
    }

    val userState = viewModel.userState

    LaunchedEffect(userState) {
        if (userState != null){
            navController.navigate(Screen.VerifyOtp.createRoute(email))
        }
    }
}

@Composable
fun SignUpHeader(navController : NavHostController){
    Box (
        modifier = Modifier
            .padding(vertical = 3.dp)
                .clickable{
                    navController.navigate(Screen.Login.route)
                }
    ){
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back to login",
            tint = Color.Black
        )
    }

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )

    Text(
        text = "Exam Pilot",
        textAlign = TextAlign.Center,
        fontSize = 23.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .fillMaxWidth()
    )

    Spacer(
        modifier = Modifier
            .height(25.dp)
    )

    Text(
        text = "Create your Account",
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xD049494A)
    )

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )
}

@Composable
fun SignUpForm(
    viewModel: AuthViewModel = hiltViewModel(),
    getValue: (String) -> Unit
){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    val errorState: String? = viewModel.errorState
    val borderColor by remember(errorState) {
        mutableStateOf(if (errorState != null) Color(0x73FF0000) else Color(0x73919090))
    }

    TextBox(
        label = "first name",
        outline = borderColor
    ) { firstName = it}

    TextBox(
        label = "last name",
        outline = borderColor
    ) { lastName = it}

    TextBox(
        label = "email",
        outline = borderColor
    ) { email = it}

    PasswordBox (
        label = "password",
        outline = borderColor
    ) { password = it}

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )

    val request = RegisterRequest(email, password, firstName, lastName)

    if (errorState != null){
        InvalidInput(msg = errorState)

        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
    }


    Button(
        onClick = {
            viewModel.register(request)
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
            text = "Sign up",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

    getValue(email)

    Spacer(
        modifier = Modifier
            .height(25.dp)
    )

    Text(
        text = """
            By Signing Up. you agree to our 
            Terms & Privacy Policy
        """.trimIndent(),
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        lineHeight = 20.sp,
        fontSize = 12.sp
    )

    Spacer(
        modifier = Modifier
            .height(55.dp)
    )
}
