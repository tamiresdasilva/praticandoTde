package com.example.praticandotde

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("loadPhoto")
    @JvmStatic
    fun ImageView.loadPhoto(url: String) {
        Glide.with(context).load(url).placeholder(R.drawable.ic_launcher_background).into(this)
    }
}