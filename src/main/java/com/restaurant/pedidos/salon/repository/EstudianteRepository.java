package com.restaurant.pedidos.salon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.pedidos.salon.entity.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
    
}
