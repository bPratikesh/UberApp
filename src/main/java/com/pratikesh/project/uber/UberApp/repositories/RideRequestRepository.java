package com.pratikesh.project.uber.UberApp.repositories;

import com.pratikesh.project.uber.UberApp.entities.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {
}
