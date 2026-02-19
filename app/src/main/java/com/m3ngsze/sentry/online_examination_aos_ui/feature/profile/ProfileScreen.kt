package com.m3ngsze.sentry.online_examination_aos_ui.feature.profile

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.m3ngsze.sentry.online_examination_aos_ui.R
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.ProfileCardInfo
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.ProfileTabItem

@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel  = hiltViewModel()
){
/*    LaunchedEffect (Unit) {
        viewModel.getUserProfile()
    }*/

    var switch by remember { mutableIntStateOf(0) }

    Column (
        modifier = Modifier
            .padding(start = 25.dp, bottom = 25.dp, end = 25.dp)
            .background(Color(0xFFFCFCFC))
//            .background(Color(0xFFF9F3E6))
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
    ){
        ProfileHeader(
            navController = navController
        )

        ProfileInfo(
            viewModel = viewModel
        )

        ProfileTab{ switch = it}

        when (switch) {
            0 -> StatsTab()
            1 -> ResultTab()
            2 -> InfoTab()
        }
    }
}

@Composable
fun ProfileHeader(
    navController: NavHostController,
){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "Back to exam screen",
            modifier = Modifier
//                .clickable{
//                    navController.navigate(Screen.Room.route)
//                }
        )

        Text(
            text = "My Profile",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp
        )

        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = "Edit personal info"
        )
    }

    Spacer(
        modifier = Modifier
            .height(30.dp)
    )
}

@Composable
fun ProfileInfo(
    viewModel: ProfileViewModel  = hiltViewModel()
){
    val user = viewModel.userState
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Gray, CircleShape)
        ) {
            AsyncImage(
                model = user?.profileUrl
                    ?: R.drawable.profile,
                contentDescription = "profile img",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        }

        Spacer(
            modifier = Modifier
                .width(20.dp)
        )

        Column {
            Text(
                text = """
                    ${user?.lastName ?: "Last Name" }
                    ${user?.firstName ?: "First Name" }
                """.trimIndent(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 23.sp,
                lineHeight = 30.sp
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                ProfileCardInfo(
                    value = "N/A",
                    label = "GENDER"
                )

                ProfileCardInfo(
                    value = "67",
                    label = "AGE"
                )

                ProfileCardInfo(
                    value = "67/67/67",
                    label = "BIRTHDAY"
                )
            }
        }
    }

    Spacer(
        modifier = Modifier
            .height(30.dp)
    )
}

@Composable
fun ProfileTab(
    getValue: (Int) -> Unit   // 0 = Stats, 1 = Result, 2 = Info
) {
    val active = Color(0xFFFFFFFF)
    val unActive = Color(0xFFE4E5E9)

    var selectedIndex by remember { mutableIntStateOf(0) }

    getValue(selectedIndex)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = unActive,
                shape = RoundedCornerShape(20)
            )
            .padding(5.dp)
    ) {

        ProfileTabItem(
            title = "Stats",
            isSelected = selectedIndex == 0,
            active = active,
            unActive = unActive,
            modifier = Modifier.weight(1f)
        ) {
            selectedIndex = 0
        }

        ProfileTabItem(
            title = "Result",
            isSelected = selectedIndex == 1,
            active = active,
            unActive = unActive,
            modifier = Modifier.weight(1f)
        ) {
            selectedIndex = 1
        }

        ProfileTabItem (
            title = "Info",
            isSelected = selectedIndex == 2,
            active = active,
            unActive = unActive,
            modifier = Modifier.weight(1f)
        ) {
            selectedIndex = 2
        }
    }

    Spacer(modifier = Modifier.height(20.dp))
}