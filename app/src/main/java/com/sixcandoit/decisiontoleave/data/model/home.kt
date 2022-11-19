package com.sixcandoit.decisiontoleave.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeDTO(
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: UserInfo
) {
    @Serializable
    data class UserInfo(
        @SerialName("userId")
        val userId: Int,
        @SerialName("name")
        val name: String,
        @SerialName("percent")
        val percent: Int,
        @SerialName("currentName")
        val currentName: String
    )
}