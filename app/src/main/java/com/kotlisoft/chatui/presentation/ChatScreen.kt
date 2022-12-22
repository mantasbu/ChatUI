package com.kotlisoft.chatui.presentation

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kotlisoft.chatui.domain.models.ChatMessage
import kotlinx.coroutines.launch

@Composable
fun ChatScreen(viewModel: ChatMessagesViewModel = hiltViewModel()) {

    var senderName by remember { mutableStateOf("Peter") }
    var receiverName by remember { mutableStateOf("Sarah") }

    val messages by viewModel.chatMessages.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        viewModel.getChatMessages()
    }

    LaunchedEffect(messages.size) {
        listState.scrollToItem(messages.size)
    }

    Scaffold(
        topBar = {
            TopBar(
                receiverName = receiverName,
                onMoreClicked = { currentReceiverName ->
                    receiverName = senderName
                    senderName = currentReceiverName
                }
            )
        },
        content = {
            MessagesList(
                messages = messages,
                listState = listState,
                senderName = senderName,
                bottomPadding = it.calculateBottomPadding() + 8.dp
            )
        },
        bottomBar = {
            BottomBar(
                onFocusTextField = {
                    coroutineScope.launch {
                        listState.scrollToItem(messages.size)
                    }
                },
                onSendMessage = {
                    viewModel.insertChatMessage(
                        ChatMessage(
                            text = it,
                            sentByUser = senderName
                        )
                    )
                }
            )
        }
    )
}