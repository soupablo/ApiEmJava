package com.br.var.solutions.domain.repositories;

import com.br.var.solutions.domain.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioEntity, Long> {

    UsuarioEntity findByUsuario(String nome);
}
