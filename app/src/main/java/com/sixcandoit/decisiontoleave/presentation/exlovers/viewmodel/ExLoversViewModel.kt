package com.sixcandoit.decisiontoleave.presentation.exlovers.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sixcandoit.decisiontoleave.data.api.ApiClient
import com.sixcandoit.decisiontoleave.data.api.ExloversService
import com.sixcandoit.decisiontoleave.data.model.ResponseExloversDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExLoversViewModel : ViewModel() {
    private val _exLovers: MutableLiveData<ResponseExloversDTO> = MutableLiveData()
    val exLovers: LiveData<ResponseExloversDTO>
        get() = _exLovers
    private val _errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: LiveData<Int>
        get() = _errorMessage

    private val exloversService = ApiClient.getRetrofit().create(ExloversService::class.java)

    fun login(id: String, pw: String) {
        exloversService.exloversList().enqueue(object : Callback<ResponseExloversDTO> {
            override fun onResponse(
                call: Call<ResponseExloversDTO>,
                response: Response<ResponseExloversDTO>
            ) {
                if (response.isSuccessful) {
                    Log.e("success", "서버는 성공임")
                    _exLovers.value = response.body()

                } else {
                    _errorMessage.value = response.body()?.status
                }
            }

            override fun onFailure(call: Call<ResponseExloversDTO>, t: Throwable) {
                //get 실패(서버통신 오류)
                Log.e("fail", "message : " + t.message)
            }
        })
    }
}
