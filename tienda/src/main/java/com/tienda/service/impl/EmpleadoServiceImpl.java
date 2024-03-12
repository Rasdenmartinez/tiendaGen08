package com.tienda.service.impl;

import com.tienda.entity.Empleado;
import com.tienda.repository.EmpleadoRepository;
import com.tienda.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public Empleado create(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado update(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAll() {
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getById(Long id) {
        return empleadoRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }
}
