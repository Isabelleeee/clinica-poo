<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <script src="${pageContext.request.contextPath}/js/script.js" defer></script>
    <title>Login / Cadastro</title>
</head>
<body>
    <section class="containerPai">
        <div class="card loginActive">
            <div class="esquerda">
                <div class="formLogin">
                    <h2>Fazer Login</h2>
                    <form method="post" action="${pageContext.request.contextPath}/loginAction">
                        <input type="email" name="email"
                               placeholder="E-mail" required />
                        <input type="password" name="senha"
                               placeholder="Senha" required />
                        <button type="submit">Entrar</button>
                    </form>
                </div>
                <div class="facaLogin">
                    <h2>Já tem<br/>uma conta?</h2>
                    <p>Faça login para acessar sua conta</p>
                    <button class="loginButton">Faça login</button>
                </div>
            </div>
            <div class="direita">
                <div class="formCadastro">
                    <h2>Criar Conta</h2>
                    <form method="post" action="${pageContext.request.contextPath}/admin/pacientes/salvar">
                        <!-- Se quiser real cadastro de pacientes, ajuste o action -->
                        <input type="text" name="nome"
                               placeholder="Nome" required>
                        <input type="email" name="email"
                               placeholder="E-mail" required>
                        <input type="password" name="senha"
                               placeholder="Senha" required>
                        <input type="password" name="confirmaSenha"
                               placeholder="Confirme a sua senha" required>
                        <button type="submit">Cadastrar</button>
                    </form>
                </div>
                <div class="facaCadastro">
                    <h2>Não tem<br/>uma conta?</h2>
                    <p>Crie uma conta para acessar nossos serviços</p>
                    <button class="cadastroButton">Cadastre-se</button>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
