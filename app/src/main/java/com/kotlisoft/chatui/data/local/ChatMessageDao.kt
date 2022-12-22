package com.kotlisoft.chatui.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatMessageDao {

    @Insert
    suspend fun insertChatMessage(chatMessage: ChatMessageEntity)

    @Query("SELECT * FROM chat_message")
    fun getChatMessages(): Flow<List<ChatMessageEntity>>
}