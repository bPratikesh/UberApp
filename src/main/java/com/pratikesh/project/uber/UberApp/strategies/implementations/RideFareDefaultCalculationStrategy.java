package com.pratikesh.project.uber.UberApp.strategies.implementations;

import com.pratikesh.project.uber.UberApp.dto.RideRequestDTO;
import com.pratikesh.project.uber.UberApp.strategies.RideFareCalculationStrategy;

public class RideFareDefaultCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDTO rideRequestDTO) {
        return 0;
    }
}
