package com.restaurant.pedidos.salon.service;

import java.util.List;

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

    
}
