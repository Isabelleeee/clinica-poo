package com.mack.clinica.controller;

import com.mack.clinica.model.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/medicos/excluir")
public class ExcluirMedicoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                UsuarioDAO.excluir(id, dbFilePath);
            } catch (SQLException e) {
                throw new ServletException("Erro ao excluir médico.", e);
            }
        }
        // Redireciona de volta à lista de médicos
        response.sendRedirect(request.getContextPath() + "/admin/medicos");
    }
}
