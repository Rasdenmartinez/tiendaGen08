package com.tienda.service;


import com.tienda.entity.Clientes;

import java.util.List;

public interface IClienteService {
    public List<Clientes> read();
    public void delete(int id);
    public Clientes create(Clientes cliente);
    public Clientes update(Clientes cliente);
    public Clientes findById(int id);
}
