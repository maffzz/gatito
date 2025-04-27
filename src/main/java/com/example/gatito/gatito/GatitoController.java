
package com.example.gatito.gatito;

import com.example.gatito.gatito.dto.CreateGatitoDTO;
import com.example.gatito.gatito.dto.UpdateGatitoDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gatito")
public class GatitoController {
    private final GatitoService gatitoService;

    @GetMapping("/todos")
    public ResponseEntity<List<Gatito>> getGatitos() {
        return ResponseEntity.ok(gatitoService.getGatitos());}

    @PostMapping("/crear")
    public ResponseEntity<String> createGatito(@Valid @RequestBody CreateGatitoDTO dtoNew) {
        return ResponseEntity.ok(gatitoService.createGatito(dtoNew));}

    @PatchMapping("/actualizar/{Id}")
    public ResponseEntity<String> updateGatito(@Valid @PathVariable Long Id, @Valid @RequestBody UpdateGatitoDTO dtoActu) {
        return ResponseEntity.ok(gatitoService.updateGatito(Id, dtoActu));}

    @DeleteMapping("/eliminar/{Id}")
    public ResponseEntity<String> deleteGatito(@Valid @PathVariable Long Id) {
        return ResponseEntity.ok(gatitoService.deleteGatito(Id));}

    @GetMapping("/id/{Id}")
    public ResponseEntity<Gatito> getGatitoById(@Valid @PathVariable Long Id) {
        return ResponseEntity.ok(gatitoService.getGatitoById(Id));}

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Gatito>> getGatitoByNombre(@Valid @PathVariable String nombre) {
        return ResponseEntity.ok(gatitoService.getGatitoByNombre(nombre));}

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Gatito>> getGatitoByColor(@Valid @PathVariable String color) {
        return ResponseEntity.ok(gatitoService.getGatitoByColor(color));}

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Gatito>> getGatitoByGenero(@Valid @PathVariable String genero) {
        return ResponseEntity.ok(gatitoService.getGatitoByGenero(genero));}

    @GetMapping("/series/{Id}")
    public ResponseEntity<List<String>> getSeries(@Valid @PathVariable Long Id) {
        return ResponseEntity.ok(gatitoService.getSeries(Id));}

    @GetMapping("/canciones/{Id}")
    public ResponseEntity<List<String>> getCanciones(@Valid @PathVariable Long Id) {
        return ResponseEntity.ok(gatitoService.getCanciones(Id));}

    @PostMapping("/agregarserie/{Id}")
    public ResponseEntity<String> agregarSerie(@Valid @PathVariable Long Id, @RequestBody String newSerie) {
        return ResponseEntity.ok(gatitoService.agregarSerie(Id, newSerie));}

    @DeleteMapping("/eliminarserie/{Id}")
    public ResponseEntity<String> eliminarSerie(@Valid @PathVariable Long Id, @RequestBody String noSerie) {
        return ResponseEntity.ok(gatitoService.eliminarSerie(Id, noSerie));}

    @PostMapping("/agregarcancion/{Id}")
    public ResponseEntity<String> agregarCancion(@Valid @PathVariable Long Id, @RequestBody String newCancion) {
        return ResponseEntity.ok(gatitoService.agregarCancion(Id, newCancion));}

    @DeleteMapping("/eliminarcancion/{Id}")
    public ResponseEntity<String> eliminarCancion(@Valid @PathVariable Long Id, @RequestBody String noCancion) {
        return ResponseEntity.ok(gatitoService.eliminarCancion(Id, noCancion));}}
