package com.mariroco.mealapp.core.extension

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


val Context.networkInfo: NetworkInfo?
    get() = (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo