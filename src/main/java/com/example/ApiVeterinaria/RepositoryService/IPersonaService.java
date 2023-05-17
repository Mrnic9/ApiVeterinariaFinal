package com.example.ApiVeterinaria.RepositoryService;

import com.example.ApiVeterinaria.Modelos.Persona;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;


@SpringBootApplication(scanBasePackages = {"com.example.ApiVeterinaria"})
public interface IPersonaService {
    public List<Persona> listar();

    public Optional<Persona> listarId(Long id);

    public int save (Persona p);

    public void delete (Long id);
}
