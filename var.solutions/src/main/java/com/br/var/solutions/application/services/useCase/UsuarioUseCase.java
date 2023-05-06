package com.br.var.solutions.application.services.useCase;

import com.br.var.solutions.adapters.input.entities.Usuario;

public interface UsuarioUseCase {

    Usuario cadastraUsuario(Usuario user);

    Usuario buscarUsuario(Usuario user);
}
