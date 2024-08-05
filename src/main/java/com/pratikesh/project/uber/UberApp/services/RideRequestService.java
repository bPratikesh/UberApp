package com.pratikesh.project.uber.UberApp.services;

import com.pratikesh.project.uber.UberApp.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

}
