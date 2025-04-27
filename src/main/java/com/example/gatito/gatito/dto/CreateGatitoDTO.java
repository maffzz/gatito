
package com.example.gatito.gatito.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateGatitoDTO {
    @NotNull(message = "el nombre del gatito no debe ser nulo")
    public String nombre;
    @NotNull(message = "el color del gatito no debe ser nulo")
    public String color;
    @NotNull(message = "el género del gatito no debe ser nulo")
    @Size(min = 1, max = 1, message = "el género del gatito debe ser 'F' o 'M'")
    public String genero;}
