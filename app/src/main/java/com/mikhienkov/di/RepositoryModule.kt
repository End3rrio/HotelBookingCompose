package com.mikhienkov.di

import com.mikhienkov.data.repositories.AppPreferencesRepositoryImpl
import com.mikhienkov.data.repositories.HotelRepositoryImpl
import com.mikhienkov.data.repositories.SearchQueryRepositoryImpl
import com.mikhienkov.data.repositories.UserRepositoryImpl
import com.mikhienkov.domain.repositories.AppPreferencesRepository
import com.mikhienkov.domain.repositories.HotelRepository
import com.mikhienkov.domain.repositories.SearchQueryRepository
import com.mikhienkov.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsAppPreferencesRepository(impl: AppPreferencesRepositoryImpl): AppPreferencesRepository

    @Binds
    fun bindsUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    fun bindsHotelRepository(impl: HotelRepositoryImpl): HotelRepository

    @Binds
    fun bindsSearchQueryRepository(impl: SearchQueryRepositoryImpl): SearchQueryRepository
}