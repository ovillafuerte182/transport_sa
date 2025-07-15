package com.example.transport.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record PedidoRequest(
    @NotNull Long vehicleId,
    @Positive BigDecimal pesoKg
) { }
