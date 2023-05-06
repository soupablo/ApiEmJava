//package com.br.var.solutions.application.services.impl;
//
//import com.br.var.solutions.application.services.entities.InformacoesIMC;
//import com.br.var.solutions.InformacoesIR;
//import com.br.var.solutions.adapters.input.entities.PessoaRequest;
//import com.br.var.solutions.adapters.input.entities.PessoaResponse;
//import com.br.var.solutions.application.services.useCase.RespostaFrontEndUseCase;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RespostaFrontEndUseCaseImpl implements RespostaFrontEndUseCase {
//
//    public PessoaResponse napper(PessoaRequest pessoa, InformacoesIMC imc, int anoNascimento, InformacoesIR ir, String validaMundial, String saldoEmDolar){
//        return montarRespostaFrontEnd(pessoa, imc, anoNascimento, ir, validaMundial, saldoEmDolar);
//    }
//
//    private PessoaResponse montarRespostaFrontEnd(PessoaRequest pessoa, InformacoesIMC imc, int anoNascimento, InformacoesIR ir, String validaMundial, String saldoEmDolar) {
//
//        return PessoaResponse.builder()
//        .nome(pessoa.getNome())
//        .imc(imc.getImc())
//        .classificacaoIMC(imc.getClassificacao())
//        .anoNascimento(anoNascimento)
//        .saldoEmDolar(saldoEmDolar)
//        .mundialClubes(validaMundial)
//        .time(pessoa.getTime())
//        .sobrenome(pessoa.getSobrenome())
//        .endereco(pessoa.getEndereco())
//        .altura(pessoa.getAltura())
//        .peso(pessoa.getPeso())
//        .saldo(pessoa.getSaldo())
//        .build();
//
//    }
//}
