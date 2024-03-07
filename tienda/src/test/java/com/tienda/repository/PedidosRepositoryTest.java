package com.tienda.repository;

import com.tienda.entity.Pedidos;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

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
    void findAll() {
        List<Pedidos> data = pedidosRepository.findAll();//si es nullo manda un error
        System.out.println(data);
        assertEquals(1, data.size());
    }

    @Test
    void findById() {
        Pedidos pedido1 = pedidosRepository.findById(1L).orElseThrow();//si es nullo manda un error
        assertNotNull(pedido1);
        assertEquals(1, pedido1.getId());
    }

    @Test
    void deleted() {
        pedidosRepository.deleteById(1L);
        List<Pedidos> data = pedidosRepository.findAll();
        System.out.println(data);
        assertEquals(0, data.size());
    }

    @Test
    void findByClienteId() {
        List<Pedidos> data = pedidosRepository.findByClienteId(2);//si es nullo manda un error
        System.out.println(data);
        assertEquals(1, data.size());
    }

    @Test
    void findByFechaPedido() {
        List<Pedidos> data = pedidosRepository.findByFechaPedido(LocalDate.parse("2024-03-02"));//si es nullo manda un error
        System.out.println(data);
        assertEquals(1, data.size());
    }

}