<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Lista de Pacientes</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

  <h2>Pacientes</h2>
  <a href="${pageContext.request.contextPath}/admin/pacientes/novo">+ Novo Paciente</a>
  <br/><br/>

  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>E-mail</th>
        <th>CPF</th>
        <th>Celular</th>
        <th>Ações</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="p" items="${pacientes}">
        <tr>
          <td>${p.id}</td>
          <td>${p.nome}</td>
          <td>${p.email}</td>
          <td>${p.cpf}</td>
          <td>${p.celular}</td>
          <td>
            <a href="${pageContext.request.contextPath}/admin/pacientes/editar?id=${p.id}">Editar</a> |
            <a href="${pageContext.request.contextPath}/admin/pacientes/excluir?id=${p.id}"
               onclick="return confirm('Confirma exclusão?')">Excluir</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <p><a href="${pageContext.request.contextPath}/admin_dashboard">← Voltar</a></p>
</body>
</html>
