package com.kotlisoft.chatui.domain.models

data class ChatMessage(
    val text: String,
    val sentByUser: String,
    val timestamp: Long = System.currentTimeMillis(),
    val wasRead: Boolean = false
)
