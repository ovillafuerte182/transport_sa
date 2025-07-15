package com.example.transport.application.service;

import com.example.transport.domain.model.*;
import com.example.transport.domain.repository.*;
import com.example.transport.application.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    private final VehicleRepository vehicleRepo;
    private final PedidoRepository pedidoRepo;

    public PedidoService(VehicleRepository vehicleRepo, PedidoRepository pedidoRepo) {
        this.vehicleRepo = vehicleRepo;
        this.pedidoRepo = pedidoRepo;
    }

    @Transactional
    public PedidoDto crear(PedidoRequest request) {
        Vehicle vehicle = vehicleRepo.findById(request.vehicleId())
                        .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado"));

        Pedido pedido = new Pedido(request.pesoKg(), vehicle);
        pedidoRepo.save(pedido);

        return new PedidoDto(pedido.getId(), pedido.getPesoKg(),
                             pedido.getEstado().name(), vehicle.getId());
    }
}
