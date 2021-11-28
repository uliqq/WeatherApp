package com.geektech.weatherapp.ui.weather_fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.weatherapp.data.models.Weather;
import com.geektech.weatherapp.databinding.ItemWeatherForecastBinding;

import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    private List<Weather> list;

    public void setList(List<Weather> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWeatherForecastBinding binding = ItemWeatherForecastBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemWeatherForecastBinding binding;

        public ViewHolder(@NonNull ItemWeatherForecastBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Weather weather) {
            binding.dateTV.setText(weather.getMain());
        }
    }
}
