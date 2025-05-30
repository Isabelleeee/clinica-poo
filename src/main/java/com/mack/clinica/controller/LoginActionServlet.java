package com.mack.clinica.controller;

import java.io.IOException;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet responsável por processar o login do usuário.
 */
@WebServlet("/loginAction")
public class LoginActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Caminho absoluto para o arquivo db.db
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");

        // Busca o usuário no banco
        Usuario usuario = UsuarioDAO.buscarUsuario(email, senha, dbFilePath);

        if (usuario != null) {
            // Cria sessão e guarda atributos
            HttpSession session = request.getSession();
            session.setAttribute("id",   usuario.getId());
            session.setAttribute("nome", usuario.getNome());
            session.setAttribute("tipo", usuario.getTipo());

            // Redireciona para o dashboard conforme tipo
            String ctx = request.getContextPath();
            if ("admin".equalsIgnoreCase(usuario.getTipo())) {
                response.sendRedirect(ctx + "/admin_dashboard");
            } 
            else if ("paciente".equalsIgnoreCase(usuario.getTipo())) {
                response.sendRedirect(ctx + "/paciente_dashboard");
            } 
            else if ("medico".equalsIgnoreCase(usuario.getTipo())) {
                response.sendRedirect(ctx + "/medico_dashboard");
            } 
            else {
                response.sendRedirect(ctx + "/index.jsp?erro=tipo");
            }
        } else {
            // Usuário ou senha inválidos
            response.sendRedirect(request.getContextPath() + "/index.jsp?erro=login");
        }
    }
}
