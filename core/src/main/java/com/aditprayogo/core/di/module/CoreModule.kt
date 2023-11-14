package com.aditprayogo.core.di.module

import com.aditprayogo.core.data.remote.Network
import com.aditprayogo.core.data.remote.NetworkServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkServices {
        return Network.retrofitClient().create(NetworkServices::class.java)
    }
}