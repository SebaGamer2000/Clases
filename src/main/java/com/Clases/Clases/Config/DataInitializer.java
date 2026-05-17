package com.Clases.Clases.Config;

import com.Clases.Clases.Clases.Clase;
import com.Clases.Clases.Repository.ClaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final ClaseRepository claseRepository;

    @Override
    public void run(String... args){
        if (claseRepository.count() > 0){
            log.info("Datos cargados");
            return;
        }

        log.info("No hay datos guardados, creando datos");

      /*  claseRepository.save(
                new Clase(null, "Yoga", "Clase de yoga", 25)
        );
        claseRepository.save(
                new Clase(null, "CrossFit", "Clase de CrossFit", 30)
        );
        claseRepository.save(
                new Clase(null, "Zumba", "Sesiones de Zumba", 40)
        );*/
    }
}
