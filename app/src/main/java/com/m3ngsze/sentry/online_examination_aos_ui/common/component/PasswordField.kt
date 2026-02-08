package com.m3ngsze.sentry.online_examination_aos_ui.common.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m3ngsze.sentry.online_examination_aos_ui.R

@Composable
fun PasswordBox(
    label: String,
    outline: Color,
    getValue: (String) -> Unit
){
    var x by remember { mutableStateOf("") }
    getValue(x)

    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.visible_icon)
    else
        painterResource(id = R.drawable.invisible_icon)

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        value = x,
        onValueChange = {x = it},
        placeholder = {Text(label)},
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFF305EAF),
            unfocusedIndicatorColor = outline
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
}