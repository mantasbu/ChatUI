package com.kotlisoft.chatui.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ChatMessageEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ChatMessagesDatabase : RoomDatabase() {

    abstract val chatMessageDao: ChatMessageDao

    companion object {
        const val DATABASE_NAME = "chat_messages_db"
    }
}