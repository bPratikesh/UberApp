package com.pratikesh.project.uber.UberApp.strategies;

import com.pratikesh.project.uber.UberApp.dto.RideRequestDTO;
import com.pratikesh.project.uber.UberApp.entities.Driver;
import com.pratikesh.project.uber.UberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

     List<Driver> findMatchingDrivers(RideRequest rideRequest);
}
