package com.Clases.Clases.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaseRequestDTO {
    @NotBlank(message = "El nombre de la clase no puede estar vacio")
    private String nombreClase;

    @NotBlank(message = "La descripcion de la clase no puede estar vacia")
    private String descripcion;

    @NotNull(message = "El cupo no puede estar nulo")
    @Positive(message = "El cupo debe ser mayor a cero")
    private Integer cupos;
}
