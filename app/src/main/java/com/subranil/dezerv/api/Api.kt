package com.subranil.dezerv.api


import com.subranil.dezerv.model.ModelData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {

    @GET("bdf35c2659dd")
    suspend fun getData(): Response<ModelData>

    companion object {
        operator fun invoke(): Api {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://json.extendsclass.com/bin/")
                .build()
                .create(Api::class.java)
        }
    }
}