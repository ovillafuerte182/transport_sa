package com.example.transport.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^[A-Z]{3}-\d{3}$")
    private String plate;

    @Positive
    @Column(precision = 10, scale = 2)
    private BigDecimal capacityKg;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    private boolean active = true;

    public Vehicle() {}

    public Vehicle(String plate, BigDecimal capacityKg) {
        this.plate = plate;
        this.capacityKg = capacityKg;
    }

    // getters and setters
    public Long getId() { return id; }
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    public BigDecimal getCapacityKg() { return capacityKg; }
    public void setCapacityKg(BigDecimal capacityKg) { this.capacityKg = capacityKg; }
    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
