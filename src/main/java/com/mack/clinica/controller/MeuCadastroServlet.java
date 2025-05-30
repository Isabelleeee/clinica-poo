package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/paciente/meu-cadastro")
public class MeuCadastroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1) recuperar sessão (sem criar nova)
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        // 2) ler o ID do paciente
        int usuarioId = (int) session.getAttribute("id");

        // 3) buscar dados completos no DAO
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");
        Usuario usuario = UsuarioDAO.buscarPorId(usuarioId, dbFilePath);

        // 4) enviar pro JSP
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("/WEB-INF/paciente/meu_cadastro.jsp")
               .forward(request, response);
    }
}
