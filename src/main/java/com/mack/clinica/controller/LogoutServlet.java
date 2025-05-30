package com.mack.clinica.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 * Servlet responsável por encerrar a sessão do usuário.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalida a sessão atual, se existir
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // Redireciona de volta para a página de login
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
