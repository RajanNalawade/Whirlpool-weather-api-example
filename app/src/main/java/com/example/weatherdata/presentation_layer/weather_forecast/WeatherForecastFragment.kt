package com.example.weatherdata.presentation_layer.weather_forecast

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.weatherdata.data_layer.remote.models.WeatherItems
import com.example.weatherdata.databinding.FragmentWeatherForecastBinding
import com.example.weatherdata.presentation_layer.adapters.WeatherListAdapter
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


@AndroidEntryPoint
class WeatherForecastFragment : Fragment() {

    private val viewModel: WeatherForecastViewModel by viewModels<WeatherForecastViewModel>()

    private val compositeDisposable = CompositeDisposable()

    private lateinit var binding: FragmentWeatherForecastBinding

    @Inject
    lateinit var adapter: WeatherListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentWeatherForecastBinding.inflate(inflater, container, false)

        adapter.let { wAda ->
            binding.rvWeatherList.apply {
                adapter = wAda
                addItemDecoration(
                    DividerItemDecoration(
                        activity, DividerItemDecoration.VERTICAL
                    )
                )
                setHasFixedSize(true)
                itemAnimator = DefaultItemAnimator()
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        compositeDisposable.add(viewModel.mWeeklyWeather.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).doOnSubscribe { binding.isLoading = true }
            .doOnTerminate { binding.isLoading = false }.subscribeBy(onNext = {
                val dateWiseWeather = LinkedHashMap<String, WeatherItems>()
                it.list.forEach { x ->
                    val date = x.dtTxt.split(" ")
                    if (!dateWiseWeather.containsKey(date[0])) {
                        dateWiseWeather[date[0]] = x
                    }
                }

                adapter.submitList(dateWiseWeather.values.toList())
            }, onError = {
                Log.d("Weather", "onStart: ${it.printStackTrace()}")
            }, onComplete = {
                Log.d("Weather", "onStart: completed..")
            })
        )
    }

    override fun onDestroyView() {
        compositeDisposable.dispose()
        super.onDestroyView()
    }

}