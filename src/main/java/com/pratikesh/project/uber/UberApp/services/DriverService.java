package com.pratikesh.project.uber.UberApp.services;

import com.pratikesh.project.uber.UberApp.dto.DriverDTO;
import com.pratikesh.project.uber.UberApp.dto.RideDTO;
import com.pratikesh.project.uber.UberApp.dto.RiderDTO;

import java.util.List;

public interface DriverService {
    RideDTO acceptRide(Long rideId);
    RideDTO cancelRide(Long rideId);
    RideDTO startRide(Long rideId);
    RideDTO endRide(Long rideId);
    RiderDTO rateRider(Long rideId, Integer rating);
    DriverDTO getMyProfile();
    List<RideDTO> getMyAllRides();

}
