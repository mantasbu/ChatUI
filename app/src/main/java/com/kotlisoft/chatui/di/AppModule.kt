package com.kotlisoft.chatui.di

import android.app.Application
import androidx.room.Room
import com.kotlisoft.chatui.data.local.ChatMessagesDatabase
import com.kotlisoft.chatui.data.repository.ChatMessagesRepositoryImpl
import com.kotlisoft.chatui.domain.repository.ChatMessagesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMessagesDatabase(app: Application): ChatMessagesDatabase {
        return Room.databaseBuilder(
            app,
            ChatMessagesDatabase::class.java,
            ChatMessagesDatabase.DATABASE_NAME,
        ).createFromAsset("database/chat_messages_db.db").build()
    }

    @Provides
    @Singleton
    fun provideChatMessageRepository(db: ChatMessagesDatabase): ChatMessagesRepository {
        return ChatMessagesRepositoryImpl(db.chatMessageDao)
    }
}