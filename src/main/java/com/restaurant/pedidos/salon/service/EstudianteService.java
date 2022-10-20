package com.restaurant.pedidos.salon.service;

import java.util.List;

import com.restaurant.pedidos.salon.entity.Estudiante;

public interface EstudianteService {
    
    public List<Estudiante> listarTodosLosEstudiantes();

    public Estudiante guardarEstudiante(Estudiante estudiante);

    public Estudiante obtenerEstudiantePorId(Long id);

    public Estudiante actualizarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Long id);
}
