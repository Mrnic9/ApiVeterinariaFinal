package com.example.ApiVeterinaria.Controller;

import com.example.ApiVeterinaria.Modelos.Mascota;
import com.example.ApiVeterinaria.RepositoryService.IMascotaService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class MascotaController {
    @Autowired
    private IMascotaService service;


    @GetMapping("/listarmas")
    public String listar(Model model){
        List<Mascota> mascotas= service.listar();
        model.addAttribute("mascotas", mascotas);
        return "tablaMas";
    }

    @GetMapping( "/formmas")
    public String form(Model model){
        List<Mascota> mascotas= service.listar();
        model.addAttribute("mascotas", mascotas);
        return "form";
    }

    @GetMapping("/newmas")
    public String agregar( Model model){
        model.addAttribute("mascota", new Mascota());
        return "consulta";
    }

    @GetMapping("/iniciomas")
    public String inicio(){
        return "index";
    }


    @PostMapping("/savemas")
    public String save(@Validated Mascota M){
        service.save(M);
        return "redirect:/listarmas";
    }

    @GetMapping("/editarmas/{id}")
    public String editar(@PathVariable Long id,  Model model){
        Optional<Mascota> mascota = service.listarId(id);
        model.addAttribute("mascota", mascota);
        return "redirect:/newmas";
    }

    @GetMapping("/eliminarmas/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/listarmas";
    }
}
