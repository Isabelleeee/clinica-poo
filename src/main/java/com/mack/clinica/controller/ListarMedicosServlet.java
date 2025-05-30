package com.mack.clinica.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;

@WebServlet("/admin/medicos")
public class ListarMedicosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");
        try {
            List<Usuario> medicos = new UsuarioDAO().listarPorTipo("medico", dbFilePath);
            request.setAttribute("medicos", medicos);
            request.getRequestDispatcher("/WEB-INF/admin/lista_medicos.jsp")
                   .forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Erro ao listar médicos.", e);
        }
    }
}
