package com.geektech.weatherapp.ui.weather_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.geektech.weatherapp.R;
import com.geektech.weatherapp.common.Resource;
import com.geektech.weatherapp.data.models.Example;
import com.geektech.weatherapp.data.models.Main;
import com.geektech.weatherapp.data.models.Sys;
import com.geektech.weatherapp.data.models.Weather;
import com.geektech.weatherapp.data.models.Wind;
import com.geektech.weatherapp.databinding.FragmentBaseBinding;
import com.geektech.weatherapp.databinding.FragmentWeatherBinding;
import com.geektech.weatherapp.ui.base.BaseFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WeatherFragment extends BaseFragment<FragmentWeatherBinding> {



    private WeatherFragmentViewModel viewModel;
    private Main main;
    private Wind wind;
    private Example example;
    private Sys sys;
    private List<Weather> weatherList = new ArrayList<>();
    private ForecastAdapter adapter;

    public WeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ForecastAdapter();
    }

    @Override
    protected FragmentWeatherBinding bind() {
        return FragmentWeatherBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupUI() {
        viewModel = new ViewModelProvider(requireActivity()).get(WeatherFragmentViewModel.class);
        viewModel.fetchCurrentForeCast();
    }

    @Override
    protected void setupObservers() {
        viewModel.LiveData.observe(getViewLifecycleOwner(), new Observer<Resource<Example>>() {
            @Override
            public void onChanged(Resource<Example> exampleResource) {
                switch (exampleResource.status){
                    case  SUCCESS:{
                        main = exampleResource.data.getMain();
                        wind = exampleResource.data.getWind();
                        example =  exampleResource.data;
                        sys = exampleResource.data.getSys();
                        weatherList = exampleResource.data.getWeather();
                        SimpleDateFormat sdf = new SimpleDateFormat("hh:MM");

                        binding.sunnyTv.setText(weatherList.get(0).getMain());
                        binding.cityBtn.setText(example.getName());
                        binding.currentTempTV.setText(String.valueOf((int) Math.round(main.getTemp())));
                        binding.minDegreeTV.setText(String.valueOf((int) Math.round(main.getTempMin())));
                        binding.maxDegreeTV.setText(String.valueOf((int) Math.round(main.getTempMax())));
                        binding.progress.setVisibility(View.GONE);
                        Glide.with(requireContext())
                                .load("https://openweathermap.org/img/wn/" + weatherList.get(0).getIcon() + ".png")
                                .into(binding.weatherIV);
                        binding.humidityTV.setText(main.getHumidity() + "%");
                        binding.pressureTV.setText(main.getPressure() + "mBar");
                        binding.sunriseTV.setText(sdf.format(sys.getSunrise()));
                        binding.sunsetTV.setText(sdf.format(sys.getSunset()));
                        binding.windTV.setText(wind.getSpeed() +  "m/s");
                        binding.dayTimeTV.setText(sdf.format(example.getDt()));
                        break;
                    }
                    case LOADING:{
                        binding.progress.setVisibility(View.VISIBLE);
                        break;
                    }
                    case ERROR:{
                        binding.progress.setVisibility(View.GONE);
                        break;
                    }
                }
            }
        });
    }
}