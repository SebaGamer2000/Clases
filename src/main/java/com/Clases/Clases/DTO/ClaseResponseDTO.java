package com.Clases.Clases.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClaseResponseDTO {
    private Long id;
    private String nombreClase;
    private String descripcion;
    private Integer cupos;
}
