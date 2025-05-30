package com.mack.clinica.controller;

import com.mack.clinica.model.Consulta;
import com.mack.clinica.model.AgendarConsultaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/paciente/minha-agenda")
public class MinhaAgendaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verifica se o paciente está logado
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        int pacienteId = (int) session.getAttribute("id");
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");

        try {
            AgendarConsultaDAO dao = new AgendarConsultaDAO(dbFilePath);
            List<Consulta> consultas = dao.listarPorPaciente(pacienteId);
            request.setAttribute("consultas", consultas);
            request.getRequestDispatcher("/WEB-INF/paciente/minha_agenda.jsp")
                   .forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Erro ao listar consultas do paciente.", e);
        }
    }
}
