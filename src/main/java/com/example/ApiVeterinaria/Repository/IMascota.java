package com.example.ApiVeterinaria.Repository;

import com.example.ApiVeterinaria.Modelos.Mascota;
import org.springframework.data.repository.CrudRepository;

public interface IMascota extends CrudRepository<Mascota,Integer> {
}
