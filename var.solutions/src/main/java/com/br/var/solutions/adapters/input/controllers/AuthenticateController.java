package com.br.var.solutions.adapters.input.controllers;

import com.br.var.solutions.adapters.input.entities.GenerateToken;
import com.br.var.solutions.adapters.input.entities.Usuario;
import com.br.var.solutions.application.services.useCase.UsuarioUseCase;
import com.br.var.solutions.infraestructure.config.security.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@Slf4j
public class AuthenticateController {

    @Autowired
    UsuarioUseCase usuarioUseCase;

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<GenerateToken> gerateToken(@RequestParam("client_id") String clientId,
                                                       @RequestParam("password")String password){

        log.info("iniciando a tentativa de geração de token para o usuario: " + clientId);

        Usuario user = usuarioUseCase.buscarUsuario(Usuario.builder()
                        .usuario(clientId)
                        .senha(password)
                .build());

        if(Objects.isNull(user)){
            log.error("Não foi possível gerar o token, pois o usuario ou seha estão incorretos.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(GenerateToken.builder().build());
        }

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

        String token = jwtTokenUtil.generateToken(clientId);

        GenerateToken tokenResponse = GenerateToken.builder().build();
        tokenResponse.setToken(token);

        log.info("token gerado com sucesso para o usuario: " + clientId + " Em: " + System.currentTimeMillis());
        return ResponseEntity.ok(tokenResponse);
    }
}
