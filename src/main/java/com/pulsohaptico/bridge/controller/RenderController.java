package com.pulsohaptico.bridge.controller;

import com.pulsohaptico.bridge.dto.SimulatedDataResponse;
import com.pulsohaptico.bridge.model.SimulatedData;
import com.pulsohaptico.bridge.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RenderController {
    private final ScenarioService scenarioService;

    @GetMapping("/")
    public String index(Model model) {
        addPageData(model);
        return "index";
    }

    @PostMapping("/set-context")
    public SimulatedDataResponse setContext(
            @RequestParam double pulse,
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double noiseLevel,
            @RequestParam String dateTime,
            @RequestParam int nearbyPeople
    ) {
        if (pulse < 40 || pulse > 180) {
            throw new IllegalArgumentException("Pulse must be between 40 and 180");
        }
        scenarioService.setData(pulse, latitude, longitude, noiseLevel, dateTime, nearbyPeople);
        System.out.println("---- VALORES: " + pulse + "-"+ latitude+"-"+longitude+"-"+noiseLevel+"-"+dateTime+"-"+nearbyPeople);
        return new SimulatedDataResponse(scenarioService.getSimulatedData());
    }

    private void addPageData(Model model) {
        SimulatedData simulatedData = scenarioService.getSimulatedData();
        model.addAttribute("pulse", simulatedData.getPulse());
        model.addAttribute("latitude", simulatedData.getLatitude());
        model.addAttribute("longitude", simulatedData.getLongitude());
        model.addAttribute("noiseLevel", simulatedData.getNoiseLevel());
        model.addAttribute("dateTime", simulatedData.getDateTime());
        model.addAttribute("nearbyPeople", simulatedData.getNearbyPeople());
    }
}