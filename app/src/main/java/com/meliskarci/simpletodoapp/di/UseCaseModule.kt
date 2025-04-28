package com.meliskarci.simpletodoapp.di

import com.meliskarci.simpletodoapp.domain.repository.ToDoDaoRepositoryImpl
import com.meliskarci.simpletodoapp.domain.repository.usecase.getTodosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetTodosUseCase(repository: ToDoDaoRepositoryImpl): getTodosUseCase {
        return getTodosUseCase(repository)
    }
}