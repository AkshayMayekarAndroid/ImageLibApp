package com.akshaymayekar.newImagelibrary

interface OnMultipleImageLoadListener {
    fun onSuccess(message: List<String>)
    fun onFailed(e: Exception?)
}