package com.sixcandoit.decisiontoleave.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseReportDTO(
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
        @SerialName("percent")
        val percent: Int,
        @SerialName("currentName")
        val currentName: String,
        @SerialName("good")
        val good: Int,
        @SerialName("bad")
        val bad: Int,
        @SerialName("history")
        val history: List<History>
    ) {
        @Serializable
        data class History(
            @SerialName("content")
            val content: String,
            @SerialName("point")
            val point: Int,
            @SerialName("currentPercent")
            val currentPercent: Int
        )
    }
}

@Serializable
data class ResponseDecisionDTO(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String
)