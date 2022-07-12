package com.example.smarthome.di

import com.example.smarthome.data.SmartHomeRepositoryImpl
import com.example.smarthome.domain.SmartHomeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindSmartHomeRepository(impl: SmartHomeRepositoryImpl): SmartHomeRepository

    companion object {
        @Singleton
        @Provides
        fun provideRealmConfig(): RealmConfiguration {
            return RealmConfiguration.Builder()
                .schemaVersion(1L)
                .allowWritesOnUiThread(false)
                .allowQueriesOnUiThread(false)
                .deleteRealmIfMigrationNeeded()
                .build()
        }
    }
}