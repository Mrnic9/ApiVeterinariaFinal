package com.example.ApiVeterinaria.RepositoryService;


import com.example.ApiVeterinaria.Modelos.Mascota;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"com.example.ApiVeterinaria"})
public interface IMascotaService {
    public List<Mascota> listar();

    public Optional<Mascota> listarId(Long id);

    public int save (Mascota M);

    public void delete (Long id);
}
