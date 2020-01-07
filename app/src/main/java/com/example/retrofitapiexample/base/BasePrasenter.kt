package com.example.retrofitapiexample.base

import android.content.Context
import android.net.ConnectivityManager
import com.example.retrofitapiexample.application.MyApplication

open class BasePrasenter {

    fun isInternetConnected(): Boolean {
        val connectivityManager =
            MyApplication.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}