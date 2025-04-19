
package com.example.gatito.gatito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gatito")
public class GatitoController {
    @Autowired
    GatitoService gatitoService;
    public GatitoController(GatitoService gatitoService) {
        this.gatitoService = gatitoService;}
    @GetMapping("/todos")
    public List<Gatito> getGatitos() {
        return gatitoService.getGatitos();}
    @PostMapping("/crear")
    public String createGatito(@RequestBody Gatito gatito) {
        return gatitoService.createGatito(gatito);}
    @PatchMapping("/actualizar/{Id}")
    public String updateGatito(@PathVariable Long Id, @RequestBody Gatito gatitoActu) {
        return gatitoService.updateGatito(Id, gatitoActu);}
    @DeleteMapping("/eliminar/{Id}")
    public String deleteGatito(@PathVariable Long Id) {
        return gatitoService.deleteGatito(Id);}
    @GetMapping("/{Id}")
    public Gatito getGatitoById(@PathVariable Long Id) {
        return gatitoService.getGatitoById(Id);}
    @GetMapping("/nombre/{nombre}")
    public List<Gatito> getGatitoByNombre(@PathVariable String nombre) {
        return gatitoService.getGatitoByNombre(nombre);}
    @GetMapping("/color/{color}")
    public List<Gatito> getGatitoByColor(@PathVariable String color) {
        return gatitoService.getGatitoByColor(color);}
    @GetMapping("/genero/{genero}")
    public List<Gatito> getGatitoByGenero(@PathVariable String genero) {
        return gatitoService.getGatitoByGenero(genero);}
    @GetMapping("/nacimiento/{nacimiento}")
    public List<Gatito> getGatitoByNacimiento(@PathVariable Integer nacimiento) {
        return gatitoService.getGatitoByNacimiento(nacimiento);}
    @GetMapping("/series/{Id}")
    public List<String> getSeries(@PathVariable Long Id) {
        return gatitoService.getSeries(Id);}
    @GetMapping("/canciones/{Id}")
    public List<String> getCanciones(@PathVariable Long Id) {
        return gatitoService.getCanciones(Id);}
    @PostMapping("/agregarserie/{Id}")
    public String agregarSerie(@PathVariable Long Id, @RequestBody String newSerie) {
        return gatitoService.agregarSerie(Id, newSerie);}
    @PostMapping("/eliminarserie/{Id}")
    public String eliminarSerie(@PathVariable Long Id, @RequestBody String noSerie) {
        return gatitoService.eliminarSerie(Id, noSerie);}
    @PostMapping("/agregarcancion/{Id}")
    public String agregarCancion(@PathVariable Long Id, @RequestBody String newCancion) {
        return gatitoService.agregarCancion(Id, newCancion);}
    @PostMapping("/eliminarcancion/{Id}")
    public String eliminarCancion(@PathVariable Long Id, @RequestBody String noCancion) {
        return gatitoService.eliminarCancion(Id, noCancion);}}
