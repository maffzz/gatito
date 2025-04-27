
package com.example.gatito.gatito;

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

    public String createGatito(Gatito gatito) {
        gatitoRepository.save(gatito);
        return "gatito creado exitosamente";}

    public String updateGatito(Long Id, Gatito gatitoActu) {
        Gatito gatitoEx = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "gatito no encontrado con ID " + Id));
        gatitoEx.setNombre(gatitoActu.getNombre());
        gatitoEx.setColor(gatitoActu.getColor());
        gatitoEx.setGenero(gatitoActu.getGenero());
        gatitoEx.setNacimiento(gatitoEx.getNacimiento());
        gatitoRepository.save(gatitoEx);
        return "gatito actualizado exitosamente";}

    public String deleteGatito(Long id) {
        Optional<Gatito> gatito = gatitoRepository.findById(id);
        if (gatito.isPresent()) {
            gatitoRepository.deleteById(id);
            return "gatito eliminado exitosamente";}
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "gatito no encontrado con ID " + id);}}

    public Gatito getGatitoById(Long Id) {
        return gatitoRepository.findById(Id).orElseThrow(
                () -> new RuntimeException(
                "no se encontró ningún gatito con el ID " + Id));}

    public List<Gatito> getGatitoByNombre(String nombre) {
        return gatitoRepository.findByNombre(nombre);}

    public List<Gatito> getGatitoByColor(String color) {
        return gatitoRepository.findByColor(color);}

    public List<Gatito> getGatitoByGenero(String genero) {
        return gatitoRepository.findByGenero(genero);}

    public List<Gatito> getGatitoByNacimiento(Integer nacimiento) {
        return gatitoRepository.findByNacimiento(nacimiento);}

    public List<String> getSeries(Long Id) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "gatito no encontrado con ID " + Id));
        return gatito.getSeriesfav();}

    public List<String> getCanciones(Long Id) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "gatito no encontrado con ID " + Id));
        return gatito.getCancionesfav();}

    public String agregarSerie(Long Id, String newSerie) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "gatito no encontrado con ID " + Id));
        gatito.getSeriesfav().add(newSerie);
        gatitoRepository.save(gatito);
        return "serie agregada a gatito con ID " + Id + " exitosamente";}

    public String eliminarSerie(Long Id, String noSerie) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "gatito no encontrado con ID " + Id));
        gatito.getSeriesfav().remove(noSerie);
        gatitoRepository.save(gatito);
        return "serie eliminada a gatito con ID " + Id + " exitosamente";}

    public String agregarCancion(Long Id, String newCancion) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "gatito no encontrado con ID " + Id));
        gatito.getCancionesfav().add(newCancion);
        gatitoRepository.save(gatito);
        return "cancion agregada a gatito con ID " + Id + " exitosamente";}

    public String eliminarCancion(Long Id, String noCancion) {
        Gatito gatito = gatitoRepository.findById(Id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "gatito no encontrado con ID " + Id));
        gatito.getCancionesfav().remove(noCancion);
        gatitoRepository.save(gatito);
        return "cancion eliminada a gatito con ID " + Id + " exitosamente";}}
