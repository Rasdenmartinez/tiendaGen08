package com.tienda.repository;


import com.tienda.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos,Long> {

    List<Pedidos> findByClienteId(Integer clienteId);

    List<Pedidos> findByFechaPedido(LocalDate  fecha);

}