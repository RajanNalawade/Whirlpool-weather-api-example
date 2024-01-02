package com.example.weatherdata.presentation_layer.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("loadIcon")
fun getWeatherIcon(view: ImageView, icon: String) {
    Glide.with(view.context).load("https://openweathermap.org/img/wn/$icon.png").into(view)
}

@BindingAdapter("textInCelcius")
fun setCelcius(view: TextView, input: String){
    view.text = "$input \u2103"
}