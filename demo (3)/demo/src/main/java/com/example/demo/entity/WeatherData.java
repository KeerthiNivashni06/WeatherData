
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather_data")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime datetime;

    private String conds;

    private Double tempm;

    private Double hum;

    private Double pressure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getConds() {
        return conds;
    }

    public void setConds(String conds) {
        this.conds = conds;
    }

    public Double getTempm() {
        return tempm;
    }

    public void setTempm(Double tempm) {
        this.tempm = tempm;
    }

    public Double getHum() {
        return hum;
    }

    public void setHum(Double hum) {
        this.hum = hum;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }
}




 