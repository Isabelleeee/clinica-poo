<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Consultar Agenda</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
  <h2>Consultar Agenda</h2>

  <form method="get" action="${pageContext.request.contextPath}/admin/consultas">
    <label>Paciente ID:</label>
    <input name="pacienteId" value="${filtroPacienteId}" />
    <label>Médico ID:</label>
    <input name="medicoId" value="${filtroMedicoId}" />
    <label>Data (YYYY-MM-DD):</label>
    <input name="data" value="${filtroData}" />
    <button type="submit">Filtrar</button>
    <a href="${pageContext.request.contextPath}/admin/consultas">Limpar</a>
  </form>

  <br/>

  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Paciente</th>
        <th>Médico</th>
        <th>Data/Hora</th>
        <th>Status</th>
        <th>Observações</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="c" items="${consultas}">
        <tr>
          <td>${c.id}</td>
          <td>${c.nomePaciente} (#${c.pacienteId})</td>
          <td>${c.nomeProfissional} (#${c.profissionalId})</td>
          <td>${c.dataHora}</td>
          <td>${c.status}</td>
          <td>${c.observacoes}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <p><a href="${pageContext.request.contextPath}/admin_dashboard">← Voltar</a></p>
</body>
</html>
