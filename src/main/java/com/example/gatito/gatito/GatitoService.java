
package com.example.gatito.gatito;

import com.example.gatito.gatito.dto.CreateGatitoDTO;
import com.example.gatito.gatito.dto.UpdateGatitoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return "gatito creado exitosamente";}

    public String updateGatito(Long Id, UpdateGatitoDTO dtoActu) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "no se encontró al gatito con el ID " + Id));
        gatito.setNombre(dtoActu.getNombre());
        gatito.setColor(dtoActu.getColor());
        gatitoRepository.save(gatito);
        return "gatito actualizado exitosamente";}

    public String deleteGatito(Long id) {
        Optional<Gatito> gatito = gatitoRepository.findById(id);
        if (gatito.isPresent()) {
            gatitoRepository.deleteById(id);
            return "gatito eliminado exitosamente";}
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "no se encontró al gatito con el ID " + id);}}

    public Gatito getGatitoById(Long Id) {
        return gatitoRepository.findById(Id).orElseThrow(
                () -> new RuntimeException(
                "no se encontró al gatito con el ID " + Id));}

    public List<Gatito> getGatitoByNombre(String nombre) {
        return gatitoRepository.findByNombre(nombre);}

    public List<Gatito> getGatitoByColor(String color) {
        return gatitoRepository.findByColor(color);}

    public List<Gatito> getGatitoByGenero(String genero) {
        return gatitoRepository.findByGenero(genero);}

    public List<String> getSeries(Long Id) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "no se encontró al gatito con el ID " + Id));
        return gatito.getSeriesfav();}

    public List<String> getCanciones(Long Id) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "no se encontró al gatito con el ID " + Id));
        return gatito.getCancionesfav();}

    public String agregarSerie(Long Id, String newSerie) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "no se encontró al gatito con el ID " + Id));
        gatito.getSeriesfav().add(newSerie);
        gatitoRepository.save(gatito);
        return "serie agregada al gatito con ID " + Id + " exitosamente";}

    public String eliminarSerie(Long Id, String noSerie) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "no se encontró al gatito con el ID " + Id));
        gatito.getSeriesfav().remove(noSerie);
        gatitoRepository.save(gatito);
        return "serie eliminada para el gatito con ID " + Id + " exitosamente";}

    public String agregarCancion(Long Id, String newCancion) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "no se encontró al gatito con el ID " + Id));
        gatito.getCancionesfav().add(newCancion);
        gatitoRepository.save(gatito);
        return "cancion agregada al gatito con ID " + Id + " exitosamente";}

    public String eliminarCancion(Long Id, String noCancion) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "no se encontró al gatito con el ID " + Id));
        gatito.getCancionesfav().remove(noCancion);
        gatitoRepository.save(gatito);
        return "cancion eliminada para el gatito con ID " + Id + " exitosamente";}}
