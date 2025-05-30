<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Lista de Médicos</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

  <h2>Médicos</h2>
  <a href="${pageContext.request.contextPath}/admin/medicos/novo">+ Novo Médico</a>
  <br/><br/>

  <table>
    <thead>
      <tr>
        <th>ID</th><th>Nome</th><th>E-mail</th><th>CPF</th><th>Celular</th><th>Ações</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="m" items="${medicos}">
        <tr>
          <td>${m.id}</td>
          <td>${m.nome}</td>
          <td>${m.email}</td>
          <td>${m.cpf}</td>
          <td>${m.celular}</td>
          <td>
            <a href="${pageContext.request.contextPath}/admin/medicos/editar?id=${m.id}">Editar</a> |
            <a href="${pageContext.request.contextPath}/admin/medicos/excluir?id=${m.id}"
               onclick="return confirm('Confirma exclusão?')">Excluir</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <p><a href="${pageContext.request.contextPath}/admin_dashboard">← Voltar</a></p>
</body>
</html>
