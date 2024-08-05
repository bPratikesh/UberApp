package com.pratikesh.project.uber.UberApp.strategies.implementations;

import com.pratikesh.project.uber.UberApp.dto.RideRequestDTO;
import com.pratikesh.project.uber.UberApp.entities.RideRequest;
import com.pratikesh.project.uber.UberApp.services.DistanceService;
import com.pratikesh.project.uber.UberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;
    private static final double SURGE_FACTOR = 2;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropOffLocation());
        return distance*RIDE_FARE_PER_KM*SURGE_FACTOR;
    }
}
