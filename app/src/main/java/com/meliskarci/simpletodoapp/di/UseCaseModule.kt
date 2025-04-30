package com.meliskarci.simpletodoapp.di

import com.meliskarci.simpletodoapp.domain.repository.ToDoDaoRepositoryImpl
import com.meliskarci.simpletodoapp.domain.repository.usecase.DeleteTodoUsecase
import com.meliskarci.simpletodoapp.domain.repository.usecase.InsertTodoUsecase
import com.meliskarci.simpletodoapp.domain.repository.usecase.getTodosUseCase
import com.meliskarci.simpletodoapp.domain.repository.usecase.GetTodoByIdUseCase
import com.meliskarci.simpletodoapp.domain.repository.usecase.UpdateTodoUseCase
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

    @Provides
    @Singleton
    fun provideInsertTodoUseCase(repository: ToDoDaoRepositoryImpl): InsertTodoUsecase {
        return InsertTodoUsecase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteTodoUseCase(repository: ToDoDaoRepositoryImpl): DeleteTodoUsecase {
        return DeleteTodoUsecase(repository)
    }

    @Provides
    @Singleton
    fun provideGetTodoByIdUseCase(repository: ToDoDaoRepositoryImpl): GetTodoByIdUseCase {
        return GetTodoByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUpdateTodoUseCase(repository: ToDoDaoRepositoryImpl): UpdateTodoUseCase {
        return UpdateTodoUseCase(repository)
    }


}