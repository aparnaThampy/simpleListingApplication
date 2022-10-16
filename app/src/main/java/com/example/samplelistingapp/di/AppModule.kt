package com.example.samplelistingapp.di

import android.content.Context
import com.example.samplelistingapp.AppApplication
import com.example.samplelistingapp.repository.ListRepository
import com.example.samplelistingapp.repository.ListRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Module to tell Hilt how to provide instances of types that cannot be constructor-injected.
 *
 * As these types are scoped to the application lifecycle using @Singleton, they're installed
 * in Hilt's ApplicationComponent.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): AppApplication {
        return app as AppApplication
    }

    @Provides
    fun provideListRepository(): ListRepository = ListRepositoryImp()
}
