package com.mack.clinica.controller;

import com.mack.clinica.model.Consulta;
import com.mack.clinica.model.AgendarConsultaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/consultas")
public class ListarConsultasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lê filtros (se fornecidos)
        String pac = request.getParameter("pacienteId");
        String med = request.getParameter("medicoId");
        String data = request.getParameter("data");

        Integer filtroPac = (pac != null && !pac.isEmpty()) ? Integer.valueOf(pac) : null;
        Integer filtroMed = (med != null && !med.isEmpty()) ? Integer.valueOf(med) : null;

        String dbFilePath = request.getServletContext().getRealPath("/WEB-INF/db.db");

        try {
            AgendarConsultaDAO dao = new AgendarConsultaDAO(dbFilePath);
            List<Consulta> consultas = dao.listarTodas(filtroPac, filtroMed, data);
            request.setAttribute("consultas", consultas);
            // mantém filtros no form
            request.setAttribute("filtroPacienteId", filtroPac);
            request.setAttribute("filtroMedicoId", filtroMed);
            request.setAttribute("filtroData", data);

            request.getRequestDispatcher("/WEB-INF/admin/lista_consultas.jsp")
                   .forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Erro ao listar todas as consultas.", e);
        }
    }
}
