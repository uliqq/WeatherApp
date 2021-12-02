package com.geektech.weatherapp;

import android.app.Application;

import com.geektech.weatherapp.data.remote.RetrofitClient;
import com.geektech.weatherapp.data.remote.WeatherApi;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {
    public static WeatherApi api;
    private RetrofitClient retrofitClient;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideApi();
    }

}
