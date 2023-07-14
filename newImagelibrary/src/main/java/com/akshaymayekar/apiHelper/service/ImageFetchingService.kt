package com.akshaymayekar.apiHelper.service

import com.akshaymayekar.apiHelper.model.DogImage
import com.akshaymayekar.apiHelper.model.DogImages
import retrofit2.http.GET
import retrofit2.http.Url

interface ImageFetchingService {

    @GET("api/breeds/image/random")
    suspend fun getRandomDogImage(): DogImage

    @GET
    suspend fun getDogImage(@Url url : String): DogImages
}