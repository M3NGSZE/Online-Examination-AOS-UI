package com.m3ngsze.sentry.online_examination_aos_ui.core.network

import com.m3ngsze.sentry.online_examination_aos_ui.data.repository.RefreshTokenRepositoryImpl
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.RefreshTokenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RefreshRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRefreshTokenRepository(
        impl: RefreshTokenRepositoryImpl
    ): RefreshTokenRepository
}
