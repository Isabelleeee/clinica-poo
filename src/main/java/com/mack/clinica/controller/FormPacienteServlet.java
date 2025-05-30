package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet({"/admin/pacientes/novo", "/admin/pacientes/editar"})
public class FormPacienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            Usuario u = UsuarioDAO.buscarPorId(id, dbFilePath);
            request.setAttribute("usuario", u);
        }
        // Se id==null: cadastro novo, JSP verá usuario==null e exibirá campos em branco
        request.getRequestDispatcher("/WEB-INF/admin/form_paciente.jsp")
               .forward(request, response);
    }
}
