package com.br.var.solutions.application.services.impl;

import com.br.var.solutions.application.services.useCase.MundialUseCase;
import org.springframework.stereotype.Service;

@Service
public class MundialUseCaseImpl implements MundialUseCase {

    public String calculoMundial(String time){
        return calculaMundial(time);
    }
    private String calculaMundial(String time) {

        if (time.equalsIgnoreCase("Corinthians")) {
            return "Parabéns, seu time possui 2 mundiais de clubes conforme a FIFA";
        } else if (time.equalsIgnoreCase("São Paulo")) {
            return "Parabéns, seu time possui 3 mundiais de clubes conforme a FIFA";
        } else if (time.equalsIgnoreCase("Santos")) {
            return "Parabéns, seu time possui 3 mundiais de clubes conforme a FIFA";
        } else {
            return "Poxa, continue torcendo para que o seu time ganhe o mundial";
        }
    }
}
