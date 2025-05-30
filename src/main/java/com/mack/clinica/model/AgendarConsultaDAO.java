package com.mack.clinica.model;

import com.mack.clinica.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendarConsultaDAO {
    private final String dbFilePath;

    public AgendarConsultaDAO(String dbFilePath) {
        this.dbFilePath = dbFilePath;
    }

    /**
     * Lista todos os médicos (usuários com tipo = 'medico').
     */
    public List<Usuario> listarMedicos() throws SQLException {
        String sql = "SELECT id, nome, email, cpf, celular, tipo FROM usuarios WHERE tipo = 'medico'";
        List<Usuario> medicos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection(dbFilePath);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setCpf(rs.getString("cpf"));
                u.setCelular(rs.getString("celular"));
                u.setTipo(rs.getString("tipo"));
                medicos.add(u);
            }
        }
        return medicos;
    }

    /**
     * Grava uma nova consulta para o paciente.
     * Usa o status 'agendada' (minúsculo) para satisfazer a constraint CHECK.
     */
    public boolean agendarConsulta(int pacienteId, int profissionalId, String dataHora) throws SQLException {
        String sql = "INSERT INTO consultas (paciente_id, profissional_id, data_hora, status, observacoes) " +
                     "VALUES (?, ?, ?, 'agendada', '')";  // <-- status em minúsculas

        try (Connection conn = DatabaseConnection.getConnection(dbFilePath);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pacienteId);
            ps.setInt(2, profissionalId);
            ps.setString(3, dataHora);
            return ps.executeUpdate() > 0;
        }
    }

    /**
     * Lista todas as consultas agendadas para um dado paciente.
     */
    public List<Consulta> listarPorPaciente(int pacienteId) throws SQLException {
        String sql =
            "SELECT c.id, c.paciente_id, c.profissional_id, c.data_hora, c.status, c.observacoes, " +
            "u.nome AS nomeProfissional " +
            "FROM consultas c " +
            "JOIN usuarios u ON c.profissional_id = u.id " +
            "WHERE c.paciente_id = ? " +
            "ORDER BY c.data_hora";

        List<Consulta> lista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection(dbFilePath);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, pacienteId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Consulta c = new Consulta();
                    c.setId(rs.getInt("id"));
                    c.setPacienteId(rs.getInt("paciente_id"));
                    c.setProfissionalId(rs.getInt("profissional_id"));
                    c.setDataHora(rs.getString("data_hora"));
                    c.setStatus(rs.getString("status"));
                    c.setObservacoes(rs.getString("observacoes"));
                    c.setNomeProfissional(rs.getString("nomeProfissional"));
                    lista.add(c);
                }
            }
        }
        return lista;
    }

    /**
     * Lista todas as consultas, opcionalmente filtrando por paciente, médico ou data.
     */
    public List<Consulta> listarTodas(Integer filtroPacienteId,
                                      Integer filtroMedicoId,
                                      String filtroData) throws SQLException {
        StringBuilder sql = new StringBuilder(
            "SELECT c.id, c.paciente_id, p.nome AS nomePaciente, " +
            "c.profissional_id, m.nome AS nomeMedico, " +
            "c.data_hora, c.status, c.observacoes " +
            "FROM consultas c " +
            "JOIN usuarios p ON c.paciente_id = p.id " +
            "JOIN usuarios m ON c.profissional_id = m.id"
        );
        List<Object> params = new ArrayList<>();
        boolean where = false;

        if (filtroPacienteId != null) {
            sql.append(where ? " AND " : " WHERE ").append("c.paciente_id = ?");
            params.add(filtroPacienteId);
            where = true;
        }
        if (filtroMedicoId != null) {
            sql.append(where ? " AND " : " WHERE ").append("c.profissional_id = ?");
            params.add(filtroMedicoId);
            where = true;
        }
        if (filtroData != null && !filtroData.isEmpty()) {
            sql.append(where ? " AND " : " WHERE ")
               .append("date(c.data_hora) = date(?)");
            params.add(filtroData);
        }

        sql.append(" ORDER BY c.data_hora");

        List<Consulta> lista = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(dbFilePath);
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Consulta c = new Consulta();
                    c.setId(rs.getInt("id"));
                    c.setPacienteId(rs.getInt("paciente_id"));
                    c.setNomePaciente(rs.getString("nomePaciente"));
                    c.setProfissionalId(rs.getInt("profissional_id"));
                    c.setNomeProfissional(rs.getString("nomeMedico"));
                    c.setDataHora(rs.getString("data_hora"));
                    c.setStatus(rs.getString("status"));
                    c.setObservacoes(rs.getString("observacoes"));
                    lista.add(c);
                }
            }
        }
        return lista;
    }
}
