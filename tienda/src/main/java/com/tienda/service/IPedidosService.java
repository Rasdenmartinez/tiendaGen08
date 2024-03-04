package com.tienda.service;

import com.prueba.entiity.Pedidos;

import java.util.List;

public interface IPedidosService {

    public List<Pedidos> read();

    public void delete(Long id);

    public Pedidos create(Pedidos pedidos);

    public Pedidos update(Pedidos pedidos);

}