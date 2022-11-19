package com.sixcandoit.decisiontoleave.presentation.lover.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sixcandoit.decisiontoleave.data.api.ApiClient
import com.sixcandoit.decisiontoleave.data.api.LoverService
import com.sixcandoit.decisiontoleave.data.model.RequestLoverReportDTO
import com.sixcandoit.decisiontoleave.data.model.ResponseLoverDTO
import com.sixcandoit.decisiontoleave.data.model.ResponseLoverReportDTO
import com.sixcandoit.decisiontoleave.util.Event
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoverViewModel : ViewModel() {
    private val loverService = ApiClient.getRetrofit().create(LoverService::class.java)

    private var type: String = ""

    private val _questionList = MutableLiveData<List<String>>()
    val questionList: LiveData<List<String>>
        get() = _questionList

    private val _reportEvent = MutableLiveData<Event<Boolean>>()
    val reportEvent: LiveData<Event<Boolean>>
        get() = _reportEvent

    private val _contentEvent = MutableLiveData<Event<Boolean>>()
    val contentEvent: LiveData<Event<Boolean>>
        get() = _contentEvent

    private var content: String = ""

    fun setContent(text: String) {
        content = text
        _contentEvent.value = Event(true)
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getContent(): String {
        return content
    }

    fun getType(): String {
        return type
    }

    fun getQuestionList(type: Int) {
        loverService.getQuestionList(type).enqueue(object : Callback<ResponseLoverDTO> {
            override fun onResponse(
                call: Call<ResponseLoverDTO>,
                response: Response<ResponseLoverDTO>
            ) {
                if (response.isSuccessful) {
                    _questionList.value = response.body()!!.questionList.contentList
                }
            }

            override fun onFailure(call: Call<ResponseLoverDTO>, t: Throwable) {
                Log.d("SSS", t.toString())
            }
        })
    }

    fun setReport(requestLoverReportDTO: RequestLoverReportDTO) {
        loverService.setReport(requestLoverReportDTO = requestLoverReportDTO)
            .enqueue(object : Callback<ResponseLoverReportDTO> {
                override fun onResponse(
                    call: Call<ResponseLoverReportDTO>,
                    response: Response<ResponseLoverReportDTO>
                ) {
                    if (response.isSuccessful) {
                        _reportEvent.value = Event(true)
                    }
                }

                override fun onFailure(call: Call<ResponseLoverReportDTO>, t: Throwable) {
                }
            })
    }
}