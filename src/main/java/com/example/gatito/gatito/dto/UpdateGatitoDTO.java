
package com.example.gatito.gatito.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateGatitoDTO {
    @NotNull(message = "el nombre del gatito no debe ser nulo")
    @Size(min = 1, max = 100, message = "el nombre del gatito debe tener entre 1 a 100 letras")
    public String nombre;}
