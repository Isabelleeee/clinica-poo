package com.mack.clinica.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.mack.clinica.model.AgendarConsultaDAO;
import com.mack.clinica.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/agendarConsulta")
public class AgendarConsultaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Exibe o formulário de agendamento, carregando a lista de médicos.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String dbPath = req.getServletContext().getRealPath("/WEB-INF/db.db");
        try {
            AgendarConsultaDAO dao = new AgendarConsultaDAO(dbPath);
            List<Usuario> medicos = dao.listarMedicos();
            req.setAttribute("medicos", medicos);
            req.getRequestDispatcher("/agendar_consulta.jsp")
               .forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException("Erro ao carregar lista de médicos.", e);
        }
    }

    /**
     * Processa o POST do formulário e insere a consulta no banco.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1) Recupera a sessão e o ID do paciente
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            // Usuário não logado ou sessão expirada
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        int pacienteId = (Integer) session.getAttribute("id");

        // 2) Lê parâmetros do form
        String profIdStr = req.getParameter("profissionalId");
        String dataHora  = req.getParameter("dataHora"); // ex: "2025-05-30T14:30"

        // 3) Validação simples dos campos
        if (profIdStr == null || profIdStr.isBlank() ||
            dataHora  == null || dataHora.isBlank()) {

            req.setAttribute("erro", "Por favor, selecione um médico e informe data/hora.");
            // Recarrega o form com a lista de médicos e a mensagem de erro
            doGet(req, resp);
            return;
        }

        int profissionalId = Integer.parseInt(profIdStr);

        try {
            // 4) Tenta inserir no BD via DAO
            String dbPath = req.getServletContext().getRealPath("/WEB-INF/db.db");
            AgendarConsultaDAO dao = new AgendarConsultaDAO(dbPath);
            boolean ok = dao.agendarConsulta(pacienteId, profissionalId, dataHora);
            if (!ok) {
                req.setAttribute("erro", "Não foi possível agendar. Tente novamente.");
                doGet(req, resp);
                return;
            }

            // 5) Redireciona para o dashboard do paciente
            resp.sendRedirect(req.getContextPath() + "/paciente_dashboard");
        } catch (SQLException e) {
            throw new ServletException("Erro ao agendar consulta.", e);
        }
    }
}
