package com.kotlisoft.chatui.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.Dp
import com.kotlisoft.chatui.domain.models.ChatMessage

@Composable
fun MessagesList(
    messages: List<ChatMessage>,
    listState: LazyListState,
    senderName: String,
    bottomPadding: Dp
) {
    val focusManager = LocalFocusManager.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = bottomPadding)
            .clickable {
                focusManager.clearFocus()
            }
    ) {
        LazyColumn(state = listState) {
            itemsIndexed(items = messages) { index, message ->
                if (index > 0 && index < messages.size - 1 &&
                    messages[index + 1].timestamp - message.timestamp > 3_600_000
                ) {
                    TimestampItem(messageTimestamp = messages[index + 1].timestamp)
                }
                MessageItem(
                    text = message.text,
                    sentByMe = message.sentByUser == senderName
                )
            }
        }
    }
}