package com.kotlisoft.chatui.data.repository

import com.kotlisoft.chatui.data.local.ChatMessageDao
import com.kotlisoft.chatui.data.mappers.toChatMessage
import com.kotlisoft.chatui.data.mappers.toChatMessageEntity
import com.kotlisoft.chatui.domain.models.ChatMessage
import com.kotlisoft.chatui.domain.repository.ChatMessagesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ChatMessagesRepositoryImpl @Inject constructor(
    private val chatMessageDao: ChatMessageDao
) : ChatMessagesRepository {

    override suspend fun insertChatMessage(chatMessage: ChatMessage) {
        chatMessageDao.insertChatMessage(chatMessage.toChatMessageEntity())
    }

    override fun getChatMessages(): Flow<List<ChatMessage>> {
        return chatMessageDao.getChatMessages().map { chatMessageEntities ->
            chatMessageEntities.map { chatMessageEntity ->
                chatMessageEntity.toChatMessage()
            }
        }
    }
}