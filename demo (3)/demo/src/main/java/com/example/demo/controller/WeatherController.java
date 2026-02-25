package com.example.demo.controller;

import com.example.demo.entity.WeatherData;
import com.example.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    @GetMapping
    public String home() {
        return "Weather API is running successfully 🚀";
    }

    // ✅ Get weather data for a specific date
    @GetMapping("/date")
    public List<WeatherData> getWeatherByDate(@RequestParam String date) {

        LocalDate localDate = LocalDate.parse(date);

        LocalDateTime start = localDate.atStartOfDay();
        LocalDateTime end = localDate.atTime(23, 59, 59);

        return weatherService.getWeatherByDateRange(start, end);
    }

    // ✅ Get monthly temperature statistics
    @GetMapping("/stats")
    public Map<String, Double> getMonthlyStats(
            @RequestParam int year,
            @RequestParam int month) {

        return weatherService.getMonthlyTemperatureStats(year, month);
    }

    @PostMapping
public WeatherData saveWeather(@RequestBody WeatherData data) {
    return weatherService.saveWeather(data);
}
}