package com.example.ForoHub.topico;

import java.time.LocalDateTime;

public record DatosRegistroTopico(String titulo,
                                  String mensaje,
                                  String autor,
                                  String curso,
                                  LocalDateTime fechaCreacion,
                                  String status) {
}
