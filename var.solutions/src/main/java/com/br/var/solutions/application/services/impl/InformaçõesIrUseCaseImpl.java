package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.InformacoesIR;
import com.br.var.solutions.application.services.useCase.InformacoesIrUseCase;
import org.springframework.stereotype.Service;

@Service
public class InformaçõesIrUseCaseImpl implements InformacoesIrUseCase {
    public InformacoesIR calculoIr(double salario){
        return calculoIr(salario);

    }
    private InformacoesIR CalculaFaixaImpostoRenda(double salario) {
        String novoSalarioCalculado;

        InformacoesIR irCalculado = new InformacoesIR();

        if (salario < 1903.98) {
            irCalculado.setCalculoIR(Double.parseDouble(String.valueOf(irCalculado.getIsento())));
            irCalculado.setAliquota("isento.");
            return irCalculado;

        } else if (salario >= 1903.98 && salario < 2826.65) {
            irCalculado.calculoIR = (salario / 100) * irCalculado.getLiquota1();
            irCalculado.setLiquota1(Double.parseDouble(String.valueOf(irCalculado.getCalculoIR())));
            irCalculado.setAliquota("7.5%");

            return irCalculado;

        } else if (salario >= 2826.66 && salario < 3751.05) {

            irCalculado.calculoIR = (salario / 100) * irCalculado.getLiquota2();
            irCalculado.setLiquota2(Double.parseDouble(String.valueOf(irCalculado.getCalculoIR())));
            irCalculado.setAliquota("15%");

            return irCalculado;

        } else if (salario >= 3751.06 && salario <= 4664.68) {

            irCalculado.calculoIR = (salario / 100) * irCalculado.getLiquota3();
            irCalculado.setLiquota3(Double.parseDouble(String.valueOf(irCalculado.getCalculoIR())));
            irCalculado.setAliquota("22.5%");

            return irCalculado;

        } else {

            irCalculado.calculoIR = (salario / 100) * irCalculado.getLiquota4();
            irCalculado.setLiquota4(Double.parseDouble(String.valueOf(irCalculado.getCalculoIR())));
            irCalculado.setAliquota("27.5%");

            return irCalculado;
        }
    }
}
