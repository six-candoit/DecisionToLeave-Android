package com.sixcandoit.decisiontoleave.data.api

import com.sixcandoit.decisiontoleave.data.model.RequestLoverReportDTO
import com.sixcandoit.decisiontoleave.data.model.ResponseLoverDTO
import com.sixcandoit.decisiontoleave.data.model.ResponseLoverReportDTO
import retrofit2.Call
import retrofit2.http.*

interface LoverService {
    /**
     * lover 질문 조회 API
     */
    @GET("content")
    fun getQuestionList(
        @Query("type") type: Int
    ): Call<ResponseLoverDTO>

    /**
     * lover 리포트 저장 API
     */
    @POST("report")
    fun setReport(
        @Header("Authorization") accessToken: String = "-1",
        @Body requestLoverReportDTO: RequestLoverReportDTO
    ): Call<ResponseLoverReportDTO>
}