package com.nanioi.data

import com.nanioi.data.interceptor.MSANetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class MSARetrofit

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class MSAInterceptor

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @MSAInterceptor
    @Provides
    fun providesMSAIntercepter(): Interceptor{
        return MSANetworkInterceptor()
    }

    @MSARetrofit
    @Provides
    fun providesRetrofit(
        @MSAInterceptor interceptor: Interceptor
    ):Retrofit{

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return  Retrofit.Builder()
            .baseUrl(Url.MSA_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}