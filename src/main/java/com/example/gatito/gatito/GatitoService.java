
package com.example.gatito.gatito;

import com.example.gatito.error.ConflictException;
import com.example.gatito.error.NotFoundException;
import com.example.gatito.gatito.dto.CancionGatitoRequest;
import com.example.gatito.gatito.dto.CreateGatitoDTO;
import com.example.gatito.gatito.dto.SerieGatitoRequest;
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

    public String addSerie(Long id, SerieGatitoRequest newSerie) {
        Gatito gatito = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("¡! no se encontró al gatito con id " + id));
        if (gatito.getSeriesfav().contains(newSerie.getSerie())) {
            throw new ConflictException("¡! la serie '" + newSerie.getSerie() + "' ya existe en la lista de este gatito");}
        gatito.getSeriesfav().add(newSerie.getSerie());
        gatitoRepository.save(gatito);
        return "serie agregada al gatito con id " + id + " exitosamente ";}

    public String deleteSerie(Long id, SerieGatitoRequest noSerie) {
        Gatito gatito = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("¡! no se encontró al gatito con id " + id));
        if (!gatito.getSeriesfav().contains(noSerie.getSerie())) {
            throw new NotFoundException("¡! la serie '" + noSerie.getSerie() + "' no existe en la lista de este gatito");}
        gatito.getSeriesfav().remove(noSerie.getSerie());
        gatitoRepository.save(gatito);
        return "serie eliminada para el gatito con id " + id + " exitosamente :3";}

    public String addCancion(Long id, CancionGatitoRequest newCancion) {
        Gatito gatito = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("¡! no se encontró al gatito con id " + id));
        if (gatito.getCancionesfav().contains(newCancion.getCancion())) {
            throw new ConflictException("¡! la canción '" + newCancion.getCancion() + "' ya existe en la lista de este gatito");}
        gatito.getCancionesfav().add(newCancion.getCancion());
        gatitoRepository.save(gatito);
        return "cancion agregada al gatito con id " + id + " exitosamente :3";}

    public String deleteCancion(Long id, CancionGatitoRequest noCancion) {
        Gatito gatito = gatitoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("¡! no se encontró al gatito con id " + id));
        if (!gatito.getCancionesfav().contains(noCancion.getCancion())) {
            throw new NotFoundException("¡! la canción '" + noCancion.getCancion() + "' no existe en la lista de este gatito");}
        gatito.getCancionesfav().remove(noCancion.getCancion());
        gatitoRepository.save(gatito);
        return "cancion eliminada para el gatito con id " + id + " exitosamente :3";}}
