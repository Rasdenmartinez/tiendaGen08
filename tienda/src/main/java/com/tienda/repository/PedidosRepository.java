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
    /*
    @Query("SELECT clienteId FROM Pedidos WHERE clienteId =:clienteId")
    List<Pedidos> findByClienteIdContaining(@Param("clienteId") Integer clienteId);
*/


    List<Pedidos> findByClienteId(Integer clienteId);

    List<Pedidos> findByFechaPedido(LocalDate  fecha);



/*
    @Query(value = "select pd.id, p.nombre, p.direccion, p.edad, d.precio, d.m2,p.id_departamento  from  departamento d\n" +
            "join persona_departamento pd on d.id = pd.departamento_id\n" +
            "join persona p on p.id = pd.persona_id_departamento",nativeQuery = true)
    public List<Object[]> joinTables();
*/


    //public List<Pedidos> findPedidosByFechaPedidoContaining(LocalDate fecha);


    //public List<Pedidos> findByFechaPedidoContaining(String fecha);


}