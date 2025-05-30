<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8"/>
  <title>Minha Agenda</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>
<body>
  <div class="navbar">
    <ul class="nav-links">
      <li><a href="${pageContext.request.contextPath}/paciente_dashboard">Home</a></li>
      <li><a href="${pageContext.request.contextPath}/agendarConsulta">Agendar Consulta</a></li>
      <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
    </ul>
  </div>

  <div class="card">
    <h1>Minha Agenda</h1>
    <c:choose>
      <c:when test="${empty consultas}">
        <p>Você não tem consultas agendadas.</p>
      </c:when>
      <c:otherwise>
        <table>
          <thead>
            <tr>
              <th>Data/Hora</th>
              <th>Médico</th>
              <th>Status</th>
              <th>Observações</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="c" items="${consultas}">
              <tr>
                <td>${c.dataHora}</td>
                <td>${c.nomeProfissional}</td>
                <td>${c.status}</td>
                <td>${c.observacoes}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </c:otherwise>
    </c:choose>
  </div>
</body>
</html>
