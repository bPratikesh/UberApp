package com.pratikesh.project.uber.UberApp.services;

import com.pratikesh.project.uber.UberApp.dto.DriverDTO;
import com.pratikesh.project.uber.UberApp.dto.RideDTO;
import com.pratikesh.project.uber.UberApp.dto.RideRequestDTO;
import com.pratikesh.project.uber.UberApp.dto.RiderDTO;
import com.pratikesh.project.uber.UberApp.entities.Rider;
import com.pratikesh.project.uber.UberApp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RiderService {

    RideRequestDTO requestRide(RideRequestDTO rideRequestDTO);
    RideDTO cancelRide(Long rideId);
    DriverDTO rateDriver(Long rideId, Integer rating);
    RiderDTO getMyProfile();
    Page<RideDTO> getMyAllRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
