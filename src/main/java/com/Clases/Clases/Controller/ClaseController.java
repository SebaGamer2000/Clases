package com.Clases.Clases.Controller;

import com.Clases.Clases.DTO.ClaseRequestDTO;
import com.Clases.Clases.DTO.ClaseResponseDTO;
import com.Clases.Clases.Service.ClaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
@RequiredArgsConstructor
public class ClaseController {
    private final ClaseService claseService;
    //GetMapping para listar todas las clases
    @GetMapping
    public ResponseEntity<List<ClaseResponseDTO>> findAll(){
        return ResponseEntity.ok(claseService.findAll());
    }
    //GetMapping para encontrar clase por ID
    @GetMapping("{id}")
    public ResponseEntity<ClaseResponseDTO> findById(@PathVariable Long id){
        return claseService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    //PostMapping para crear y guardar clases
    @PostMapping
    public ResponseEntity<ClaseResponseDTO> crear(
            @Valid @RequestBody ClaseRequestDTO dto
            ){
        return ResponseEntity.status(201).body(claseService.guardar(dto));
    }
    //PutMapping para actualizar clases usando su ID
    @PutMapping("{id}")
    public ResponseEntity<ClaseResponseDTO> actualizar(
            @PathVariable Long id, @Valid @RequestBody ClaseRequestDTO dto
    ){
        return claseService.actualizar(id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    //DeleteMapping para eliminar una clase usando su ID
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if (claseService.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        claseService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
