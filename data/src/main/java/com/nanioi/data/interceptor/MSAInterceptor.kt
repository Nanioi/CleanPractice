package com.nanioi.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class MSANetworkInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val requestBuilder = request().newBuilder()
            .header("SAID", "500197774183")
            .header("MAC", "v001.9777.4183")
            .header("OS-INFO", "10")
            .header("APP-TYPE", "U")
            .header("DEV_INFO", "mobile")
            .header("VERSION", "03.00.03")
        val request: okhttp3.Request = requestBuilder.build()
        proceed(request)
    }
}