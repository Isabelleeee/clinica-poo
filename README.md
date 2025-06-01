# Clínica POO — Sistema de Agendamento de Consultas Médicas
Isabelle da Costa Lopes, Ana Luiza klaussen e Matheus Felipe Dantas 

Este projeto é uma aplicação web em Java (Servlets + JSP) para clínicas e consultórios, permitindo agendamento de consultas, visualização de histórico e gestão de pacientes/médicos.

## Estrutura

```
clinica/
├── pom.xml                            # Configuração Maven
├── src/
│   ├── main/
│   │   ├── java/com/mack/clinica/
│   │   │   ├── controller/            # Servlets
│   │   │   ├── model/                 # Entidades, DAOs
│   │   │   └── util/                  # Conexão com SQLite
│   │   └── webapp/
│   │       ├── css/                   # estilos (base.css, style.css)
│   │       ├── WEB-INF/
│   │       │   ├── db.db              # Banco SQLite
│   │       │   └── paciente/
│   │       │       └── meu_cadastro.jsp
│   │       ├── login.jsp
│   │       ├── paciente_dashboard.jsp
│   │       ├── agendar_consulta.jsp
│   │       └── admin_dashboard.jsp
```

## Pré-requisitos

* Java 17 ou superior
* Maven 3.6+
* SQLite (apenas para inspeção, o driver está embutido)
* Container Servlet (Jetty/Tomcat)

## Configuração & Execução

1. Clone o repositório:

   ```bash
   git clone https://github.com/SEU_USUARIO/clinica-poo.git
   cd clinica-poo
   ```

2. Compile e empacote com Maven:

   ```bash
   mvn clean package
   ```

   Isso gera `clinica.war` em `target/`.

3. Faça deploy no seu servidor (ex: arraste o WAR para a pasta `webapps/` do Tomcat ou configure no Jetty).

4. Certifique-se de que o arquivo `db.db` está em `src/main/webapp/WEB-INF/`.

5. Acesse no navegador:

   ```
   http://localhost:8080
   ```

## Usuários de Teste

| Nome          | E-mail                  | Senha    | Tipo     |
| ------------- | ----------------------  | -------- | -------- |
|James Brown    |james.brown@soul.com     |123       |paciente  |
|Ray Charles    |ray.charles@soul.com     |123       |paciente  |
|Administrador  |admin@mackenzie.br       |admin123  |admin     |
|João Silva     |joao.silva@clinica.com   |123       |medico    |
|Maria Souza    |maria.souza@clinica.com  |123       |medico    |
|Carlos Lima    |carlos.lima@clinica.com  |123       |medico    |

> **Obs:** ajuste credenciais no DB se necessário.

## Rotas Principais

* `/login` → Tela de login
* `/paciente_dashboard` → Dashboard do paciente
* `/agendarConsulta` → Formulário e ação de agendamento
* `/paciente/minha-agenda` → Histórico de consultas do paciente
* `/admin_dashboard` → Dashboard do admin com CRUD de usuários
