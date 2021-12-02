package com.geektech.weatherapp.ui.weather_fragments;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.weatherapp.common.Resource;
import com.geektech.weatherapp.data.models.Example;
import com.geektech.weatherapp.data.repositories.MainRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WeatherFragmentViewModel extends ViewModel {
    private MainRepository repository;
    public LiveData<Resource<Example>> LiveData;

    @Inject
    public WeatherFragmentViewModel(MainRepository repository) {
        this.repository = repository;
    }

    public void fetchCurrentForeCast(@Nullable String city) {
        LiveData = repository.getCurrentForecast(city);
    }
}
