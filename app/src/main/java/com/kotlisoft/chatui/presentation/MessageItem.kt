package com.kotlisoft.chatui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotlisoft.chatui.presentation.ui.theme.LightRed
import com.kotlisoft.chatui.presentation.ui.theme.LightWhite
import com.kotlisoft.chatui.presentation.ui.theme.TextColor

@Composable
fun MessageItem(
    text: String,
    sentByMe: Boolean
) {
    Box(
        contentAlignment = if (sentByMe) Alignment.CenterEnd else Alignment.CenterStart,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            color = if (sentByMe) {
                Color.White
            } else {
                TextColor
            },
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                .background(
                    color = if (sentByMe) LightRed else LightWhite,
                    shape = if (sentByMe) {
                        RoundedCornerShape(16.dp, 16.dp, 0.dp, 16.dp)
                    } else {
                        RoundedCornerShape(16.dp, 16.dp, 16.dp, 0.dp)
                    }
                )
                .padding(8.dp)
                .widthIn(0.dp, 296.dp)
        )
    }
}