package com.example.transport.application.dto;

import java.math.BigDecimal;

public record PedidoDto(
    Long id,
    BigDecimal pesoKg,
    String estado,
    Long vehicleId
) { }
