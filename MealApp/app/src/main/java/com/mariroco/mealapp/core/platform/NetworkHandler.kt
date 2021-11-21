package com.mariroco.mealapp.core.platform

import android.content.Context
import javax.inject.Inject
import com.mariroco.mealapp.core.extension.networkInfo

class NetworkHandler @Inject constructor(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnectedOrConnecting == true
}