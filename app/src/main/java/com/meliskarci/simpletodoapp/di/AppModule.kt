package com.meliskarci.simpletodoapp.di

import android.content.Context
import androidx.room.Room
import com.meliskarci.simpletodoapp.data.local.ToDoDatabase
import com.meliskarci.simpletodoapp.data.local.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ToDoDatabase {
        return Room.databaseBuilder(
            appContext,
            ToDoDatabase::class.java,
            "tododb"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(database: ToDoDatabase) : TodoDao {
        return database.todoDao()
    }

    @Provides
    @Singleton
    fun provideTodoDaoRepositoryImpl(todoDao: TodoDao) : TodoDaoRepositoryImpl {
        return TodoDaoRepositoryImpl(todoDao)
    }
}