package com.tienda.service.impl;

import com.tienda.entity.Pedidos;
import com.tienda.repository.PedidosRepository;
import com.tienda.service.IPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidosService implements IPedidosService {

    @Autowired
    PedidosRepository pedidosRepository;

    @Override
    public List<Pedidos> read() {
        return pedidosRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        pedidosRepository.deleteById(id);
    }

    @Override
    public Pedidos create(Pedidos pedidos) {
        return pedidosRepository.save(pedidos);
    }

    @Override
    public Pedidos update(Pedidos pedidos) {
        return pedidosRepository.save(pedidos);
    }

    @Override
    public List<Pedidos> findByClienteId(Integer clienteId) {
        return pedidosRepository.findByClienteId(clienteId);
    }

    @Override
    public List<Pedidos> findByFechaPedido(LocalDate fecha) {
        return pedidosRepository.findByFechaPedido(fecha);
    }

}
