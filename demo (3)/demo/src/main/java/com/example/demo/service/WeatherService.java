package com.example.demo.service;
import com.example.demo.entity.WeatherData;
import com.example.demo.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    public List<WeatherData> getWeatherByDateRange(
            LocalDateTime start,
            LocalDateTime end) {

        return weatherRepository.findByDatetimeBetween(start, end);
    }



    public Map<String, Double> getMonthlyTemperatureStats(int year, int month) {

        List<WeatherData> data = weatherRepository.findAll();
        List<Double> temps = new ArrayList<>();

        for (WeatherData w : data) {
            if (w.getDatetime().getYear() == year &&
                w.getDatetime().getMonthValue() == month &&
                w.getTempm() != null) {
                temps.add(w.getTempm());
            }
        }

        Collections.sort(temps);

        if (temps.isEmpty()) return Map.of();

        double min = temps.get(0);
        double max = temps.get(temps.size() - 1);

        double median;
        int size = temps.size();
        median = (size % 2 == 0)
                ? (temps.get(size / 2 - 1) + temps.get(size / 2)) / 2
                : temps.get(size / 2);

        return Map.of(
                "min", min,
                "max", max,
                "median", median
        );
    }

    public WeatherData saveWeather(WeatherData data) {
    return weatherRepository.save(data);
}
}