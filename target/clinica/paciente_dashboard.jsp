<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Painel do Paciente</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

    <!-- Menu de Navegação -->
    <div class="navbar">
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/paciente_dashboard">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/agendarConsulta">Agendamento de Consultas</a></li>
            <li><a href="${pageContext.request.contextPath}/paciente/minha-agenda">Minha Agenda</a></li>
            <li><a href="${pageContext.request.contextPath}/paciente/meu-cadastro">Meu Cadastro</a></li>
            <li><a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a></li>
        </ul>
    </div>

    <!-- Conteúdo principal -->
    <div class="content">
        <h1>Painel do Paciente</h1>
        <p>Bem-vindo ao seu painel, onde você poderá visualizar informações e agendar consultas.</p>
    </div>

</body>
</html>
