package com.pulsohaptico.bridge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pulsohaptico.bridge.model.SimulatedData;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimulatedDataResponse {

    private Double pulse;
    private Double latitude;
    private Double longitude;

    @JsonProperty("noise_level")
    private Double noiseLevel;

    @JsonProperty("date_time")
    private LocalDateTime dateTime;
    @JsonProperty("nearby_people")
    private Integer  nearbyPeople;

    public SimulatedDataResponse(SimulatedData simulatedData) {
        this.pulse = simulatedData.getPulse();
        this.latitude = simulatedData.getLatitude();
        this.longitude = simulatedData.getLongitude();
        this.noiseLevel = simulatedData.getNoiseLevel();
        this.dateTime = simulatedData.getDateTime();
        this.nearbyPeople = simulatedData.getNearbyPeople();
    }
}