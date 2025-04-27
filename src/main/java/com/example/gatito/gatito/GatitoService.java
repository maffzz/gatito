
package com.example.gatito.gatito;

import com.example.gatito.error.NotFoundException;
import com.example.gatito.gatito.dto.CreateGatitoDTO;
import com.example.gatito.gatito.dto.UpdateGatitoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GatitoService {
    private final GatitoRepository gatitoRepository;

    public List<Gatito> getGatitos() {
        return gatitoRepository.findAll();}

    public String createGatito(CreateGatitoDTO dto) {
        Gatito gatito = new Gatito();
        gatito.setNombre(dto.getNombre());
        gatito.setColor(dto.getColor());
        gatito.setGenero(dto.getGenero());
        gatitoRepository.save(gatito);
        return "gatito creado exitosamente :3";}

    public String updateGatito(Long id, UpdateGatitoDTO dtoActu) {
        Gatito gatito = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("¡! no se encontró al gatito con id " + id));
        gatito.setNombre(dtoActu.getNombre());
        gatito.setColor(dtoActu.getColor());
        gatitoRepository.save(gatito);
        return "gatito actualizado exitosamente :3";}

    public String deleteGatito(Long id) {
        Optional<Gatito> gatito = gatitoRepository.findById(id);
        if (gatito.isPresent()) {
            gatitoRepository.deleteById(id);
            return "gatito eliminado exitosamente :3";}
        else {
            throw new NotFoundException("¡! no se encontró al gatito con id " + id);}}

    public Gatito getGatitoById(Long id) {
        return gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                "¡! no se encontró al gatito con id " + id));}

    public List<Gatito> getGatitoByNombre(String nombre) {
        return gatitoRepository.findByNombre(nombre);}

    public List<Gatito> getGatitoByColor(String color) {
        return gatitoRepository.findByColor(color);}

    public List<Gatito> getGatitoByGenero(String genero) {
        return gatitoRepository.findByGenero(genero);}

    public List<String> getSeries(Long id) {
        Gatito gatito = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("¡! no se encontró al gatito con id " + id));
        return gatito.getSeriesfav();}

    public List<String> getCanciones(Long id) {
        Gatito gatito = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("¡! no se encontró al gatito con id " + id));
        return gatito.getCancionesfav();}

    public String agregarSerie(Long id, String newSerie) {
        Gatito gatito = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("¡! no se encontró al gatito con id " + id));
        gatito.getSeriesfav().add(newSerie);
        gatitoRepository.save(gatito);
        return "serie agregada al gatito con id " + id + " exitosamente ";}

    public String eliminarSerie(Long id, String noSerie) {
        Gatito gatito = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("¡! no se encontró al gatito con id " + id));
        if (!gatito.getSeriesfav().contains(noSerie)) {
            throw new NotFoundException("¡! la serie '" + noSerie + "' no existe en la lista de este gatito");}
        gatito.getSeriesfav().remove(noSerie);
        gatitoRepository.save(gatito);
        return "serie eliminada para el gatito con id " + id + " exitosamente :3";}

    public String agregarCancion(Long id, String newCancion) {
        Gatito gatito = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("¡! no se encontró al gatito con id " + id));
        gatito.getCancionesfav().add(newCancion);
        gatitoRepository.save(gatito);
        return "cancion agregada al gatito con id " + id + " exitosamente :3";}

    public String eliminarCancion(Long id, String noCancion) {
        Gatito gatito = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("¡! no se encontró al gatito con id " + id));
        if (!gatito.getCancionesfav().contains(noCancion)) {
            throw new NotFoundException("¡! la canción '" + noCancion + "' no existe en la lista de este gatito");}
        gatito.getCancionesfav().remove(noCancion);
        gatitoRepository.save(gatito);
        return "cancion eliminada para el gatito con id " + id + " exitosamente :3";}}
