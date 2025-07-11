package com.example.ForoHub.repositorio;

import com.example.ForoHub.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepositorio extends JpaRepository<Topico, Long> {

    // Este método será implementado automáticamente por Spring Data
    Page<Topico> findByActivoTrue(Pageable pageable);
}
