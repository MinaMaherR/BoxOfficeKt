package com.mmaher.basemodule.model.repo

import com.mmaher.basemodule.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mina Maher (m.maher95@outlook.com) on 2020-02-21.
 */
class APIClient() {
    companion object {
        var shared: APIClient = APIClient()
    }

    var retrofit: Retrofit

    init {
        // Logging interceptor
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor {
                var request = it.request().newBuilder().addHeader(APIConstants.authorizationHeaderKey, APIConstants.authorizationHeaderValue).build()
                it.proceed(request)

            }
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }
}