package com.example.data.remote.di

import com.example.data.remote.network.SpotifyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder().apply {
            this.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .build()


    //API Path:https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {

        //Add Bearer Token:
        val authToken = "BQCYBqYN6n1V658DimkM0YdRftpbjH580m-zxiDbiz3lktYj84BwA1KmOmoTMcXiSjoAGFyZb3jZUWSXZwalnhyyheD66Ggmd431eVPwtCFnIhV2LgU"

        val client = okHttpClient.newBuilder().addInterceptor { chain ->
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .header("Authorization", "Bearer $authToken")
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }.build()



       return Retrofit.Builder()
            .baseUrl("https://api.spotify.com")      // NOTE: typically would put in secrets file
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideSpotifyService(retrofit: Retrofit): SpotifyService =
        retrofit.create(SpotifyService::class.java)
}