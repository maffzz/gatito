
package com.example.gatito.gatito.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateGatitoDTO {
    @NotNull(message = "el nombre del gatito no debe ser nulo")
    public String nombre;}
