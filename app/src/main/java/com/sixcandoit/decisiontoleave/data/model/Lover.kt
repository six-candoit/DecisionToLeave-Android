package com.sixcandoit.decisiontoleave.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseLoverDTO(
    @SerialName("status") val status: Int,
    @SerialName("success") val success: Boolean,
    @SerialName("message") val message: String,
    @SerialName("data") val questionList: ResultLover
)

@Serializable
data class ResultLover(
    @SerialName("contentList") val contentList: List<String>
)

@Serializable
data class RequestLoverReportDTO(
    @SerialName("content") val content: String,
    @SerialName("point") val point: Int
)

@Serializable
data class ResponseLoverReportDTO(
    @SerialName("status") val status: Int,
    @SerialName("reportId") val reportId: Int,
    @SerialName("content") val content: String,
    @SerialName("point") val point: Int
)