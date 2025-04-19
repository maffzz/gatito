
package com.example.gatito.gatito;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GatitoRepository extends JpaRepository<Gatito, Long> {
    List<Gatito> findByNombre(String nombre);
    List<Gatito> findByColor(String color);
    List<Gatito> findByGenero(String genero);
    List<Gatito> findByNacimiento(Integer nacimiento);}
