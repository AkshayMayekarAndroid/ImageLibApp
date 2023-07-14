package com.akshaymayekar.newImagelibrary

import android.util.Log
import com.akshaymayekar.apiHelper.ImageFetchHelper
import com.akshaymayekar.apiHelper.ImageFetchHelperImpl
import com.akshaymayekar.apiHelper.RetrofitBuilder
import com.akshaymayekar.util.Const
import com.akshaymayekar.util.Response

class ImageLib : ImageInterface {


    private lateinit var imageFetchHelper: ImageFetchHelper
    private lateinit var imageMap: MutableMap<Int, String>
    var counter = 0
    fun init() {
        imageMap = mutableMapOf()
        counter = 0
        imageFetchHelper = ImageFetchHelperImpl(RetrofitBuilder.apiService, Const.WEB_API)
    }

    override suspend fun getImage(onImageLoadListener: OnImageLoadListener) {


        imageFetchHelper.getRandomDogImage().collect { response ->
            when (response) {
                is Response.Failure -> {}//onImageLoadListener.onFailed(response.e)}
                is Response.Success -> {
                    response.data?.let {
                        imageMap[imageMap.size + 1] = it.message
                        onImageLoadListener.onSuccess(it.message)
                    }
                }
            }
        }
    }

    override suspend fun getImages(number: Int, onImageLoadListener: OnMultipleImageLoadListener) {
        imageFetchHelper.getNumberOfDogImages(number).collect { response ->
            when (response) {
                is Response.Failure -> {
                    onImageLoadListener.onFailed(response.e)
                }
                is Response.Success -> {
                    response.data?.let {
                        onImageLoadListener.onSuccess(it.message)
                    }
                }
            }
        }
    }

    override suspend fun getNextImage(onImageLoadListener: OnImageLoadListener) {

        counter += 1
        if (imageMap.containsKey(counter)) {
            val image = imageMap.getValue(counter)
            onImageLoadListener.onSuccess(image)
        } else {
            imageFetchHelper.getRandomDogImage().collect { response ->
                when (response) {
                    is Response.Failure -> {
                        onImageLoadListener.onFailed(response.e)
                    }
                    is Response.Success -> {
                        response.data?.let {
                            imageMap[imageMap.size + 1] = it.message
                            onImageLoadListener.onSuccess(it.message)
                        }
                    }
                }
            }
        }
    }

    override suspend fun getPreviousImage(onImageLoadListener: OnImageLoadListener) {
        if (counter > 1) {
            counter -= 1
        }
        Log.d("previousImage = ", "$counter")
        if (counter > 0) {
            val image = imageMap.getValue(counter)
            onImageLoadListener.onSuccess(image)
        }
    }


}