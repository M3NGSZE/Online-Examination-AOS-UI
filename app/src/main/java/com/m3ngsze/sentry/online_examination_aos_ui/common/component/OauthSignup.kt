package com.m3ngsze.sentry.online_examination_aos_ui.common.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.m3ngsze.sentry.online_examination_aos_ui.common.data.AuthItem
import com.m3ngsze.sentry.online_examination_aos_ui.common.data.AuthItemList

@Composable
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
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, Color(0x611A1A1A)),
        shape = RoundedCornerShape(26.dp)
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