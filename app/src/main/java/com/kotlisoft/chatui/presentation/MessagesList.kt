package com.kotlisoft.chatui.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.kotlisoft.chatui.domain.models.ChatMessage

@Composable
fun MessagesList(
    messages: List<ChatMessage>,
    listState: LazyListState,
    senderName: String,
    bottomPadding: Dp
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = bottomPadding)
    ) {
        LazyColumn(state = listState) {
            items(items = messages) { message ->
                MessageItem(
                    text = message.text,
                    sentByMe = message.sentByUser == senderName
                )
            }
        }
    }
}