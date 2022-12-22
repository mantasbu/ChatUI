package com.kotlisoft.chatui.domain.repository

import com.kotlisoft.chatui.domain.models.ChatMessage
import kotlinx.coroutines.flow.Flow

interface ChatMessagesRepository {

    suspend fun insertChatMessage(chatMessage: ChatMessage)

    fun getChatMessages(): Flow<List<ChatMessage>>
}