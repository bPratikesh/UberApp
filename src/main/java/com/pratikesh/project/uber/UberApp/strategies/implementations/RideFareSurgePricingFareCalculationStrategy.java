package com.pratikesh.project.uber.UberApp.strategies.implementations;

import com.pratikesh.project.uber.UberApp.dto.RideRequestDTO;
import com.pratikesh.project.uber.UberApp.entities.RideRequest;
import com.pratikesh.project.uber.UberApp.strategies.RideFareCalculationStrategy;

public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
