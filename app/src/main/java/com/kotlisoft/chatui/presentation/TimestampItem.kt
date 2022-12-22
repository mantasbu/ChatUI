package com.kotlisoft.chatui.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kotlisoft.chatui.presentation.ui.theme.TimestampColor
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Composable
fun TimestampItem(messageTimestamp: Long) {
    val dateTime = LocalDateTime.ofInstant(
        Instant.ofEpochSecond(messageTimestamp),
        TimeZone.getDefault().toZoneId()
    )
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = dateTime.dayOfWeek.name
                .lowercase()
                .replaceFirstChar { it.titlecase(Locale.getDefault()) },
            color = TimestampColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "${dateTime.hour}:${dateTime.minute}",
            color = TimestampColor,
        )
    }
}