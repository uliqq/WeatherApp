package com.geektech.weatherapp.data.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.geektech.weatherapp.App;
import com.geektech.weatherapp.common.Resource;
import com.geektech.weatherapp.data.models.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    public MutableLiveData<Resource<Example>> getCurrentForecast() {
        MutableLiveData<Resource<Example>> liveData = new MutableLiveData<>();
        liveData.setValue(Resource.loading());
        App.api.getCurrentForeCast("Bishkek", "32e64ae83808e1a153bc0946fb51b2a1", "metric").enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage(), null));
            }
        });
        return liveData;
    }
}
