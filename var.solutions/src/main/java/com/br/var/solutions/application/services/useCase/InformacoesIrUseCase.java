package com.br.var.solutions.application.services.useCase;

import com.br.var.solutions.InformacoesIR;

public interface InformacoesIrUseCase {

    public default InformacoesIR calculoIr(double salario) {
        return null;
    }
}
