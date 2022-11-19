package com.sixcandoit.decisiontoleave.data.api

import com.sixcandoit.decisiontoleave.data.model.ResponseHomeDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface HomeService {
    @GET("user")
    fun getUser(
        @Header("Authorization") accessToken: Int = -1
    ): Call<ResponseHomeDTO>
}