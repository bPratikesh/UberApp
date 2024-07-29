package com.pratikesh.project.uber.UberApp.repositories;

import com.pratikesh.project.uber.UberApp.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
}
