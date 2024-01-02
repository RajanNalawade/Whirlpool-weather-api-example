package com.example.weatherdata.di

import android.content.Context
import com.example.weatherdata.BuildConfig
import com.example.weatherdata.data_layer.remote.WeatherApiHelper
import com.example.weatherdata.data_layer.remote.WeatherApiHelperImpl
import com.example.weatherdata.data_layer.remote.WeatherApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())

    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {

        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(context.cacheDir, cacheSize)

        val client = OkHttpClient.Builder().addInterceptor {
            val httpUrl = it.request().url.newBuilder().addQueryParameter(
                "appid",
                BuildConfig.API_KEY
            ).addQueryParameter("units", "metric").build()
            //Log.d("Weather", "provideOkHttpClient: ${httpUrl.toUrl()}")
            it.proceed(it.request().newBuilder().url(httpUrl.toString()).build())
        }.cache(myCache)

        return client.build()
    }

    @Singleton
    @Provides
    fun provideWeatherApiService(
        retrofitBuilder: Retrofit.Builder,
        okHttpClient: OkHttpClient
    ): WeatherApiService {
        return retrofitBuilder.client(okHttpClient).baseUrl(BuildConfig.BASE_URL).build()
            .create(WeatherApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideWeatherApiHelper(apiService: WeatherApiService): WeatherApiHelper =
        WeatherApiHelperImpl(apiService)
}