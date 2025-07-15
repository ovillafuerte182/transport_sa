package com.example.transport.application.service;

import com.example.transport.domain.model.Vehicle;
import com.example.transport.domain.repository.PedidoRepository;
import com.example.transport.domain.repository.VehicleRepository;
import com.example.transport.application.dto.PedidoRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PedidoServiceTest {

    @Test
    void crearPedidoSuccess() {
        VehicleRepository vehicleRepo = Mockito.mock(VehicleRepository.class);
        PedidoRepository pedidoRepo = Mockito.mock(PedidoRepository.class);

        Vehicle v = new Vehicle("ABC-123", BigDecimal.valueOf(1000));
        v.setId(1L);

        when(vehicleRepo.findById(1L)).thenReturn(Optional.of(v));
        when(pedidoRepo.save(any())).thenAnswer(i -> i.getArguments()[0]);

        PedidoService service = new PedidoService(vehicleRepo, pedidoRepo);
        var dto = service.crear(new PedidoRequest(1L, BigDecimal.valueOf(100)));

        assertEquals(1L, dto.vehicleId());
        assertEquals("PENDIENTE", dto.estado());
    }
}
