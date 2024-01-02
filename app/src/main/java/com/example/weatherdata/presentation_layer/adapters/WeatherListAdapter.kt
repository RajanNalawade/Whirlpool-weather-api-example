package com.example.weatherdata.presentation_layer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherdata.data_layer.remote.models.WeatherItems
import com.example.weatherdata.databinding.DateRowItemBinding
import com.example.weatherdata.databinding.WeatherBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import javax.inject.Inject

class WeatherListAdapter @Inject constructor() :
    ListAdapter<WeatherItems, WeatherListAdapter.WeatherViewHolder>(ListDifferentiator()) {

    private lateinit var binding: DateRowItemBinding

    inner class WeatherViewHolder(private val dateRowItemBinding: DateRowItemBinding) :
        ViewHolder(dateRowItemBinding.root) {
        fun bind(item: WeatherItems) {
            dateRowItemBinding.weatherData = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        this.binding =
            DateRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(this.binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {

            val bottomSheet = BottomSheetDialog(it.context)
            val bottomBinding = WeatherBottomSheetBinding.inflate(LayoutInflater.from(it.context))
            bottomBinding.weather = item

            bottomSheet.setCancelable(true)
            bottomSheet.setCanceledOnTouchOutside(true)
            bottomSheet.setContentView(bottomBinding.root)
            bottomSheet.show()
        }
        holder.bind(item)
    }

    class ListDifferentiator : DiffUtil.ItemCallback<WeatherItems>() {
        override fun areItemsTheSame(oldItem: WeatherItems, newItem: WeatherItems): Boolean {
            return oldItem.dt == newItem.dt
        }

        override fun areContentsTheSame(oldItem: WeatherItems, newItem: WeatherItems): Boolean {
            return oldItem == newItem
        }

    }
}