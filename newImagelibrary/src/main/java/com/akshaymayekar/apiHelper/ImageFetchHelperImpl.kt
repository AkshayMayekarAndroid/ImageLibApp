package com.akshaymayekar.apiHelper

import com.akshaymayekar.apiHelper.service.ImageFetchingService
import com.akshaymayekar.apiHelper.model.DogImage
import com.akshaymayekar.apiHelper.model.DogImages
import com.akshaymayekar.util.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext


class ImageFetchHelperImpl constructor(
    private var imageFetchingService: ImageFetchingService,
    private var webApi: String
) : ImageFetchHelper {


    override fun getNumberOfDogImages(number: Int): Flow<Response<DogImages>> =
        flow {
            try {
                val responseApi = imageFetchingService.getDogImage(url = webApi.plus("api/breeds/image/random/$number"))
                emit(Response.Success(responseApi))
            } catch (e: Exception) {
                withContext(Dispatchers.Main){
                    emit(Response.Failure(e))
                }
            }
        }.flowOn(Dispatchers.IO)


    override fun getRandomDogImage(): Flow<Response<DogImage>> =
        flow {
            try {
                val responseApi = imageFetchingService.getRandomDogImage()
                emit(Response.Success(responseApi))
            } catch (e: Exception) {
                withContext(Dispatchers.Main){
                    emit(Response.Failure(e))
                }
            }
        }.flowOn(Dispatchers.IO)


}