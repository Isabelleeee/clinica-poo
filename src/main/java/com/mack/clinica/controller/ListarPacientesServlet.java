package com.mack.clinica.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;

@WebServlet("/admin/pacientes")
public class ListarPacientesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");
        try {
            List<Usuario> pacientes = new UsuarioDAO().listarPorTipo("paciente", dbFilePath);
            request.setAttribute("pacientes", pacientes);
            request.getRequestDispatcher("/WEB-INF/admin/lista_pacientes.jsp")
                   .forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Erro ao listar pacientes.", e);
        }
    }
}
