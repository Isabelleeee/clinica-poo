package com.mack.clinica.model;

public class Consulta {
    private int id;
    private int pacienteId;
    private int profissionalId;
    private String dataHora;
    private String status;
    private String observacoes;
    private String nomeProfissional;
    private String nomePaciente;

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPacienteId() { return pacienteId; }
    public void setPacienteId(int pacienteId) { this.pacienteId = pacienteId; }

    public int getProfissionalId() { return profissionalId; }
    public void setProfissionalId(int profissionalId) { this.profissionalId = profissionalId; }

    public String getDataHora() { return dataHora; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public String getNomeProfissional() { return nomeProfissional; }
    public void setNomeProfissional(String nomeProfissional) { this.nomeProfissional = nomeProfissional; }

    public String getNomePaciente() { return nomePaciente; }
public void setNomePaciente(String nomePaciente) { this.nomePaciente = nomePaciente; }
}
