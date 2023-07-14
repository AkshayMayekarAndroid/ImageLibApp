package com.akshaymayekar.newImagelibrary

import com.akshaymayekar.apiHelper.ImageFetchHelperImpl
import com.akshaymayekar.apiHelper.RetrofitBuilder
import com.akshaymayekar.util.Const
import com.akshaymayekar.util.Response
import junit.framework.TestCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Assert
import org.junit.Test

class ImageFetchHelperImplTest : TestCase() {

    @Test
    fun testImageService() {
        var scope = CoroutineScope(Dispatchers.IO)

        val service = ImageFetchHelperImpl(RetrofitBuilder.apiService, Const.WEB_API)
       /* imageFetchHelper.getRandomDogImage().collect { response ->
            when (response) {
                is Response.Failure -> {}//onImageLoadListener.onFailed(response.e)}
                is Response.Success -> {
                    response.data?.let {
                        onImageLoadListener.onSuccess(it.message)
                    }
                }
            }
        }*/
        scope.launch {
            service.getRandomDogImage().collect { response ->
                when (response) {

                    is Response.Failure -> {}
                    is Response.Success -> {
                        Assert.assertEquals(response.data?.status, "Success")
                    }
                    else -> {}
                }

            }
        }


        // Assert.assertEquals(response.)
    }

}