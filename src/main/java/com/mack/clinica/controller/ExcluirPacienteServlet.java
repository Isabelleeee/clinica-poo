package com.mack.clinica.controller;

import com.mack.clinica.model.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/pacientes/excluir")
public class ExcluirPacienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            UsuarioDAO.excluir(id, dbFilePath);
            response.sendRedirect(request.getContextPath() + "/admin/pacientes");
        } catch (SQLException e) {
            throw new ServletException("Erro ao excluir paciente.", e);
        }
    }
}
