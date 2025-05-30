package com.mack.clinica.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin/prontuarios", "/prontuario" })
public class ProntuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Parâmetro "id" continua sendo lido normalmente, exemplo: /prontuario?id=123
        // Ou, se vier de /admin/prontuarios, pode usar atributo no session ou query string
        // Para simplificar, mantemos o mesmo fluxo

        // Encaminha para o JSP existente de prontuário
        request.getRequestDispatcher("/WEB-INF/admin/form_prontuario.jsp")
               .forward(request, response);
    }
}
