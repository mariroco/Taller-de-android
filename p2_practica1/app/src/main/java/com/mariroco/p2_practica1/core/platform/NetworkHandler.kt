package com.mariroco.p2_practica1.core.platform

import android.content.Context
import com.mariroco.p2_practica1.core.extension.networkInfo
import javax.inject.Inject

class NetworkHandler @Inject constructor( private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnectedOrConnecting == true
}