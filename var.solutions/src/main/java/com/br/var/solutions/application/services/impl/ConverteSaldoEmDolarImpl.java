package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.application.services.useCase.ConverteSaldoEmDolarUseCase;
import org.springframework.stereotype.Service;

@Service
public class ConverteSaldoEmDolarImpl implements ConverteSaldoEmDolarUseCase {

    public String conversorSaldoEmDolar(double idade){
        return converteSaldoEmDolar(idade);
    }

    private String converteSaldoEmDolar(double saldo) {
        return String.valueOf(saldo * 5.11);
    }
}
