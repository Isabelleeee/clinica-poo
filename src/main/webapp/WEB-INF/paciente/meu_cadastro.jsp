<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Meu Cadastro</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
  <h2>Meus Dados</h2>
  <div class="form-group">
    <label>Nome:</label>
    <span>${usuario.nome}</span>
  </div>
  <div class="form-group">
    <label>E-mail:</label>
    <span>${usuario.email}</span>
  </div>
  <div class="form-group">
    <label>CPF:</label>
    <span>${usuario.cpf}</span>
  </div>
  <div class="form-group">
    <label>Celular:</label>
    <span>${usuario.celular}</span>
  </div>
  <p><a href="${pageContext.request.contextPath}/paciente_dashboard">← Voltar</a></p>
</body>
</html>
