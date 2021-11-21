package com.mariroco.mealapp.core.extension

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.mariroco.mealapp.R


@BindingAdapter("loadFromUrl")
fun ImageView.loadFromURL(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_meal)
}
