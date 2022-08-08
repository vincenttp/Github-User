package id.vincenttp.ajaibtest.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.vincenttp.ajaibtest.data.repository.UserRepositoryImpl
import id.vincenttp.ajaibtest.domain.domain.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provUserRepository(impl: UserRepositoryImpl): UserRepository = impl
}