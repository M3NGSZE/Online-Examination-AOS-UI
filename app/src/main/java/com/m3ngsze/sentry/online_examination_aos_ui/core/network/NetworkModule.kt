package com.m3ngsze.sentry.online_examination_aos_ui.core.network

import com.m3ngsze.sentry.online_examination_aos_ui.core.constants.ApiConstants
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api.AuthApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)  // connection timeout
            .readTimeout(60, TimeUnit.SECONDS)     // read timeout for slow response
            .writeTimeout(60, TimeUnit.SECONDS)    // write timeout
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAuthApiService(
        retrofit: Retrofit
    ): AuthApiService =
        retrofit.create(AuthApiService::class.java)
}