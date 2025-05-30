<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Dashboard do Médico</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

    <!-- Menu de Navegação -->
    <div class="navbar">
        <ul class="nav-links">
            <li>
                <a href="${pageContext.request.contextPath}/logout" class="logout-link">
                    Logout
                </a>
            </li>
        </ul>
    </div>

    <!-- Conteúdo principal -->
    <div class="content">

        <div class="card">
            <h1>Bem-vindo, Dr. ${medicoNome}</h1>
            <p>Estas são suas próximas consultas agendadas:</p>
        </div>

        <div class="card">
            <h2>Próximas Consultas</h2>

            <c:choose>
                <c:when test="${empty consultas}">
                    <p>Você não tem consultas agendadas.</p>
                </c:when>
                <c:otherwise>
                    <table>
                        <thead>
                            <tr>
                                <th>Data e Hora</th>
                                <th>Paciente</th>
                                <th>Status</th>
                                <th>Prontuário</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="consulta" items="${consultas}">
                                <tr>
                                    <td>${consulta.dataHora}</td>
                                    <td>${consulta.nomePaciente}</td>
                                    <td>${consulta.status}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/prontuario?id=${consulta.id}">
                                            Ver
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>

        </div>

    </div>

</body>
</html>
