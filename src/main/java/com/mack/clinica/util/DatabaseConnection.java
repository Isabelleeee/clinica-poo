package com.mack.clinica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    /**
     * Método para obter uma conexão com o banco de dados SQLite.
     * @param dbFilePath Caminho absoluto para o arquivo db.db (obtido pelo ServletContext).
     * @return Conexão ativa com o banco.
     * @throws RuntimeException caso ocorra erro ao conectar.
     */
    public static Connection getConnection(String dbFilePath) {
        try {
            // Garante que o driver SQLite seja carregado
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver SQLite não encontrado.", e);
        }

        try {
            // Monta a URL de conexão do SQLite usando o caminho completo do arquivo
            String url = "jdbc:sqlite:" + dbFilePath;
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados.", e);
        }
    }
}
