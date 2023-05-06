package com.br.var.solutions.adapters.input.entities;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class PessoaResponse {
    public String nome;
    public String sobrenome;
    public String endereco;
    public int idade;
    public String imc;
    public double IR;
    public String aliquota;
    public String saldoEmDolar;
    public double peso;
    public String time;
    public double altura;
    public double salario;
    public int anoNascimento;
    public String mundialClubes;
    public String classificacaoIMC;
    public double saldo;
}

