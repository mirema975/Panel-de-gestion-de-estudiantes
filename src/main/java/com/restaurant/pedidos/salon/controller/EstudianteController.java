package com.restaurant.pedidos.salon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.restaurant.pedidos.salon.entity.Estudiante;
import com.restaurant.pedidos.salon.service.EstudianteService;

@Controller
public class EstudianteController {
    
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping({"/estudiantes", "/"})
    public String listarEstudiantes(Model modelo){
        modelo.addAttribute("estudiantes", estudianteService.listarTodosLosEstudiantes());
        return "estudiantes";
    }

    @GetMapping("/estudiantes/nuevo")
    public String formularioRegistroEstudiante(Model modelo) {
        Estudiante estudiante = new Estudiante();
        modelo.addAttribute("estudiante", estudiante);
        return "crear_estudiante";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante){
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFomularioEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("estudiante", estudianteService.obtenerEstudiantePorId(id));
        return "editar_estudiante";
    }

    @PostMapping("estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo){
        Estudiante estudianteExistente = estudianteService.obtenerEstudiantePorId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());

        estudianteService.actualizarEstudiante(estudianteExistente);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        estudianteService.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}

