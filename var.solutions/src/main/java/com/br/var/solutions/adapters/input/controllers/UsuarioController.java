package com.br.var.solutions.adapters.input.controllers;


import com.br.var.solutions.adapters.input.entities.Usuario;
import com.br.var.solutions.application.services.useCase.UsuarioUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
@Slf4j
public class UsuarioController {

    @Autowired
    UsuarioUseCase usuarioUseCase;

    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody Usuario user){

        log.info("Iniciando o cadastro de um novo usuario");
        Usuario novoUsuarioCadastrado = usuarioUseCase.cadastraUsuario(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
