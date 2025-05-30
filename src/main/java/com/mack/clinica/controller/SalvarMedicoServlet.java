package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/medicos/salvar")
public class SalvarMedicoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");
        String idParam   = request.getParameter("id");
        String nome      = request.getParameter("nome");
        String email     = request.getParameter("email");
        String cpf       = request.getParameter("cpf");
        String celular   = request.getParameter("celular");
        String senha     = request.getParameter("senha");

        try {
            if (idParam == null || idParam.isEmpty()) {
                // inserir novo médico
                UsuarioDAO.inserir(
                    new Usuario(nome, email, cpf, celular, "medico", senha),
                    dbFilePath
                );
            } else {
                // atualizar existente
                int id = Integer.parseInt(idParam);
                UsuarioDAO.atualizar(
                    new Usuario(id, nome, email, cpf, celular, "medico", senha),
                    dbFilePath
                );
            }
            // redireciona de volta à lista de médicos
            response.sendRedirect(request.getContextPath() + "/admin/medicos");
        } catch (SQLException e) {
            throw new ServletException("Erro ao salvar médico.", e);
        }
    }
}
