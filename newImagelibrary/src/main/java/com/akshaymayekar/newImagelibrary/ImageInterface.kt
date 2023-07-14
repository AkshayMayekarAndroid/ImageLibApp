package com.akshaymayekar.newImagelibrary

interface ImageInterface {
    suspend fun getImage(onImageLoadListener: OnImageLoadListener) // Gets one image of a dog from the library.

    suspend fun getImages(
        number: Int,
        onImageLoadListener: OnMultipleImageLoadListener
    ) // Gets the number of dog images mentioned in the method

    suspend fun getNextImage(onImageLoadListener: OnImageLoadListener) // Gets the next image of a dog

    suspend fun getPreviousImage(onImageLoadListener: OnImageLoadListener) // Gets the previous image of a dog


}



