package com.example.transport.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    @Column(precision = 10, scale = 2)
    private BigDecimal pesoKg;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado = EstadoPedido.PENDIENTE;

    public Pedido() {}

    public Pedido(BigDecimal pesoKg, Vehicle vehicle) {
        this.pesoKg = pesoKg;
        this.vehicle = vehicle;
    }

    // getters and setters
    public Long getId() { return id; }
    public BigDecimal getPesoKg() { return pesoKg; }
    public void setPesoKg(BigDecimal pesoKg) { this.pesoKg = pesoKg; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public EstadoPedido getEstado() { return estado; }
    public void setEstado(EstadoPedido estado) { this.estado = estado; }
}
