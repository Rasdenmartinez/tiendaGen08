package com.tienda.controller;


import com.tienda.entity.Clientes;
import com.tienda.service.impl.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1")
@RestController
@AllArgsConstructor
public class ClienteController {
    private ClienteService clienteService;

    @GetMapping("/cliente")
    public List<Clientes> read(){
        return clienteService.read();
    }
    @DeleteMapping("/cliente/{id}")
    public void delete(@PathVariable int id){
        clienteService.delete(id);
    }
    @PostMapping("/cliente")
    public Clientes create(@RequestBody Clientes cliente){
        return clienteService.create(cliente);
    }
    @PutMapping("/cliente")
    public Clientes update(@RequestBody Clientes cliente){
        return clienteService.update(cliente);
    }
    @GetMapping("/clienteId/{id}")
    public Clientes findById(@PathVariable int id){
        return clienteService.findById(id);
    }
}
