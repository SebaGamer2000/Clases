package com.Clases.Clases.Service;

import com.Clases.Clases.Clases.Clase;
import com.Clases.Clases.DTO.ClaseRequestDTO;
import com.Clases.Clases.DTO.ClaseResponseDTO;
import com.Clases.Clases.Repository.ClaseRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClaseService {
    private final ClaseRepository claseRepository;
    private static final Logger log = LoggerFactory.getLogger(ClaseService.class);

    private ClaseResponseDTO maptoDTO(Clase clase){
        return new ClaseResponseDTO(
                clase.getId(),
                clase.getNombreClase(),
                clase.getDescripcion(),
                clase.getCupos()
        );
    }
    //Para listar todas las clases
    public List<ClaseResponseDTO> findAll(){
        return claseRepository.findAll().stream().map(this::maptoDTO).collect(Collectors.toList());
    }
    //Para encontrar clase por ID
    public Optional<ClaseResponseDTO> findById(Long id){
        return claseRepository.findById(id).map(this::maptoDTO);
    }
    //Para crear y guardar clases
    public ClaseResponseDTO guardar(ClaseRequestDTO dto){
        log.info("Guardando clase...");
        Clase clase = new Clase(
                null,
                dto.getNombreClase(),
                dto.getDescripcion(),
                dto.getCupos()
        );
        log.info("Clase guardada");
        return maptoDTO(claseRepository.save(clase));
    }
    //Para actualizar clase usando su ID
    public Optional<ClaseResponseDTO> actualizar(Long id, ClaseRequestDTO dto){
        log.info("Actualizando clase...");
        return claseRepository.findById(id).map(existente ->{
            existente.setNombreClase(dto.getNombreClase());
            existente.setDescripcion(dto.getDescripcion());
            existente.setCupos(dto.getCupos());
            log.info("Clase actualizada");
            return maptoDTO(claseRepository.save(existente));
        });
    }
    //Para eliminar clase usando su ID
    public void eliminar(Long id){claseRepository.deleteById(id);}{
        log.info("Clase eliminada");
    }
}
