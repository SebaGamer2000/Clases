package com.Clases.Clases.Service;

import com.Clases.Clases.Clases.Clase;
import com.Clases.Clases.DTO.ClaseRequestDTO;
import com.Clases.Clases.DTO.ClaseResponseDTO;
import com.Clases.Clases.Repository.ClaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClaseService {
    private final ClaseRepository claseRepository;

    private ClaseResponseDTO maptoDTO(Clase clase){
        return new ClaseResponseDTO(
                clase.getId(),
                clase.getNombreClase(),
                clase.getDescripcion(),
                clase.getCupos()
        );
    }
    public List<ClaseResponseDTO> findAll(){
        return claseRepository.findAll().stream().map(this::maptoDTO).collect(Collectors.toList());
    }

    public Optional<ClaseResponseDTO> findById(Long id){
        return claseRepository.findById(id).map(this::maptoDTO);
    }

    public ClaseResponseDTO guardar(ClaseRequestDTO dto){
        Clase clase = new Clase(
                null,
                dto.getNombreClase(),
                dto.getDescripcion(),
                dto.getCupos()
        );
        return maptoDTO(claseRepository.save(clase));
    }

    public Optional<ClaseResponseDTO> actualizar(Long id, ClaseRequestDTO dto){
        return claseRepository.findById(id).map(existente ->{
            existente.setNombreClase(dto.getNombreClase());
            existente.setDescripcion(dto.getDescripcion());
            existente.setCupos(dto.getCupos());
            return maptoDTO(claseRepository.save(existente));
        });
    }
    public void eliminar(Long id){claseRepository.deleteById(id);}
}
