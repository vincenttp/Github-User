package id.vincenttp.ajaibtest.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.vincenttp.ajaibtest.data.ApiService
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    @Singleton
    fun provSampleApi(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}