package com.akshaymayekar.imagelib

import android.util.Log

class ImageLib : LibInterface{


    fun initialize(msg : String) {

        Log.d("ImageLib msg = ", msg )
    }

    override fun getImage() {
        Log.d("ImageLib msg = ", "getImage()" )
    }

    override fun getImages(number: Int) {
        TODO("Not yet implemented")
    }

    override fun getNextImage() {
        TODO("Not yet implemented")
    }

    override fun getPreviousImage() {
        TODO("Not yet implemented")
    }

}
