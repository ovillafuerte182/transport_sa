package com.example.transport.infrastructure.web;

import com.example.transport.application.dto.*;
import com.example.transport.application.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoDto> crear(@Validated @RequestBody PedidoRequest request) {
        PedidoDto dto = pedidoService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
