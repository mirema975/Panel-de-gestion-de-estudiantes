package com.restaurant.pedidos.salon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.pedidos.salon.entity.Estudiante;
import com.restaurant.pedidos.salon.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    @Override
    public List<Estudiante> listarTodosLosEstudiantes() {
        return repository.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        Optional<Estudiante> estudiante = repository.findById(id);
        if(estudiante.isPresent()) 
            return estudiante.get();
        return null;

    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        repository.deleteById(id);
        
    }

    
}
