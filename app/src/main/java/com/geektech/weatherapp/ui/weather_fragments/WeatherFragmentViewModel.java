package com.geektech.weatherapp.ui.weather_fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.weatherapp.common.Resource;
import com.geektech.weatherapp.data.models.Example;
import com.geektech.weatherapp.data.repositories.MainRepository;

public class WeatherFragmentViewModel extends ViewModel {
    private MainRepository repository;
    public LiveData<Resource<Example>> LiveData;

    public WeatherFragmentViewModel() {
        this.repository = new MainRepository();
    }

    public void fetchCurrentForeCast() {
        LiveData = repository.getCurrentForecast();
    }
}
