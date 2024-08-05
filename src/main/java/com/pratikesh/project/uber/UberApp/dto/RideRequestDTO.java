package com.pratikesh.project.uber.UberApp.dto;

import com.pratikesh.project.uber.UberApp.entities.Driver;
import com.pratikesh.project.uber.UberApp.entities.Rider;
import com.pratikesh.project.uber.UberApp.entities.enums.PaymentMethod;
import com.pratikesh.project.uber.UberApp.entities.enums.RideRequestStatus;
import com.pratikesh.project.uber.UberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDTO {

    private Long id;
    private PointDTO pickupLocation;
    private PointDTO dropOffLocation;
    private PaymentMethod paymentMethod;
    private LocalDateTime requestedTime;
    private RiderDTO rider;
    private Double fare;
    private RideRequestStatus rideRequestStatus;
}
