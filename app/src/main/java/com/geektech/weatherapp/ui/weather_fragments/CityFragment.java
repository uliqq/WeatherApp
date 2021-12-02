package com.geektech.weatherapp.ui.weather_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.weatherapp.R;
import com.geektech.weatherapp.databinding.FragmentBaseBinding;
import com.geektech.weatherapp.databinding.FragmentCityBinding;
import com.geektech.weatherapp.ui.base.BaseFragment;


public class CityFragment extends BaseFragment<FragmentCityBinding> {


    public CityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    @Override
    protected FragmentCityBinding bind() {
        return FragmentCityBinding.inflate(getLayoutInflater());
    }


    @Override
    protected void setupUI() {
        binding.btnSelect.setOnClickListener(v -> {
            if (binding.etText.getText() != null){
                String city = binding.etText.getText().toString();
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host);
                navController.navigate((NavDirections) CityFragmentDirections.actionCityFragmentToWeatherFragment(city));
            }
        });
    }

    @Override
    protected void setupObservers() {

    }
}