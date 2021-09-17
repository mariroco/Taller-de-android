package com.mariroco.appexamen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Article (
    var Image: Int,
    var Title: String,
    var Content: String,
    var Status: Boolean
    ) : Parcelable {}