package com.m3ngsze.sentry.online_examination_aos_ui.common.component

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PendingActions
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileTabItem(
    title: String,
    isSelected: Boolean,
    active: Color,
    unActive: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .background(
                color = if (isSelected) active else unActive,
                shape = RoundedCornerShape(20)
            )
            .padding(vertical = 8.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}

@Composable
fun BottomNavigation(
    getIndex: (Int) -> Unit
){

    val active = Color(0xFFFFFFFF)
    val unActive = Color(0xFFE4E5E9)
    var selectedIndex by remember { mutableIntStateOf(0) }

    getIndex(selectedIndex)

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = unActive,
                shape = RoundedCornerShape(20)
            )
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        NavigationItem(
            title = "Activities",
            icon = Icons.Default.Task,
            isSelected = selectedIndex == 0,
            active = active,
            unActive = unActive
        ){
            selectedIndex = 0
        }

        NavigationItem(
            title = "Classwork",
            icon = Icons.Default.PendingActions,
            isSelected = selectedIndex == 1,
            active = active,
            unActive = unActive
        ){
            selectedIndex = 1
        }

        NavigationItem(
            title = "People",
            icon = Icons.Default.People,
            isSelected = selectedIndex == 2,
            active = active,
            unActive = unActive
        ){
            selectedIndex = 2
        }
    }
}

@Composable
fun NavigationItem(
    title: String,
    icon: ImageVector,
    isSelected: Boolean,
    active: Color,
    unActive: Color,
    onClick: () -> Unit
){
    Column (
        modifier = Modifier
            .clickable{ onClick() }
            .background(
                color = if (isSelected) active else unActive,
                shape = RoundedCornerShape((20))
            )
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            imageVector = icon,
            contentDescription = "Activities"
        )

        Spacer(
            modifier = Modifier
                .height(6.dp)
        )

        Text(
            text = title
        )
    }
}
