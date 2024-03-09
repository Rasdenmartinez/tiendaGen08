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
    Pedidos pedido;

    @BeforeEach
    void beforeAll() {
        pedido = Pedidos.builder()
                .id(1)
                .fechaPedido(LocalDate.parse("2024-03-02"))
                .clienteId(2)
                .totalPedido(2000.00F)
                .build();
    }

    @Test
    void findAllServiceTest() {
        when(pedidosRepository.findAll()).thenReturn(Arrays.asList(pedido, pedido, pedido));
        List<Pedidos> result = pedidosService.read();

        assertEquals(3, result.size());
        verify(pedidosRepository, times(1)).findAll();
    }

    @Test
    void saveServiceTest() {
        when(pedidosRepository.save(pedido)).thenReturn(pedido);
        Pedidos data = pedidosService.create(pedido);
        //assertNotNull(data);
        //assertEquals(1, data.getId());
        verify(pedidosRepository, times(1)).save(pedido);
        assertEquals(pedido, data);
    }
    @Test
    void updateServiceTest() {
        when(pedidosRepository.save(pedido)).thenReturn(pedido);
        Pedidos data = pedidosService.update(pedido);
        verify(pedidosRepository, times(1)).save(pedido);
        assertEquals(pedido, data);
    }

    @Test
    void deleteServiceTest() {
        doNothing().when(pedidosRepository).deleteById(1L);
        pedidosService.delete(1L);
        verify(pedidosRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindByClienteId() {
        when(pedidosRepository.findByClienteId(2)).thenReturn(Arrays.asList(pedido, pedido));
        List<Pedidos> result = pedidosService.findByClienteId(2);

        assertEquals(2, result.size());
        verify(pedidosRepository, times(1)).findByClienteId(2);
    }

    @Test
    void testFindByFechaPedido() {
        when(pedidosRepository.findByFechaPedido(LocalDate.parse("2024-03-02"))).thenReturn(Arrays.asList(pedido, pedido));
        List<Pedidos> result = pedidosService.findByFechaPedido(LocalDate.parse("2024-03-02"));
add
        assertEquals(2, result.size());
        verify(pedidosRepository, times(1)).findByFechaPedido(LocalDate.parse("2024-03-02"));
    }

}














