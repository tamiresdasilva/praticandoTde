package com.example.praticandotde

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("loadPhoto")
    @JvmStatic
    fun loadPhoto(view: ImageView, url: String) {
        Glide.with(view.context).load(url).centerCrop().into(view)
    }
}