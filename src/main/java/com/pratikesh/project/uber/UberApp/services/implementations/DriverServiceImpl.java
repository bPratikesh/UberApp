package com.pratikesh.project.uber.UberApp.services.implementations;

import com.pratikesh.project.uber.UberApp.dto.DriverDTO;
import com.pratikesh.project.uber.UberApp.dto.RideDTO;
import com.pratikesh.project.uber.UberApp.dto.RiderDTO;
import com.pratikesh.project.uber.UberApp.entities.Driver;
import com.pratikesh.project.uber.UberApp.entities.RideRequest;
import com.pratikesh.project.uber.UberApp.entities.enums.RideRequestStatus;
import com.pratikesh.project.uber.UberApp.exceptions.ResourceNotFoundException;
import com.pratikesh.project.uber.UberApp.repositories.DriverRepository;
import com.pratikesh.project.uber.UberApp.services.DriverService;
import com.pratikesh.project.uber.UberApp.services.RideRequestService;
import com.pratikesh.project.uber.UberApp.services.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final RideRequestService rideRequestService;
    private final DriverRepository driverRepository;
    private final RideService rideService;

    @Override
    @Transactional
    public RideDTO acceptRide(Long rideRequestId) {
        RideRequest rideRequest = rideRequestService.findRideRequestById(rideRequestId);

        if(!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)){
            throw new RuntimeException("Ride request cannot be accepted, status is "+rideRequest.getRideRequestStatus());
        }

        Driver currentDriver = getCurrentDriver();
        if(!currentDriver.getAvailable()){
            throw new RuntimeException("Driver cannot accept the ride due to unavailability");
        }

        rideService.createNewRide(rideRequest, currentDriver);

        return null;
    }

    @Override
    public RideDTO cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDTO startRide(Long rideId) {
        return null;
    }

    @Override
    public RideDTO endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDTO rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public DriverDTO getMyProfile() {
        return null;
    }

    @Override
    public List<RideDTO> getMyAllRides() {
        return null;
    }

    @Override
    public Driver getCurrentDriver() {
        return driverRepository.findById(2L).orElseThrow(()-> new ResourceNotFoundException("Current Driver not found with id: "+ 2));
    }
}
