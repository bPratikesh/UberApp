package com.pratikesh.project.uber.UberApp.services;

import com.pratikesh.project.uber.UberApp.dto.DriverDTO;
import com.pratikesh.project.uber.UberApp.dto.RideDTO;
import com.pratikesh.project.uber.UberApp.dto.RiderDTO;
import com.pratikesh.project.uber.UberApp.entities.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface DriverService {
    RideDTO acceptRide(Long rideRequestId);
    RideDTO cancelRide(Long rideId);
    RideDTO startRide(Long rideId, String otp);
    RideDTO endRide(Long rideId);
    RiderDTO rateRider(Long rideId, Integer rating);
    DriverDTO getMyProfile();
    Page<RideDTO> getMyAllRides(PageRequest pageRequest);
    Driver getCurrentDriver();
    Driver updateDriverAvailability(Driver driver, boolean available);

}
