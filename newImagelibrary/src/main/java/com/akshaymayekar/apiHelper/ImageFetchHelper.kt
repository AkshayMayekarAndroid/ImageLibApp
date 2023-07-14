package com.akshaymayekar.apiHelper

import com.akshaymayekar.apiHelper.model.DogImage
import com.akshaymayekar.apiHelper.model.DogImages
import com.akshaymayekar.util.Response
import kotlinx.coroutines.flow.Flow

interface ImageFetchHelper {
    fun getNumberOfDogImages(number : Int): Flow<Response<DogImages>>
    fun getRandomDogImage(): Flow<Response<DogImage>>
}