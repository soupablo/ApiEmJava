package com.br.var.solutions.application.services.useCase;

import com.br.var.solutions.application.services.entities.InformacoesIMC;

public interface ImcUseCase {
    InformacoesIMC calculoImc(double peso, double altura);
}
