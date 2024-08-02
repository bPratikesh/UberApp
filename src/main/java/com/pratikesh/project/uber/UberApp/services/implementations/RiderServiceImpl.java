package com.pratikesh.project.uber.UberApp.services.implementations;

import com.pratikesh.project.uber.UberApp.dto.DriverDTO;
import com.pratikesh.project.uber.UberApp.dto.RideDTO;
import com.pratikesh.project.uber.UberApp.dto.RideRequestDTO;
import com.pratikesh.project.uber.UberApp.dto.RiderDTO;
import com.pratikesh.project.uber.UberApp.entities.RideRequest;
import com.pratikesh.project.uber.UberApp.entities.Rider;
import com.pratikesh.project.uber.UberApp.entities.User;
import com.pratikesh.project.uber.UberApp.entities.enums.RideRequestStatus;
import com.pratikesh.project.uber.UberApp.repositories.RideRequestRepository;
import com.pratikesh.project.uber.UberApp.repositories.RiderRepository;
import com.pratikesh.project.uber.UberApp.services.RiderService;
import com.pratikesh.project.uber.UberApp.strategies.DriverMatchingStrategy;
import com.pratikesh.project.uber.UberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideFareCalculationStrategy rideFareCalculationStrategy;
    private final DriverMatchingStrategy driverMatchingStrategy;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;



    @Override
    public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
        RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        Double fare = rideFareCalculationStrategy.calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        driverMatchingStrategy.findMatchingDrivers(rideRequest);

        return modelMapper.map(savedRideRequest, RideRequestDTO.class);
    }

    @Override
    public RideDTO cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDTO rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDTO getMyProfile() {
        return null;
    }

    @Override
    public List<RideDTO> getMyAllRides() {
        return null;
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }
}
