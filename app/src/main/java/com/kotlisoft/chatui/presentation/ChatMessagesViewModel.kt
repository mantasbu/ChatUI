package com.kotlisoft.chatui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlisoft.chatui.domain.models.ChatMessage
import com.kotlisoft.chatui.domain.repository.ChatMessagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatMessagesViewModel @Inject constructor(
    private val chatMessagesRepository: ChatMessagesRepository
) : ViewModel() {

    private val _chatMessages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val chatMessages: StateFlow<List<ChatMessage>> = _chatMessages.asStateFlow()

    fun getChatMessages() = viewModelScope.launch {
        chatMessagesRepository.getChatMessages().collect {
            _chatMessages.value = it
        }
    }

    fun insertChatMessage(chatMessage: ChatMessage) =  viewModelScope.launch {
        chatMessagesRepository.insertChatMessage(chatMessage)
    }
}