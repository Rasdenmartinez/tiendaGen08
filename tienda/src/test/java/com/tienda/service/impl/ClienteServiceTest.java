package com.tienda.service.impl;


import com.tienda.entity.Clientes;
import com.tienda.repository.ClienteRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class ClienteServiceTest {
    @MockBean
    ClienteRepo repo;
    @Autowired
    ClienteService service;

    @BeforeEach
    void beforeAll(){
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
    void saveServiceTest() {
        Clientes clientes = Clientes.builder()
                .id(4)
                .nombre("Diego")
                .apellido("Guevara")
                .direccion("Centro")
                .correoElectronico("diegogmail.com")
                .telefno("23604995995")
                .build();
        when(repo.save(clientes)).thenReturn(clientes);
        Clientes cli =service.create(clientes);
        assertNotNull(cli);

        assertEquals(4,cli.getId());
    }

    @Test
    void findByIdServiceTest() {
        Clientes clientes = Clientes.builder()
                .id(4)
                .nombre("Diego")
                .apellido("Guevara")
                .direccion("Centro")
                .correoElectronico("diegogmail.com")
                .telefno("23604995995")
                .build();
        when(repo.findById(4)).thenReturn(Optional.ofNullable(clientes));
        Clientes cli =service.findById(4);
        assertEquals(4,cli.getId());
    }

    @Test
    void deleteServiceTest() {
        Clientes clientes = Clientes.builder()
                .id(4)
                .nombre("Diego")
                .apellido("Guevara")
                .direccion("Centro")
                .correoElectronico("diegogmail.com")
                .telefno("23604995995")
                .build();
        doNothing().when(repo).deleteById(4);
        service.delete(4);
        verify(repo,times(1)).deleteById(4);
    }
}