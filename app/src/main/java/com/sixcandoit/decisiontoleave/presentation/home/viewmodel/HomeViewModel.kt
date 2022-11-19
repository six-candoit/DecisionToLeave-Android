package com.sixcandoit.decisiontoleave.presentation.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sixcandoit.decisiontoleave.data.api.ApiClient
import com.sixcandoit.decisiontoleave.data.api.HomeService
import com.sixcandoit.decisiontoleave.data.model.ResponseHomeDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _homeResult: MutableLiveData<ResponseHomeDTO> = MutableLiveData()
    val homeResult: LiveData<ResponseHomeDTO>
        get() = _homeResult
    private val homeService = ApiClient.getRetrofit().create(HomeService::class.java)

    fun getUser() {
        homeService.getUser()
            .enqueue(object : Callback<ResponseHomeDTO> {
                override fun onResponse(
                    call: Call<ResponseHomeDTO>,
                    response: Response<ResponseHomeDTO>
                ) {
                    if (response.isSuccessful) {
                        Log.d("서버 통신 완료!!!!!!!", response.message())
                        _homeResult.value = response.body()
                    } else {
                    }
                }

                override fun onFailure(call: Call<ResponseHomeDTO>, t: Throwable) {
                    Log.d("서버 오류", t.toString())
                }

            })
    }
}