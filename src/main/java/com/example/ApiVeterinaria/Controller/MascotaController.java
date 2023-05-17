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
    @GetMapping("/listarcitas")
    public String listarcitas(Model model){
        List<Mascota> mascotas= service.listar();
        model.addAttribute("mascotas", mascotas);
        return "ListaCitas";
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
    @GetMapping("/newcitas")
    public String agregarcitas( Model model){
        model.addAttribute("mascota", new Mascota());
        return "citas";
    }
    @GetMapping("/newcitapelu")
    public String agregarcitaspelu( Model model){
        model.addAttribute("mascota", new Mascota());
        return "PeluqueriaCan";
    }

    @GetMapping("/newcitamed")
    public String agregarcitamed( Model model){
        model.addAttribute("mascota", new Mascota());
        return "CitaMedicaCan";
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
    @PostMapping("/savecitas")
    public String savecitas(@Validated Mascota M){
        service.save(M);
        return "redirect:/listarcitas";
    }

    @GetMapping("/editarmas/{id}")
    public String editar(@PathVariable int id,  Model model){
        Optional<Mascota> mascota = service.listarId(id);
        model.addAttribute("mascota", mascota);
        return "consulta";
    }
    @GetMapping("/editarcitaspelu/{id}")
    public String editarcitaspelu(@PathVariable int id,  Model model){
        Optional<Mascota> mascota = service.listarId(id);
        model.addAttribute("mascota", mascota);
        return "PeluqueriaCan";
    }

    @GetMapping("/eliminarmas/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/listarmas";
    }
    @GetMapping("/eliminarcitas/{id}")
    public String deletecitaspelu(@PathVariable int id){
        service.delete(id);
        return "redirect:/listarcitas";
    }
}
