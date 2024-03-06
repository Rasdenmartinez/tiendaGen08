package com.tienda.repository;

import com.tienda.entity.Pedidos;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PedidosRepositoryTest {
    @Autowired
    PedidosRepository pedidosRepository;
    @BeforeEach
     void BeforeEach() {
        Pedidos pedido = Pedidos.builder()
                .id(1)
                .fechaPedido(LocalDate.parse("2024-03-02"))
                .clienteId(2)
                .totalPedido(2000.00F)
                .build();
        pedidosRepository.save(pedido);

    }
    @Test
    void findById() {
        Pedidos pedido1 = pedidosRepository.findById(1L).orElseThrow();//si es nullo manda un error
        assertNotNull(pedido1);
        assertEquals(1,pedido1.getId());
    }

}