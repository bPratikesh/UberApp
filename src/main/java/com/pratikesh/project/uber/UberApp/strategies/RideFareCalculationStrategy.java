package com.pratikesh.project.uber.UberApp.strategies;

import com.pratikesh.project.uber.UberApp.dto.RideRequestDTO;
import com.pratikesh.project.uber.UberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_PER_KM = 10;

    double calculateFare(RideRequest rideRequest);
}
