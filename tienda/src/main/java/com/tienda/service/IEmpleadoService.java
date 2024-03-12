package com.tienda.service;

import com.tienda.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public Empleado create(Empleado empleado);
    public Empleado update(Empleado empleado);
    public List<Empleado> getAll();
    public Empleado getById(Long id);
    public void deleteById(Long id);
}
