package com.Clases.Clases.Clases;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "Clases")

public class Clase {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreClase;

    @Column(nullable = false)
    private String descripcion;

    @Column
    private Integer cupos;

}
