package com.example.retrofitapiexample.view

import com.example.retrofitapiexample.model.JobsFinderModel

interface JobFinderView {
    fun showList(body: List<JobsFinderModel>)
    fun showMessage(message: String)
}