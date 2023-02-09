package com.nanioi.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException


@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {
    //                .addQueryParameter("api_key", "${BuildConfig.API_KEY}")
//                .addQueryParameter("format", "json")
//                .addQueryParameter("nojsoncallback","1")
    @Provides
    fun providesIntercepter():Interceptor{

        return Interceptor { chain->
            var request = chain.request()
            val newUrl = request.url().newBuilder().build()

            request = request.newBuilder().url(newUrl).build()
            chain.proceed(request)
        }
    }

    @Provides
    fun providesOkHttpClient(interceptor: Interceptor):OkHttpClient{
    return OkHttpClient.Builder()
        .addInterceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
                .header("SAID", "500197774183")
                .header("MAC", "v001.9777.4183")
                .header("OS-INFO", "10")
                .header("APP-TYPE", "U")
                .header("DEV_INFO", "mobile")
                .header("VERSION", "03.00.03")
            val request: Request = requestBuilder.build()

            //더미데이터모드
            chain.proceed(request)
        }
        .build()
    }

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return  Retrofit.Builder()
            .baseUrl(Url.BASEURL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }
}