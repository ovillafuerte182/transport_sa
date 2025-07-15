package com.example.transport.domain.repository;

import com.example.transport.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    long countByDriverIdAndActiveTrue(Long driverId);
}
