package com.example.retrofitapiexample.api

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class RetrofitClass private constructor() {

    companion object {
        private var BASE_URL = "https://jobs.github.com/"
        private var retrofit: Retrofit?= null
        private var apiInterface: ApiInterface?= null
        fun getApi(): ApiInterface? {
             retrofit = retrofit?:Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiInterface = apiInterface?:retrofit?.create(ApiInterface::class.java)
            return apiInterface
        }
    }
}