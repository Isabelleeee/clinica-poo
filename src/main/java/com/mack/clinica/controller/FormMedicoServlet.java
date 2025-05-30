package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet({"/admin/medicos/novo", "/admin/medicos/editar"})
public class FormMedicoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            Usuario m = UsuarioDAO.buscarPorId(id, dbFilePath);
            request.setAttribute("usuario", m);
        }
        request.getRequestDispatcher("/WEB-INF/admin/form_medico.jsp")
               .forward(request, response);
    }
}
