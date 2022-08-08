package id.vincenttp.ajaibtest.data.di

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.vincenttp.ajaibtest.BuildConfig
import id.vincenttp.ajaibtest.data.network.ArrayListMoshiAdapter
import id.vincenttp.ajaibtest.data.network.InterceptorProvider
import id.vincenttp.ajaibtest.data.room.AppDatabase
import javax.inject.Inject
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule @Inject constructor() {

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): MoshiConverterFactory {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(ArrayListMoshiAdapter())
            .build()

        return MoshiConverterFactory
            .create(moshi)
    }

    @Provides
    @Singleton
    fun providesInterceptor(): InterceptorProvider {
        return InterceptorProvider()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(interceptor: InterceptorProvider): OkHttpClient {
        val client = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(logging)
            client.addInterceptor(interceptor)
        }

        return client.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        converter: MoshiConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(converter)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideHotelDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getDatabase(context.applicationContext)
}