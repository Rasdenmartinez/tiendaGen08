package com.tienda.controller;

import com.tienda.entity.Empleado;
import com.tienda.service.IEmpleadoService;
import com.tienda.service.impl.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/empleados")
@RestController
public class EmpleadoController {
    @Autowired
    IEmpleadoService empleadoService;
    //CRUD, create, read, update y delete
    @PostMapping("/create")
    public Empleado create(@RequestBody Empleado empleado){
        return empleadoService.create(empleado);
    }
    @GetMapping("/getAll")
    public List<Empleado> getAll(){
        return empleadoService.getAll();
    }
    @GetMapping("/getById/{id}")
    public Empleado getById(Long id){
        return empleadoService.getById(id);
    }
    @PutMapping("/update")
    public Empleado update(@RequestBody Empleado empleado){
        return empleadoService.update(empleado);
    }
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable Long id){
        empleadoService.deleteById(id);
    }

}
