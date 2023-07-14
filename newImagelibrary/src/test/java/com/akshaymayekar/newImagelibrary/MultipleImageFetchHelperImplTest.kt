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

class MultipleImageFetchHelperImplTest : TestCase() {

    @Test
    fun testMultipleImageService() {
        var scope = CoroutineScope(Dispatchers.IO)

        val service = ImageFetchHelperImpl(RetrofitBuilder.apiService, Const.WEB_API)

        scope.launch {
            service.getNumberOfDogImages(5).collect { response ->
                when (response) {

                    is Response.Failure -> {
                    }
                    is Response.Success -> {
                        Assert.assertEquals(response.data?.status, "Success")
                        Assert.assertEquals(response.data?.message?.size, 5)
                    }
                    else -> {}
                }

            }
        }


        // Assert.assertEquals(response.)
    }
}