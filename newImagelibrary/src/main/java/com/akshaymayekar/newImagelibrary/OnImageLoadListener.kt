package com.akshaymayekar.newImagelibrary

interface OnImageLoadListener {
    fun onSuccess(message: String)
    fun onFailed(e: Exception?)
}