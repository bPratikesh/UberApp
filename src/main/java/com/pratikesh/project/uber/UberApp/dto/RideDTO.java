package com.pratikesh.project.uber.UberApp.dto;

import com.pratikesh.project.uber.UberApp.entities.enums.PaymentMethod;
import com.pratikesh.project.uber.UberApp.entities.enums.RideStatus;
import lombok.Data;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
public class RideDTO {

    private Long id;
    private PointDTO pickupLocation;
    private PointDTO dropOffLocation;
    private LocalDateTime createdTime;
    private RiderDTO rider;
    private DriverDTO driver;
    private PaymentMethod paymentMethod;
    private RideStatus rideStatus;
    private Double fare;
    private String otp;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
