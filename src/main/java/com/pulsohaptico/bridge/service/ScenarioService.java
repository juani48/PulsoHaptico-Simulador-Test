package com.pulsohaptico.bridge.service;

import com.pulsohaptico.bridge.model.SimulatedData;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ScenarioService {
    private static final DateTimeFormatter DATETIME_LOCAL_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    private SimulatedData simulatedData;

    public ScenarioService() {
        this.simulatedData = new SimulatedData(
                70.0,
                0.0, // latitude
                0.0, // longitude
                0.0, // noiseLevel
                LocalDateTime.now(), // dateTime
                0 // nearbyPeople
        );
    }

    // --- Contexto del celular ---
    public void setData(double pulse, double latitude, double longitude, double noiseLevel, String dateTime, int nearbyPeople) {
        this.simulatedData.setPulse(pulse);
        this.simulatedData.setLatitude(latitude);
        this.simulatedData.setLongitude(longitude);
        this.simulatedData.setNoiseLevel(noiseLevel);
        this.simulatedData.setDateTime(LocalDateTime.parse(dateTime, DATETIME_LOCAL_FORMAT));
        this.simulatedData.setNearbyPeople(nearbyPeople);
    }

    public SimulatedData getSimulatedData() {
        return this.simulatedData;
    }
}