package com.kotlisoft.chatui.data.mappers

import com.kotlisoft.chatui.data.local.ChatMessageEntity
import com.kotlisoft.chatui.domain.models.ChatMessage

fun ChatMessageEntity.toChatMessage(): ChatMessage {
    return ChatMessage(
        text = text,
        sentByUser = sentByUser,
        timestamp =  timestamp,
        wasRead =  wasRead
    )
}

fun ChatMessage.toChatMessageEntity(): ChatMessageEntity {
    return ChatMessageEntity(
        text = text,
        sentByUser = sentByUser,
        timestamp =  timestamp,
        wasRead =  wasRead
    )
}