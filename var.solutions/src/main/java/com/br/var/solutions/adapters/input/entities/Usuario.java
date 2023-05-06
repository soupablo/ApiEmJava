package com.br.var.solutions.adapters.input.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include. NON_NULL)
public class Usuario {

    private int id;

    private String nome;

    private String usuario;

    private String senha;
}
