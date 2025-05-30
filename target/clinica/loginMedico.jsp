<!-- src/main/webapp/loginMedico.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8" />
  <title>Login Médico</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>
  <div class="card" style="max-width: 400px; margin: 50px auto;">
    <h2>Login do Médico</h2>
    <form action="${pageContext.request.contextPath}/medico_login" method="post">
      <label for="usuario">Usuário (e-mail ou CRM)</label>
      <input type="text" id="usuario" name="usuario" required />

      <label for="senha">Senha</label>
      <input type="password" id="senha" name="senha" required />

      <input type="submit" value="Entrar" class="button" />
    </form>
    <c:if test="${param.erro == 'aut'}">
      <p style="color: red; margin-top: 10px;">Você precisa se autenticar primeiro.</p>
    </c:if>
    <c:if test="${param.erro == 'cred'}">
      <p style="color: red; margin-top: 10px;">Usuário ou senha inválidos.</p>
    </c:if>
  </div>
</body>
</html>
