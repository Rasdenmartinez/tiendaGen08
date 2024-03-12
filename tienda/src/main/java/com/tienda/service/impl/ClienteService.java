package com.tienda.service.impl;

import com.tienda.entity.Clientes;
import com.tienda.repository.ClienteRepo;
import com.tienda.service.IClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService implements IClienteService {
    private ClienteRepo clienteRepo;
    @Override
    public List<Clientes> read() {
        return clienteRepo.findAll();
    }

    @Override
    public void delete(int id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Clientes create(Clientes cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public Clientes update(Clientes cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public Clientes findById(int id) {
        return clienteRepo.findById(id).orElseThrow(()->new RuntimeException("Ninguna persona econtrada "+id));
    }
}
