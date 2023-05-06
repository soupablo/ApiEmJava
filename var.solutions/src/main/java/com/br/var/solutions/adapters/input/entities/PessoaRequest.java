package com.br.var.solutions.adapters.input.entities;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PessoaRequest {
    public String nome;
    public String sobrenome;
    public String endereco;
    public int idade;
    public double peso;
    public String time;
    public double altura;
    public double salario;
    public double saldo;
}
