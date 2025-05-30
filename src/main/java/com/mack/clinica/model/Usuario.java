package com.mack.clinica.model;

import java.time.LocalDateTime;

/**
 * Modelo que representa o usuário do sistema.
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String celular;
    private String tipo; // paciente ou admin
    private String senha;
    private LocalDateTime createdAt;

    // Construtor padrão
    public Usuario() {}

    // Construtor para criação de novo usuário (sem id e createdAt)
    public Usuario(String nome, String email, String cpf, String celular, String tipo, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.celular = celular;
        this.tipo = tipo;
        this.senha = senha;
    }

    // Construtor para atualização (com id)
    public Usuario(int id, String nome, String email, String cpf, String celular, String tipo, String senha) {
        this(nome, email, cpf, celular, tipo, senha);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
