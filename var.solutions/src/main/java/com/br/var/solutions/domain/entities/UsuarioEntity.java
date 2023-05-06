package com.br.var.solutions.domain.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "tabUsuario")
@Entity
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "nome")
    private String nomeUser;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "senha")
    private String senha;

}
