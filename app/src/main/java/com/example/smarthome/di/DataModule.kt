package com.example.smarthome.di

import com.example.smarthome.data.ApiFactory
import com.example.smarthome.data.ApiService
import com.example.smarthome.data.SmartHomeRepositoryImpl
import com.example.smarthome.domain.SmartHomeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindSmartHomeRepository(impl: SmartHomeRepositoryImpl): SmartHomeRepository

    companion object{
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

    }
}