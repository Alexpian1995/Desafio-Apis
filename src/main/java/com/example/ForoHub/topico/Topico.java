package com.example.ForoHub.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(nullable = false)
    private Boolean activo = true;
    private String status;
    private String autor;
    private String curso;

    public Topico() {
        // Constructor por defecto necesario para JPA
    }

    public Topico(@Valid DatosRegistroTopico datos){

        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = datos.fechaCreacion();
        this.status  = datos.status();
        this.autor = datos.autor();
        this.curso = datos.curso();
        this.activo = true;
    }

    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getMensaje() {
        return mensaje;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public String getStatus() {
        return status;
    }
    public String getAutor() {
        return autor;
    }
    public String getCurso() {
        return curso;
    }
    public Boolean getActivo(){
        return activo;
    }




    public void actualizarDatos(@Valid DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.status() != null) {
            this.status = datosActualizarTopico.status();
        }
        if (datosActualizarTopico.curso() != null) {
            this.curso = datosActualizarTopico.curso();
        }
        if (datosActualizarTopico.activo() != null) {
            this.activo = datosActualizarTopico.activo();
        }
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }


}

