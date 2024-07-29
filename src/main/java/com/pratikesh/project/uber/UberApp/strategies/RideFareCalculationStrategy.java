package com.pratikesh.project.uber.UberApp.strategies;

import com.pratikesh.project.uber.UberApp.dto.RideRequestDTO;

public interface RideFareCalculationStrategy {

    double calculateFare(RideRequestDTO rideRequestDTO);
}
