package com.mariroco.p2_practica1.core.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.mariroco.p2_practica1.R

@BindingAdapter("loadFromUrl")
fun ImageView.loadFromURL(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_cocktail)
    transformations(CircleCropTransformation())
}