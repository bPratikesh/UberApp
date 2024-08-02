package com.pratikesh.project.uber.UberApp.controllers;

import com.pratikesh.project.uber.UberApp.dto.RideRequestDTO;
import com.pratikesh.project.uber.UberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor    //defining constructor dependency without creating any constructor
public class RiderController {

    private final RiderService riderService;

    @PostMapping(path = "/requestRide")
    public ResponseEntity<RideRequestDTO> requestRide(@RequestBody RideRequestDTO rideRequestDTO){
        return ResponseEntity.ok(riderService.requestRide(rideRequestDTO));
    }
}
