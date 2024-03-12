package com.tienda.repository;

import com.tienda.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductosRepository extends  extends JpaRepository<Productos,Integer> {
}
