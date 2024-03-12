package com.tienda.entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String nombre;
    private  String descripcion;
    private BigDecimal precio;
    private String categoria;
    private Proveedor proveedor;
    private Integer Stock;


}
