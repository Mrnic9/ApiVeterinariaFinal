package com.example.ApiVeterinaria.Controller;


import com.example.ApiVeterinaria.Modelos.Persona;
import com.example.ApiVeterinaria.RepositoryService.IPersonaService;
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
public class PersonaController {
    @Autowired
    private IPersonaService service;


    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona> personas= service.listar();
        model.addAttribute("personas", personas);
        return "tabla";
    }

    @GetMapping("/new")
    public String agregar( Model model){
        model.addAttribute("persona", new Persona());
        return "form";
    }

    @GetMapping("/inicio")
    public String inicio(){
        return "index";
    }


    @PostMapping("/saveper")
    public String save(@Validated Persona p){
        service.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id,  Model model){
        Optional<Persona> persona = service.listarId(id);
        model.addAttribute("persona", persona);
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }
}
