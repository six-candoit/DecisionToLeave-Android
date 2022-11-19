package com.sixcandoit.decisiontoleave.data.api

import com.sixcandoit.decisiontoleave.data.model.ResponseExloversDTO
import retrofit2.Call
import retrofit2.http.GET

interface ExloversService {
    @GET("report/all")
        fun exloversList(): Call<ResponseExloversDTO>
}