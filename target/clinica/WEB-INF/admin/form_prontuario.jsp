<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Ficha Clínica (Prontuário)</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

  <!-- Navbar com Logout e Voltar -->
  <div class="navbar">
    <ul class="nav-links">
      <li>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
      </li>
      <li>
        <c:choose>
          <c:when test="${sessionScope.tipo == 'medico'}">
            <a href="${pageContext.request.contextPath}/medico_dashboard">Voltar</a>
          </c:when>
          <c:when test="${sessionScope.tipo == 'admin'}">
            <a href="${pageContext.request.contextPath}/admin_dashboard">Voltar</a>
          </c:when>
          <c:otherwise>
            <a href="${pageContext.request.contextPath}/index.jsp">Voltar</a>
          </c:otherwise>
        </c:choose>
      </li>
    </ul>
  </div>

  <div class="card">
    <h2>Ficha Clínica (Prontuário)</h2>
    <form action="#" method="post">
      <label for="pacienteId">Paciente ID:</label><br/>
      <input id="pacienteId" name="pacienteId" disabled
             value="${consulta.pacienteId}" /><br/><br/>

      <label for="profissionalId">Profissional ID:</label><br/>
      <input id="profissionalId" name="profissionalId" disabled
             value="${consulta.profissionalId}" /><br/><br/>

      <label for="data">Data:</label><br/>
      <input id="data" name="data" type="date" disabled
             value="${consulta.data}" /><br/><br/>

      <label for="anotacoes">Anotações Médicas:</label><br/>
      <textarea id="anotacoes" name="anotacoes" rows="5" disabled>${consulta.anotacoes}</textarea><br/><br/>

      <label for="prescricoes">Prescrições:</label><br/>
      <textarea id="prescricoes" name="prescricoes" rows="3" disabled>${consulta.prescricoes}</textarea><br/><br/>

      <p><em>Este formulário é apenas estrutural — o salvamento ainda não está implementado.</em></p>
    </form>
  </div>

</body>
</html>
