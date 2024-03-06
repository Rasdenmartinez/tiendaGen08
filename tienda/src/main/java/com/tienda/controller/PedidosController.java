package com.tienda.controller;


import com.tienda.entity.Pedidos;
import com.tienda.service.IPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1")
@RestController

public class PedidosController {
    @Autowired
    IPedidosService pedidosService;
    //CRUD, create, read, update y delete
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

}
