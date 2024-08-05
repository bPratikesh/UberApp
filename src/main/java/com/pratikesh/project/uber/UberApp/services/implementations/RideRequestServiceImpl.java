package com.pratikesh.project.uber.UberApp.services.implementations;

import com.pratikesh.project.uber.UberApp.entities.RideRequest;
import com.pratikesh.project.uber.UberApp.exceptions.ResourceNotFoundException;
import com.pratikesh.project.uber.UberApp.repositories.RideRequestRepository;
import com.pratikesh.project.uber.UberApp.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;
    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(()-> new ResourceNotFoundException("Ride Request not found with id: "+rideRequestId));
    }
}
