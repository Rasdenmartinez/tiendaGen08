package com.tienda.service.impl;

import com.tienda.entity.Pedidos;
import com.tienda.repository.PedidosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PedidosServiceTest {
    @MockBean
    PedidosRepository pedidosRepository;
    @Autowired
    PedidosService pedidosService;

    @BeforeEach
    void beforeAll() {
        Pedidos pedido = Pedidos.builder()
                .id(1)
                .fechaPedido(LocalDate.parse("2024-03-02"))
                .clienteId(2)
                .totalPedido(2000.00F)
                .build();
    }

    @Test
    void saveserviceTest() {
        Pedidos pedido2 = Pedidos.builder()
                .id(1)
                .fechaPedido(LocalDate.parse("2024-03-02"))
                .clienteId(2)
                .totalPedido(2000.00F)
                .build();
        when(pedidosRepository.save(pedido2)).thenReturn(pedido2);
        Pedidos data =pedidosService.create(pedido2);
        assertNotNull(data);
        assertEquals(1, data.getId());
    }

    @Test
    void deleteServiceTest() {
        Pedidos pedido2 = Pedidos.builder()
                .id(1)
                .fechaPedido(LocalDate.parse("2024-03-02"))
                .clienteId(2)
                .totalPedido(2000.00F)
                .build();
        doNothing().when(pedidosRepository).deleteById(1L);
        pedidosService.delete(1L);
        verify(pedidosRepository,times(1)).deleteById(1L);
    }

}














