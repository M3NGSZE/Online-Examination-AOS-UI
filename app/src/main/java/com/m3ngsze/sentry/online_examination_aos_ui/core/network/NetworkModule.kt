package com.m3ngsze.sentry.online_examination_aos_ui.core.network

import android.content.Context
import com.m3ngsze.sentry.online_examination_aos_ui.core.constants.ApiConstants
import com.m3ngsze.sentry.online_examination_aos_ui.data.local.SessionManager
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api.AuthApiService
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api.RefreshApiService
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api.UserApiService
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.interceptor.AuthInterceptor
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.interceptor.TokenAuthenticator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
        tokenAuthenticator: TokenAuthenticator
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)  // connection timeout
            .readTimeout(60, TimeUnit.SECONDS)     // read timeout for slow response
            .writeTimeout(60, TimeUnit.SECONDS)    // write timeout
            .addInterceptor(authInterceptor)            //  Add access token automatically
            .authenticator(tokenAuthenticator)            //  Handle 401 → refresh token
            .build()

    @Provides
    @Singleton
    @Named("mainRetrofit")
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
        @Named("mainRetrofit") retrofit: Retrofit
    ): AuthApiService =
        retrofit.create(AuthApiService::class.java)

    @Provides
    @Singleton
    fun provideSessionManager(
        @ApplicationContext context: Context
    ): SessionManager {
        return SessionManager(context)
    }

    @Provides
    @Singleton
    fun provideUserApiService(
        @Named("mainRetrofit") retrofit: Retrofit
    ): UserApiService =
        retrofit.create(UserApiService::class.java)

    @Provides
    @Singleton
    @Named("refreshRetrofit")
    fun provideRefreshRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideRefreshApiService(
        @Named("refreshRetrofit") retrofit: Retrofit
    ): RefreshApiService =
        retrofit.create(RefreshApiService::class.java)

}