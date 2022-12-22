package com.kotlisoft.chatui.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat_message")
data class ChatMessageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String,
    val sentByUser: String,
    val timestamp: Long = System.currentTimeMillis(),
    val wasRead: Boolean = false
)
