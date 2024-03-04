package com.tienda.service.impl

import com.prueba.entiity.Pedidos;
import com.prueba.repository.PedidosRepository;
import com.prueba.service.IPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
