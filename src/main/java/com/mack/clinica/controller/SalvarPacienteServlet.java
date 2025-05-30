package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/pacientes/salvar")
public class SalvarPacienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");

        // Parâmetros do formulário
        String idParam  = request.getParameter("id");
        String nome     = request.getParameter("nome");
        String email    = request.getParameter("email");
        String cpf      = request.getParameter("cpf");
        String celular  = request.getParameter("celular");
        String senha    = request.getParameter("senha");
        String confirma = request.getParameter("confirmaSenha");

        // Validações básicas
        if (nome == null || nome.isBlank() ||
            email == null || email.isBlank() ||
            cpf == null || cpf.isBlank() ||
            celular == null || celular.isBlank() ||
            senha == null || senha.isBlank() ||
            confirma == null || confirma.isBlank()) {

            request.setAttribute("erro", "Todos os campos são obrigatórios.");
            request.getRequestDispatcher("/index.jsp")
                   .forward(request, response);
            return;
        }

        if (!senha.equals(confirma)) {
            request.setAttribute("erro", "Senha e confirmação não conferem.");
            request.getRequestDispatcher("/index.jsp")
                   .forward(request, response);
            return;
        }

        try {
            if (idParam == null || idParam.isEmpty()) {
                // inserir novo paciente
                Usuario u = new Usuario(nome, email, cpf, celular, "paciente", senha);
                UsuarioDAO.inserir(u, dbFilePath);
                // redireciona de volta ao index.jsp com flag de sucesso
                response.sendRedirect(request.getContextPath() + "/index.jsp?novocadastro=1");
            } else {
                // atualizar existente (fluxo admin)
                int id = Integer.parseInt(idParam);
                Usuario u = new Usuario(id, nome, email, cpf, celular, "paciente", senha);
                UsuarioDAO.atualizar(u, dbFilePath);
                response.sendRedirect(request.getContextPath() + "/admin/pacientes");
            }
        } catch (SQLException e) {
            throw new ServletException("Erro ao salvar paciente.", e);
        }
    }
}
