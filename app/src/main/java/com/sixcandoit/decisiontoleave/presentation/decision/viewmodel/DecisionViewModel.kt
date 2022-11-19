package com.sixcandoit.decisiontoleave.presentation.decision.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sixcandoit.decisiontoleave.data.api.ApiClient
import com.sixcandoit.decisiontoleave.data.api.DecisionService
import com.sixcandoit.decisiontoleave.data.model.ResponseDecisionDTO
import com.sixcandoit.decisiontoleave.data.model.ResponseReportDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DecisionViewModel : ViewModel() {
    private val _reportResult: MutableLiveData<ResponseReportDTO> = MutableLiveData()
    val reportResult: LiveData<ResponseReportDTO>
        get() = _reportResult
    private val _decisionResult: MutableLiveData<ResponseDecisionDTO> = MutableLiveData()
    val decisionResult: LiveData<ResponseDecisionDTO>
        get() = _decisionResult

    private val homeService = ApiClient.getRetrofit().create(DecisionService::class.java)

    fun getReport() {
        homeService.getReport()
            .enqueue(object : Callback<ResponseReportDTO> {
                override fun onResponse(
                    call: Call<ResponseReportDTO>,
                    response: Response<ResponseReportDTO>
                ) {
                    if (response.isSuccessful) {
                        _reportResult.value = response.body()
                        Log.d("gio", "ok")
                    } else {
                        Log.d("gio", "fail")
                    }
                }

                override fun onFailure(call: Call<ResponseReportDTO>, t: Throwable) {
                    Log.d("gio", t.toString())
                }

            })
    }

    fun goodbye() {
        homeService.goodbye()
            .enqueue(object : Callback<ResponseDecisionDTO> {
                override fun onResponse(
                    call: Call<ResponseDecisionDTO>,
                    response: Response<ResponseDecisionDTO>
                ) {
                    if (response.isSuccessful) {
                        _decisionResult.value = response.body()
                        Log.d("gio", "ok")
                    } else {
                        Log.d("gio", "fail")
                    }
                }

                override fun onFailure(call: Call<ResponseDecisionDTO>, t: Throwable) {
                    Log.d("gio", "no wifi")
                }

            })
    }
}