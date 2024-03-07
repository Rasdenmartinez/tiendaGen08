package com.tienda.controller;


import com.tienda.entity.Pedidos;
import com.tienda.service.IPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
@RestController

public class PedidosController {
    @Autowired
    IPedidosService pedidosService;

    @GetMapping("/pedidos")
    public List<Pedidos> read(){
        return pedidosService.read();
    }

    @DeleteMapping("/pedidos/{id}")
    public void delete(@PathVariable Long id){
        pedidosService.delete(id);
    }
    @PostMapping("/pedidos")
    public Pedidos create(@RequestBody Pedidos pedidos){
        return pedidosService.create(pedidos);
    }

    @PutMapping("/pedidos")
    public Pedidos update(@RequestBody Pedidos pedidos){
        return pedidosService.update(pedidos);
    }

    @GetMapping("/pedidos/cliente/{id}")
    public List<Pedidos> findByClienteId(@PathVariable Integer id){
        return pedidosService.findByClienteId(id);
    }

    @GetMapping("/pedidos/fecha/{fecha}")
    public List<Pedidos> findByFechaPedido(@PathVariable String fecha){
        return pedidosService.findByFechaPedido(LocalDate.parse(fecha));
    }

    // filtros
/*
    @GetMapping("/pedidos/fecha/{feha}")
    public List<Pedidos> findByFechaPedidoContaining(@PathVariable String fecha){
        return pedidosService.findByFechaPedidoContaining(fecha);
    }

    @GetMapping("/pedidos/cliente/{id}")
    public List<Pedidos> findByClienteIdContaining(@PathVariable Long id){
        return pedidosService.findByClienteIdContaining(id);
    }
*/
}
