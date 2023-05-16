package com.example.ApiVeterinaria.Repository;


import com.example.ApiVeterinaria.Modelos.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersona extends CrudRepository<Persona, Long> {
}