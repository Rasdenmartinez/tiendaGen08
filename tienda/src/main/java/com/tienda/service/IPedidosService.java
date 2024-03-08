package com.tienda.service;

import com.tienda.entity.Pedidos;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IPedidosService {

    public List<Pedidos> read();

    public void delete(Long id);

    public Pedidos create(Pedidos pedidos);

    public Pedidos update(Pedidos pedidos);

    public List<Pedidos> findByClienteId(Integer clienteId);

    public List<Pedidos> findByFechaPedido(LocalDate fecha);


}