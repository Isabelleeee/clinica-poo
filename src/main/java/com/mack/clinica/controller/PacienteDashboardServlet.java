package com.mack.clinica.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 * Servlet para exibir o painel do paciente.
 */
@WebServlet("/paciente_dashboard")
public class PacienteDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Encaminha para o JSP do dashboard do paciente
        request.getRequestDispatcher("/paciente_dashboard.jsp")
               .forward(request, response);
    }
}
