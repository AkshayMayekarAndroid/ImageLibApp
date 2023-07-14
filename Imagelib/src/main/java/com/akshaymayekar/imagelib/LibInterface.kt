package com.akshaymayekar.imagelib

interface LibInterface {
    fun getImage()// Gets one image of a dog from the library.

    fun getImages(number: Int) // Gets the number of dog images mentioned in the method

    fun getNextImage() // Gets the next image of a dog

    fun getPreviousImage() // Gets the previous image of a dog


}