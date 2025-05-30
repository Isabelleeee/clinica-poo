<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title><c:choose>
           <c:when test="${not empty usuario.id}">Editar Paciente</c:when>
           <c:otherwise>Novo Paciente</c:otherwise>
         </c:choose>
  </title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

  <h2><c:choose>
        <c:when test="${not empty usuario.id}">Editar Paciente</c:when>
        <c:otherwise>Novo Paciente</c:otherwise>
      </c:choose>
  </h2>

  <form action="${pageContext.request.contextPath}/admin/pacientes/salvar" method="post">
    <input type="hidden" name="id" value="${usuario.id}" />

    <label for="nome">Nome:</label><br/>
    <input id="nome"   name="nome"     value="${usuario.nome}"   required/><br/>

    <label for="email">E-mail:</label><br/>
    <input id="email"  name="email"    value="${usuario.email}"  required/><br/>

    <label for="cpf">CPF:</label><br/>
    <input id="cpf"    name="cpf"      value="${usuario.cpf}"    required/><br/>

    <label for="celular">Celular:</label><br/>
    <input id="celular" name="celular" value="${usuario.celular}" required/><br/>

    <label for="senha">Senha:</label><br/>
    <input id="senha"  name="senha"    value="${usuario.senha}"   required/><br/><br/>

    <button type="submit">Salvar</button>
    <a href="${pageContext.request.contextPath}/admin/pacientes">Cancelar</a>
  </form>

</body>
</html>
