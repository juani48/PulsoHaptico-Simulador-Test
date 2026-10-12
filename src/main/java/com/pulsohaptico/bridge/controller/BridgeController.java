package com.pulsohaptico.bridge.controller;

import com.pulsohaptico.bridge.dto.SimulatedDataResponse;
import com.pulsohaptico.bridge.service.ScenarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@Tag(name = "Bridge", description = "Operaciones para consultar el estado del bridge")
public class BridgeController {
    private final ScenarioService scenarioService;

    @GetMapping("/get-data")
    @Operation(summary = "Consultar el escenario seleccionado", description = "Devuelve el escenario activo junto con el pulso y estado actuales.")
    public ResponseEntity<SimulatedDataResponse> state() {
        return ResponseEntity.ok(new SimulatedDataResponse(scenarioService.getSimulatedData()));
    }
}
