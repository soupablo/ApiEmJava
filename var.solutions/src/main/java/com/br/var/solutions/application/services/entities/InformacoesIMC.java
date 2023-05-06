package com.br.var.solutions.application.services.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InformacoesIMC {
    private String imc;
    private String classificacao;
}
