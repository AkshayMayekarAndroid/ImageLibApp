package com.akshaymayekar.apiHelper

import com.akshaymayekar.apiHelper.service.ImageFetchingService
import com.akshaymayekar.util.Const.WEB_API
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {


    fun provideWebAPI(): String = WEB_API



    fun getRetrofit(): Retrofit {
        val client = OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
        return Retrofit.Builder()
            .baseUrl(WEB_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val apiService: ImageFetchingService = getRetrofit().create(ImageFetchingService::class.java)


   /* fun provideImageFetchingService(
        retrofit: Retrofit
    ): ImageFetchingService = retrofit.create(ImageFetchingService::class.java)*/


/*
    fun provideImageFetchingRepository(
        imageFetchingService: ImageFetchingService,
        webApi: String
    ): ImageFetchRepository = ImageFetchRepositoryImpl(
        imageFetchingService = imageFetchingService,
        webApi = webApi
    )*/
 }