package com.akshaymayekar.newImagelibrary

import com.akshaymayekar.apiHelper.RetrofitBuilder
import com.akshaymayekar.util.Const
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test
import retrofit2.Retrofit

class RetrofitBuilderTest : TestCase() {

    @Test
    fun testRetrofitInstance() {
        //Get an instance of Retrofit
        val instance: Retrofit = RetrofitBuilder.getRetrofit()
        //Assert that, Retrofit's base url matches to our BASE_URL
        Assert.assertEquals(instance.baseUrl().toUrl().toString(), Const.WEB_API)
       // Assert.assertEquals(10,5+5)
    }


}