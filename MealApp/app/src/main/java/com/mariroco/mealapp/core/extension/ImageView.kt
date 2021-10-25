package com.mariroco.mealapp.core.extension

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.mariroco.mealapp.R
import androidx.core.graphics.drawable.DrawableCompat

import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toDrawable

@BindingAdapter("loadFromUrl")
fun ImageView.loadFromURL(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_meal)
}
