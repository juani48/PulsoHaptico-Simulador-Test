package com.pulsohaptico.bridge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class SimulatedData {
    private Double pulse;
    private Double latitude;
    private Double longitude;
    private Double noiseLevel;
    private LocalDateTime dateTime;
    private Integer  nearbyPeople;
}
