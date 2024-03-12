package com.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Basic
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Basic
    @Column(name = "puesto")
    private String puesto;
    @Basic
    @Column(name = "salario")
    private BigDecimal salario;
    @Basic
    @Column(name = "fecha_de_contratacion")
    private Date fechaDeContratacion;
}
