package com.tienda.service;

import com.tienda.entity.Pedidos;

import java.util.List;

public interface IPedidosService {

    public List<Pedidos> read();

    public void delete(Long id);

    public Pedidos create(Pedidos pedidos);

    public Pedidos update(Pedidos pedidos);

}