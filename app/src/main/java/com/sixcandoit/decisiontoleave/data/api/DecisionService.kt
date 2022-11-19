package com.sixcandoit.decisiontoleave.data.api

import com.sixcandoit.decisiontoleave.data.model.ResponseDecisionDTO
import com.sixcandoit.decisiontoleave.data.model.ResponseReportDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface DecisionService {
    @GET("report")
    fun getReport(
        @Header("Authorization") accessToken: Int = -1
    ): Call<ResponseReportDTO>

    @POST("report/end")
    fun goodbye(
        @Header("Authorization") accessToken: Int = -1
    ): Call<ResponseDecisionDTO>
}