//caminho do arquivo (empresa)
package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//nome da Classe (departamento)
public class Main {

    //nome do metodo - Recurso dentro da classe (O que o departamento faz)
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //       1                  2                   3
        //tipo de variavel / nome da variavel / valor da variavel

        String olaMundo = "ola!";

        System.out.println(olaMundo);

        String nome1 = "Gabriel";
        String sobreNome = "Takasaki";

        System.out.println(nome1 + " " + sobreNome + ".");

        String retornoMetodo = buscarSobrenome();
        System.out.println(retornoMetodo);

        String retornoMetodo2 = inserirNome();
        System.out.println(retornoMetodo2);

        double imc = calcularIMC();
        System.out.println("IMC: " + imc);

        int idade = retornaIdadePorAno();
        List<String> retornoMensagem = resumoPessoa();
        System.out.println(retornoMensagem);

    }
    //       1                  2                   3              4
    //tipo de acesso / tipo de retorno  /   nome do metodo /   parametros

    public static String buscarSobrenome() {
        String sobreNome = "Takasaki";
        return sobreNome;
    }

    public static String inserirNome() {
        Scanner ler = new Scanner(System.in);

        System.out.printf("Digite seu nome: ");
        String nome = ler.next();

        System.out.printf("Digite seu sobrenome: ");
        String sobrenome = ler.next();

        System.out.println(nome + " " + sobrenome);

        String nomeCompleto = nome + " " + sobrenome;

        return nomeCompleto;
    }

    public static double calcularIMC() {

        Scanner ler = new Scanner(System.in);

        System.out.printf("digite sua altura: ");
        double altura = ler.nextDouble();

        System.out.printf("digite o seu peso: ");
        double peso = ler.nextDouble();

        double calculaIMC = peso / (altura * altura);

        System.out.println("Seu IMC é: " + calculaIMC);

        if (calculaIMC < 19.0) {
            System.out.println("Você está abaixo do peso");
        } else {
            System.out.println("Você está acima do peso");
        }

        return calculaIMC;
    }

    public static int retornaIdadePorAno() {
        int idadeCalculada;

        Scanner ler = new Scanner(System.in);

        System.out.printf("Digite seu nome: ");
        String nome = ler.next();

        System.out.printf("Digite o ano do seu nascimento: ");
        int anoBase = ler.nextInt();

        idadeCalculada = 2022 - anoBase;

        String tipoPessoa;

        String maiorDezoito = "Você é maior de 18 anos";
        String menorDezoito = "Você é menor de 18 anos, cai fora!";

        if (idadeCalculada <= 17) {
            tipoPessoa = menorDezoito;
        } else {
            tipoPessoa = maiorDezoito;
        }

        System.out.println(nome + " sua idade é: " + idadeCalculada + " anos e " + tipoPessoa);

        return idadeCalculada;
    }

    public static List<String> resumoPessoa() {
        Scanner ler = new Scanner(System.in);

        List<String> nomesResumo = new ArrayList<>();

        //         1;     2;      3;
        for (int i = 1; i < 4; i++){

            System.out.printf("Digite seu nome: ");
        String nome = ler.next();

        System.out.printf("Digite seu sobrenome: ");
        String sobrenome = ler.next();

        System.out.printf("Digite sua idade: ");
        int idade = ler.nextInt();

        String nomeCompleto = nome + " " + sobrenome;

        String tipoDePessoa = "";

        if (idade <= 17) {
            tipoDePessoa = "menor de idade.";
        } else {
            tipoDePessoa = "maior de idade";
        }

        String resumo = "O nome completo é: " + nomeCompleto +", ele tem "+ idade + " anos"+ ", e ele é: " + tipoDePessoa;

        nomesResumo.add(resumo);

    }

        return nomesResumo;
    }
}