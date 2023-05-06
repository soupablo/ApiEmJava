package com.br.var.solutions.adapters.input.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Builder
public class GenerateToken {
    private String token;
    private Date expiraEm;
    private long tempoValidacao;
    private String solicitante;
}

