<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title><c:choose>
           <c:when test="${not empty usuario.id}">Editar Médico</c:when>
           <c:otherwise>Novo Médico</c:otherwise>
         </c:choose>
  </title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

  <h2><c:choose>
        <c:when test="${not empty usuario.id}">Editar Médico</c:when>
        <c:otherwise>Novo Médico</c:otherwise>
      </c:choose>
  </h2>

  <form action="${pageContext.request.contextPath}/admin/medicos/salvar" method="post">
    <input type="hidden" name="id" value="${usuario.id}" />

    <label>Nome:</label><br/>
    <input name="nome"     value="${usuario.nome}"   required/><br/>

    <label>E-mail:</label><br/>
    <input name="email"    value="${usuario.email}"  required/><br/>

    <label>CPF:</label><br/>
    <input name="cpf"      value="${usuario.cpf}"    required/><br/>

    <label>Celular:</label><br/>
    <input name="celular"  value="${usuario.celular}" required/><br/>

    <label>Senha:</label><br/>
    <input name="senha"    value="${usuario.senha}"   required/><br/><br/>

    <button type="submit">Salvar</button>
    <a href="${pageContext.request.contextPath}/admin/medicos">Cancelar</a>
  </form>

</body>
</html>
