
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
    public ResponseEntity<String> updateGatito(@PathVariable Long Id, @Valid @RequestBody UpdateGatitoDTO dtoActu) {
        return ResponseEntity.ok(gatitoService.updateGatito(Id, dtoActu));}

    @DeleteMapping("/eliminar/{Id}")
    public ResponseEntity<String> deleteGatito(@PathVariable Long Id) {
        return ResponseEntity.ok(gatitoService.deleteGatito(Id));}

    @GetMapping("/id/{Id}")
    public ResponseEntity<Gatito> getGatitoById(@PathVariable Long Id) {
        return ResponseEntity.ok(gatitoService.getGatitoById(Id));}

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Gatito>> getGatitoByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(gatitoService.getGatitoByNombre(nombre));}

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Gatito>> getGatitoByColor(@PathVariable String color) {
        return ResponseEntity.ok(gatitoService.getGatitoByColor(color));}

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Gatito>> getGatitoByGenero(@PathVariable String genero) {
        return ResponseEntity.ok(gatitoService.getGatitoByGenero(genero));}

    @GetMapping("/series/{Id}")
    public ResponseEntity<List<String>> getSeries(@PathVariable Long Id) {
        return ResponseEntity.ok(gatitoService.getSeries(Id));}

    @GetMapping("/canciones/{Id}")
    public ResponseEntity<List<String>> getCanciones(@PathVariable Long Id) {
        return ResponseEntity.ok(gatitoService.getCanciones(Id));}

    @PostMapping("/agregarserie/{Id}")
    public ResponseEntity<String> agregarSerie(@PathVariable Long Id, @RequestBody String newSerie) {
        return ResponseEntity.ok(gatitoService.agregarSerie(Id, newSerie));}

    @PostMapping("/eliminarserie/{Id}")
    public ResponseEntity<String> eliminarSerie(@PathVariable Long Id, @RequestBody String noSerie) {
        return ResponseEntity.ok(gatitoService.eliminarSerie(Id, noSerie));}

    @PostMapping("/agregarcancion/{Id}")
    public ResponseEntity<String> agregarCancion(@PathVariable Long Id, @RequestBody String newCancion) {
        return ResponseEntity.ok(gatitoService.agregarCancion(Id, newCancion));}

    @PostMapping("/eliminarcancion/{Id}")
    public ResponseEntity<String> eliminarCancion(@PathVariable Long Id, @RequestBody String noCancion) {
        return ResponseEntity.ok(gatitoService.eliminarCancion(Id, noCancion));}}
