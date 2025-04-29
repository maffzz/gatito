
package com.example.gatito.gatito.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CancionGatitoRequest {
    @NotNull(message = "¡! no olvides ingresar la canción")
    private String cancion;}
