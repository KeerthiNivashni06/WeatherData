package com.example.demo.repository;


import com.example.demo.entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Long> {

    List<WeatherData> findByDatetimeBetween(
            LocalDateTime start,
            LocalDateTime end
    );
}