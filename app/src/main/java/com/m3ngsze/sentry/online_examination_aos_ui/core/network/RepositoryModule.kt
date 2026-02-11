package com.m3ngsze.sentry.online_examination_aos_ui.core.network

import com.m3ngsze.sentry.online_examination_aos_ui.data.repository.AuthRepositoryImpl
import com.m3ngsze.sentry.online_examination_aos_ui.data.repository.UserRepositoryImpl
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.AuthRepository
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository
}
