package com.example.ForoHub.controller;

import com.example.ForoHub.config.LoginDTO;
import com.example.ForoHub.config.TokenService;
import com.example.ForoHub.repositorio.UsuarioRepository;
import com.example.ForoHub.config.SecurityConfig;
import com.example.ForoHub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService; // 🔑 Servicio para generar el JWT

    // 🔐 LOGIN
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO loginDTO) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.username(),
                        loginDTO.password()
                )
        );

        String token = tokenService.generarToken(auth);
        return ResponseEntity.ok(token); // 🔐 Devuelve el JWT como respuesta
    }

    // ✅ REGISTRO
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Usuario usuario) {
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol("ROLE_USER");
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuario creado con éxito");
    }
}
