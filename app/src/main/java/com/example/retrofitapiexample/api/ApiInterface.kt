package com.example.retrofitapiexample.api

import com.example.retrofitapiexample.model.JobsFinderModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/positions.json")
    fun getJobsDetails(@Query("description")description:String,@Query("page")pageNumber :Int): Call<List<JobsFinderModel>>
}