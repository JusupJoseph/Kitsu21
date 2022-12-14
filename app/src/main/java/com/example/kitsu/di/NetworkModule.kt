package com.example.kitsu.di

import com.example.kitsu.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideMangaApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideMangaApiService()

    @Singleton
    @Provides
    fun provideAnimeApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideAnimeApiService()
}