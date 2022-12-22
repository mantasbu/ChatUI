package com.kotlisoft.chatui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotlisoft.chatui.R
import com.kotlisoft.chatui.presentation.ui.theme.LightRed
import com.kotlisoft.chatui.presentation.ui.theme.ThreeDotsColor

@Composable
fun TopBar(
    receiverName: String,
    onMoreClicked: (String) -> Unit
) {
    TopAppBar {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.keyboard_arrow_left),
                    contentDescription = stringResource(R.string.arrow_back),
                    tint = LightRed,
                    modifier = Modifier.size(48.dp)
                )
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(R.string.profile_picture),
                    tint = Color.Black,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = receiverName,
                    color = Color.DarkGray,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.more_horiz),
                contentDescription = stringResource(R.string.more),
                tint = ThreeDotsColor,
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        onMoreClicked(receiverName)
                    }
            )
        }
    }
}