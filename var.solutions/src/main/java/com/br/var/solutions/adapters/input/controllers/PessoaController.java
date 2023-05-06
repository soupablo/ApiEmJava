package com.br.var.solutions.adapters.input.controllers;

import com.br.var.solutions.*;
import com.br.var.solutions.adapters.input.entities.PessoaRequest;
import com.br.var.solutions.adapters.input.entities.PessoaResponse;
import com.br.var.solutions.application.services.entities.InformacoesIMC;
import com.br.var.solutions.application.services.useCase.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*")
@Slf4j
public class PessoaController {

    private String novoSalarioCalculado;
    //    1                   2               3               4
    //publico/privado //tipo de retorno //nome do metodo // parâmetros

    @Autowired
    private MundialUseCase mundialUseCase;

    @Autowired
    private AnoNascimentoUseCase anoNascimentoUseCase;

    @Autowired
    private InformacoesIrUseCase informacoesIrUseCase;

    @Autowired
    private ImcUseCase imcUseCase;

    @Autowired
    private ConverteSaldoEmDolarUseCase converteSaldoEmDolar;

    //endpoint

    @GetMapping
    public ResponseEntity<Object> get() {

        PessoaRequest pessoaRequest1 = PessoaRequest.builder().build();
        pessoaRequest1.setNome("Gabriel");
        pessoaRequest1.setSobrenome("Takasaki");
        pessoaRequest1.setEndereco("Rua Bronze, 20");
        pessoaRequest1.setIdade(27);

        return ResponseEntity.ok(pessoaRequest1);
    }

    @GetMapping("/resumo")
    public ResponseEntity<Object> getPessoa(@RequestBody PessoaRequest pessoinha, @RequestParam(value = "valida_mundial") Boolean DesejavalidarMundial) {
        InformacoesIR ir = new InformacoesIR();
        InformacoesIMC imc = InformacoesIMC.builder().build();
        int anoNascimento = 0;
        String validaMundial = null;
        String saldoEmDolar = null;

        if (!pessoinha.getNome().isEmpty()) {


            log.info("iniciando o processo de resumo da pessoa: " + pessoinha);

            if (Objects.nonNull(pessoinha.getPeso()) && Objects.nonNull(pessoinha.getAltura())) {
                log.info("iniciando o calculo do IMC");
                imc = imcUseCase.calculoImc(pessoinha.getPeso(),pessoinha.getAltura());
            }

            if (Objects.nonNull(pessoinha.getIdade())) {
                log.info("iniciando o calculo do ano de nascimento");
                anoNascimento = anoNascimentoUseCase.calculoAnoNasc(pessoinha.getIdade());
            }

            if (Objects.nonNull(pessoinha.getSalario())) {
                log.info("iniciando o calculo de Faixa Imposto de renda");
                ir = informacoesIrUseCase.calculoIr(pessoinha.getSalario());
            }
            if (Boolean.TRUE.equals(DesejavalidarMundial))
                if (Objects.nonNull(pessoinha.getTime())) {
                    log.info("iniciando o calculo se o time tem mundial");
                    validaMundial = mundialUseCase.calculoMundial(pessoinha.getTime());
                }

            if (Objects.nonNull(pessoinha.getSaldo())) {
                log.info("Convertendo real em dólar");
                saldoEmDolar = converteSaldoEmDolar.conversorSaldoEmDolar(pessoinha.getSaldo());
            }

            log.info("montando objeto de retorno para o front");
            PessoaResponse resumo = montarRespostaFrontEnd(pessoinha, imc, anoNascimento, ir, validaMundial, saldoEmDolar);


            return ResponseEntity.ok(resumo);

        }

        return ResponseEntity.noContent().build();
    }
    private PessoaResponse montarRespostaFrontEnd(PessoaRequest pessoa, InformacoesIMC imc, int anoNascimento, InformacoesIR ir, String validaMundial, String saldoEmDolar) {
        PessoaResponse response = PessoaResponse.builder().build();

        response.setNome(pessoa.getNome());
        response.setSalario(pessoa.getSalario());
        response.setAnoNascimento(anoNascimento);
        response.setMundialClubes(validaMundial);
        response.setSaldoEmDolar(saldoEmDolar);
        response.setIdade(pessoa.getIdade());
        response.setTime(pessoa.getTime());
        response.setSobrenome(pessoa.getSobrenome());
        response.setEndereco(pessoa.getEndereco());
        response.setAltura(pessoa.getAltura());
        response.setPeso(pessoa.getPeso());
        response.setSaldo(pessoa.getSaldo());

        response.setImc(imc.getImc());
        response.setClassificacaoIMC(imc.getClassificacao());

        response.setIR(ir.getCalculoIR());
        response.setAliquota(ir.getAliquota());

        return response;
    }
}
