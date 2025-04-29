
package com.example.gatito.gatito.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SerieGatitoRequest {
    @NotNull(message = "¡! no olvides ingresar la serie")
    private String serie;}
