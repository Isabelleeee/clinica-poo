<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Painel do Administrador</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

    <!-- Menu de Navegação -->
    <div class="navbar">
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/admin_dashboard">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/pacientes">Cadastro de Pacientes</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/medicos">Cadastro de Médicos</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/consultas">Consultar Agenda</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/prontuarios">Ficha Clínica</a></li>
            <li><a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a></li>
        </ul>
    </div>

    <!-- Conteúdo principal -->
    <div class="content">
        <h1>Painel do Administrador</h1>
        <p>Bem-vindo ao painel administrativo. Aqui você poderá gerenciar pacientes e consultas.</p>
    </div>

</body>
</html>
