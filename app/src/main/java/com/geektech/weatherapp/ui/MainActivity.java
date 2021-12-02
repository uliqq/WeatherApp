package com.geektech.weatherapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geektech.weatherapp.R;
import com.geektech.weatherapp.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}