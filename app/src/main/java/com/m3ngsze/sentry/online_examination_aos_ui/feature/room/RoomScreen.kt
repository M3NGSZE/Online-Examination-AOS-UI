package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.m3ngsze.sentry.online_examination_aos_ui.feature.profile.ProfileViewModel
import com.m3ngsze.sentry.online_examination_aos_ui.R
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.SearchBox
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User
import com.m3ngsze.sentry.online_examination_aos_ui.feature.auth.AuthViewModel
import java.util.UUID

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RoomScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel  = hiltViewModel(),
    authViewModel: AuthViewModel = hiltViewModel(),
    roomViewModel: RoomViewModel = hiltViewModel()
) {

    val page = 1
    val size = 5

    LaunchedEffect(Unit) {
        viewModel.getUserProfile()
        roomViewModel.getAllUserRooms(page, size, null, null, null)
    }

    val user = viewModel.userState

    var showFilter by remember { mutableStateOf(false) }

    var showSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            Button(
                onClick = { showSheet = true },
                modifier = Modifier
                    .height(60.dp),
                shape = RoundedCornerShape(25),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1E319C)
                ),
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add or Join Class",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
        }
    )
    {
        Column(
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp)
                .background(Color(0xFFFCFCFC))
        ) {

            HeaderRoom(
                navController = navController,
                authViewModel = authViewModel,
                user = user
            )

            RoomBody(
                navController = navController,
                userId = user?.userId,
                page = page,
                size = size,
                roomViewModel = roomViewModel,
                filter = showFilter
            ) { showFilter = it }

            FilterSearchRoom(showFilter) { showFilter = it }

            BottomSheetRoom(showSheet) { showSheet = it }
        }
    }

    val logout = authViewModel.logoutState
    LaunchedEffect(logout) {
        if (logout == true) {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Room.route) { inclusive = true }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSearchRoom(
    showSheet: Boolean,
    getValue: (Boolean) -> Unit
){
    if (showSheet) {
        ModalBottomSheet (
            onDismissRequest = { getValue(false) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 25.dp)
            ) {
                Text(
                    text = "ASCENDING",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier
//                        .clickable{
//
//                        }
                )

                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )

                Text(
                    text = "DESCENDING",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier
//                        .clickable{
//
//                        }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetRoom(
    showSheet: Boolean,
    getValue: (Boolean) -> Unit
){
    if (showSheet) {
        ModalBottomSheet (
            onDismissRequest = { getValue(false) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 25.dp)
            ) {
                Text(
                    text = "Join Room",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier
//                        .clickable{
//
//                        }
                )

                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )

                Text(
                    text = "Create Room",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier
//                        .clickable{
//
//                        }
                )
            }
        }
    }
}

@Composable
fun HeaderRoom(
    navController: NavHostController,
    authViewModel: AuthViewModel = hiltViewModel(),
    user: User?
){
//    val user = viewModel.userState
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Exam",
                fontSize = 23.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF006FB7)
            )

            Text(
                text = " Pilot",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF78203)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                horizontalAlignment = Alignment.End
            ) {

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Gray, CircleShape)
                        .clickable {
                            expanded = !expanded
                        }
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

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {

                    DropdownMenuItem(
                        text = { Text("Profile") },
                        onClick = {
                            expanded = false
                            navController.navigate(Screen.Profile.route)
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Setting") },
                        onClick = { expanded = false }
                    )

                    DropdownMenuItem(
                        text = { Text("Logout") },
                        onClick = {
                            expanded = false
                            authViewModel.logout()
                        }
                    )
                }
            }
            Icon(
                imageVector = Icons.Default.NotificationsNone,
                contentDescription = "Notification",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(25.dp)
                    .clickable{
                        navController.navigate(Screen.Notification.route)
                    }
            )
        }
    }
}

@Composable
fun RoomBody(
    navController: NavHostController,
    userId: UUID?,
    page: Int,
    size: Int,
    roomViewModel: RoomViewModel,
    filter: Boolean,
    isFilter: (Boolean) -> Unit
){

    val listState = rememberLazyListState()

    val rooms = roomViewModel.listRoomsState?.data ?: emptyList()


    Spacer(
        modifier = Modifier
            .height(15.dp)
    )

    var search by remember { mutableStateOf("") }
    var onOff by remember { mutableStateOf(filter) }

    SearchBox (
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(50.dp),
        label = "Search",
        outline = Color(0x73919090),
        getValue = { search = it }
    ) {
        onOff = !onOff
    }

    isFilter(onOff)

    LazyColumn {
        items(rooms) { room ->
            RoomCard(
                room = room.roomName ?: "No Name",
                sec = room.section ?: "No Section",
                des = "${if (room.userId == userId) room.student else room.lastname + room.lastname}",
                navController = navController
            )
        }
    }

    val isAtBottom = remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val totalItems = layoutInfo.totalItemsCount
            val lastVisibleItemIndex =
                layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0

            lastVisibleItemIndex >= totalItems - 1
        }
    }

    var page1 = page

    LaunchedEffect(isAtBottom.value) {
        if (isAtBottom.value) {
            page1++
            roomViewModel.getAllUserRooms(page1, size, search, null, null)
        }
    }
}

@Composable
fun RoomCard(
    room: String,
    sec: String,
    des: String,
    navController: NavHostController
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFE3E4E8),
                shape = RoundedCornerShape(20)
            )
            .clickable{
               if (room == "PVH") navController.navigate(Screen.RoomOwner.route) else navController.navigate(
                   Screen.RoomDetail.route)
            }
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column {
            Text(
                text = room,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                minLines = 1
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )

            Text(
                text = sec,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(
                modifier = Modifier
                    .height(30.dp)
            )

            Text(
                text = des,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Icon(
            imageVector = Icons.Default.MoreHoriz,
            contentDescription = "More option",
        )
    }

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )
}