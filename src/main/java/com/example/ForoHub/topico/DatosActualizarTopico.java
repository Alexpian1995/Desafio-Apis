package com.example.ForoHub.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        String status,
        String autor,
        String curso,
        Boolean activo
) {}
