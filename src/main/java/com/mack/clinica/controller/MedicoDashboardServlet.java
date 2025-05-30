package com.mack.clinica.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.mack.clinica.model.Consulta;
import com.mack.clinica.model.AgendarConsultaDAO;

@WebServlet("/medico_dashboard")
public class MedicoDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. Verifica sessão e tipo de usuário
        HttpSession session = request.getSession(false);
        if (session == null 
            || session.getAttribute("id") == null 
            || !"medico".equals(session.getAttribute("tipo"))) {
            // Não autenticado como médico: volta para login
            response.sendRedirect(request.getContextPath() + "/index.jsp?erro=aut");
            return;
        }

        // 2. Recupera dados do médico da sessão
        int medicoId = (Integer) session.getAttribute("id");
        String medicoNome = (String) session.getAttribute("nome");

        // 3. Carrega as consultas agendadas para esse médico
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");
        try {
            AgendarConsultaDAO dao = new AgendarConsultaDAO(dbFilePath);
            // filtra apenas pelo profissional (medico) e sem filtro de paciente/data
            List<Consulta> consultas = dao.listarTodas(null, medicoId, null);

            // 4. Passa atributos para a JSP
            request.setAttribute("medicoNome", medicoNome);
            request.setAttribute("consultas", consultas);

            // 5. Encaminha para o JSP do dashboard do médico
            request.getRequestDispatcher("/medico_dashboard.jsp")
                   .forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Erro ao carregar dashboard do médico.", e);
        }
    }
}
