package com.sixcandoit.decisiontoleave.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseExloversDTO(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: Data
) {
    @Serializable
    data class Data(
        @SerialName("userId")
        val userId: Int,
        @SerialName("name")
        val name: String,
        @SerialName("reportList")
        val reportList: List<Report>
    ) {
        @Serializable
        data class Report(
            @SerialName("reportId")
            val userId: Int,
            @SerialName("exName")
            val exName: String,
            @SerialName("percent")
            val percent: Int,
            @SerialName("history")
            val history: List<History>
        ) {
            @Serializable
            data class History(
                @SerialName("content")
                val content: Int,
                @SerialName("point")
                val point: Int,
                @SerialName("currentPercent")
                val currentPercent: Int
            )
        }
    }
}