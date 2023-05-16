package com.example.ApiVeterinaria.Service;


import com.example.ApiVeterinaria.Modelos.Mascota;
import com.example.ApiVeterinaria.Repository.IMascota;
import com.example.ApiVeterinaria.RepositoryService.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService implements IMascotaService {
    @Autowired
    private IMascota data;


    @Override
    public List<Mascota> listar(){return (List<Mascota>) data.findAll();}

    @Override
    public Optional<Mascota> listarId(Long id){
        return data.findById(id);
    }

    @Override
    public int save (Mascota M){
        int res=0;
        Mascota mascota = data.save(M);
        if (!mascota.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(Long id){data.deleteById(id);}
}
