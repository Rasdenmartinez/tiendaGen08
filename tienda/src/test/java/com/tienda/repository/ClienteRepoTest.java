package com.tienda.repository;


import com.tienda.entity.Clientes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ClienteRepoTest {
    @Autowired
    ClienteRepo repo;

    @BeforeEach
    void setUp() {
        Clientes clientes = Clientes.builder()
                .id(4)
                .nombre("Diego")
                .apellido("Guevara")
                .direccion("Centro")
                .correoElectronico("diegogmail.com")
                .telefno("23604995995")
                .build();
        repo.save(clientes);
    }

    @Test
    @DisplayName("Metodo All Array")
    void findAllTest() {
        List<Clientes> dat =repo.findAll();
        System.out.println(dat);
        assertEquals(1,dat.size());

    }

    @Test
    @DisplayName("Metodo por Id")
    void findById() {
        Clientes clientes = repo.findById(1).orElseThrow();
        assertEquals(1,clientes.getId());
    }

    @Test
    @DisplayName("Metodo Eliminar")
    void delete() {
        repo.deleteById(1);
        List<Clientes> clientes = repo.findAll();
        System.out.println(clientes);
        assertEquals(0,clientes.size());
    }
}