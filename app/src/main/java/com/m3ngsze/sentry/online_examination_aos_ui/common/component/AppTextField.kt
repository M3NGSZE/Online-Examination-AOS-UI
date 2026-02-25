package com.m3ngsze.sentry.online_examination_aos_ui.common.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.Instant
import java.time.ZoneId

@Composable
fun TextBox(
    label: String,
    outline: Color,
    trailIcon: @Composable (() -> Unit)? = null,
    getValue: (String) -> Unit
){
    var x by remember { mutableStateOf("") }
    getValue(x)

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
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        trailingIcon = {
            trailIcon?.invoke()
        },
    )
}

@Composable
fun SmallTextField(
    w: Dp,
    h: Dp,
    getValue: (String) -> Unit
){
    var x by remember { mutableStateOf("") }
    getValue(x)

    OutlinedTextField(
        value = x,
        onValueChange = {
            if (it.length <= 1) x = it
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFF305EAF),
            unfocusedIndicatorColor = Color(0x73919090)
        ),
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        modifier = Modifier
            .width(w)
            .height(h)
            .padding(horizontal = 5.dp)
    )
}

@Composable
fun TextBoxDatPicker(
    label: String,
    outline: Color,
    trailIcon: @Composable (() -> Unit)? = null,
    y : String?
){
    var x by remember { mutableStateOf(y) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        value = y!!,
        onValueChange = {x},
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
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        trailingIcon = {
            trailIcon?.invoke()
        },
        readOnly = true
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDatePicker(
    getValue: (String) -> Unit
) {

    var showDialog by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }

    getValue(selectedDate)

    val datePickerState = rememberDatePickerState()

    Column {
        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = "Date Time Pick",
            tint = Color.Red,
            modifier = Modifier
                .clickable{
                    showDialog = true
                }
        )

        if (showDialog) {
            DatePickerDialog (
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    TextButton (
                        onClick = {
                            val millis = datePickerState.selectedDateMillis
                            if (millis != null) {
                                val date = Instant.ofEpochMilli(millis)
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate()
                                selectedDate = date.toString()
                            }
                            showDialog = false
                        }
                    ) {
                        Text("OK")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }
    }
}

@Composable
fun RequireIcon(){
    Text(
        text = "*",
        fontSize = 25.sp,
        color = Color.Red
    )
}