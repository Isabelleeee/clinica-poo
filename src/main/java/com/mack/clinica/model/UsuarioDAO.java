package com.mack.clinica.model;

import com.mack.clinica.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para operações CRUD sobre a tabela usuarios.
 */
public class UsuarioDAO {

    /**
     * Consulta o usuário pelo email e senha no banco.
     * @param email Email do usuário.
     * @param senha Senha do usuário.
     * @param dbFilePath Caminho real da aplicação para localizar o banco.
     * @return Objeto Usuario encontrado ou null se não encontrado.
     */
    public static Usuario buscarUsuario(String email, String senha, String dbFilePath) {
        String sql = "SELECT id, nome, tipo FROM usuarios WHERE email = ? AND senha = ?";
        try (Connection conn = DatabaseConnection.getConnection(dbFilePath);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, senha);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("nome"));
                    u.setTipo(rs.getString("tipo"));
                    return u;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário no banco de dados.", e);
        }
        return null;
    }

    /**
     * Consulta o usuário pelo ID no banco.
     * @param id ID do usuário.
     * @param dbFilePath Caminho real da aplicação para localizar o banco.
     * @return Objeto Usuario com todos os dados ou null se não encontrado.
     */
    public static Usuario buscarPorId(int id, String dbFilePath) {
        String sql = "SELECT id, nome, email, cpf, celular, tipo FROM usuarios WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(dbFilePath);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    u.setCpf(rs.getString("cpf"));
                    u.setCelular(rs.getString("celular"));
                    u.setTipo(rs.getString("tipo"));
                    return u;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário por ID.", e);
        }
        return null;
    }

    /**
     * Lista usuários por tipo (paciente, medico, admin).
     * @param tipo Tipo de usuário.
     * @param dbFilePath Caminho real da aplicação para localizar o banco.
     * @return Lista de usuários do tipo especificado.
     * @throws SQLException Se ocorrer erro na consulta.
     */
    public List<Usuario> listarPorTipo(String tipo, String dbFilePath) throws SQLException {
        String sql = "SELECT id, nome, email, cpf, celular, tipo FROM usuarios WHERE tipo = ?";
        List<Usuario> lista = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(dbFilePath);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    u.setCpf(rs.getString("cpf"));
                    u.setCelular(rs.getString("celular"));
                    u.setTipo(rs.getString("tipo"));
                    lista.add(u);
                }
            }
        }
        return lista;
    }

    /**
     * Insere um novo usuário no banco.
     * @param u Usuário a ser inserido.
     * @param dbFilePath Caminho real da aplicação para localizar o banco.
     * @throws SQLException Se ocorrer erro na inserção.
     */
    public static void inserir(Usuario u, String dbFilePath) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, cpf, celular, tipo, senha, created_at) "
                   + "VALUES (?, ?, ?, ?, ?, ?, datetime('now'))";
        try (Connection conn = DatabaseConnection.getConnection(dbFilePath);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getCpf());
            ps.setString(4, u.getCelular());
            ps.setString(5, u.getTipo());
            ps.setString(6, u.getSenha());
            ps.executeUpdate();
        }
    }

    /**
     * Atualiza um usuário existente no banco.
     * @param u Usuário com dados atualizados.
     * @param dbFilePath Caminho real da aplicação para localizar o banco.
     * @throws SQLException Se ocorrer erro na atualização.
     */
    public static void atualizar(Usuario u, String dbFilePath) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ?, email = ?, cpf = ?, celular = ?, senha = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(dbFilePath);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getCpf());
            ps.setString(4, u.getCelular());
            ps.setString(5, u.getSenha());
            ps.setInt(6, u.getId());
            ps.executeUpdate();
        }
    }

    /**
     * Exclui um usuário pelo ID.
     * @param id ID do usuário a ser excluído.
     * @param dbFilePath Caminho real da aplicação para localizar o banco.
     * @throws SQLException Se ocorrer erro na exclusão.
     */
    public static void excluir(int id, String dbFilePath) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(dbFilePath);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
