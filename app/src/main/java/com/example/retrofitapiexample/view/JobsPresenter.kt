package com.example.retrofitapiexample.view

import com.example.retrofitapiexample.api.RetrofitClass
import com.example.retrofitapiexample.base.BasePrasenter
import com.example.retrofitapiexample.model.JobsFinderModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class JobsPresenter(val jobFinderView: JobFinderView) : BasePrasenter() {

    fun callApi() {
        if (!isInternetConnected()) {
            jobFinderView.showMessage("No Internet Connection")
            return
        }

        val call = RetrofitClass.getApi()?.getJobsDetails("java", 1)
        call?.enqueue(object : Callback<List<JobsFinderModel>> {
            override fun onFailure(call: Call<List<JobsFinderModel>>?, t: Throwable?) {
                jobFinderView.showMessage(t?.message.toString())
            }

            override fun onResponse(
                call: Call<List<JobsFinderModel>>?,
                response: Response<List<JobsFinderModel>>?
            ) {
                if (response?.isSuccessful == true) {
                    jobFinderView.showList(response.body())
                }
            }
        })
    }
}