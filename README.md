# API Service Scheduling

## Objetivo

Gerenciar um sistema de agendamentos, usuários e períodos bloqueados, permitindo controlar horários disponíveis, impedir agendamentos em períodos indisponíveis e organizar a agenda de forma centralizada.

## Contexto

Este projeto foi desenvolvido como parte do processo de aprendizado e prática com **Java e Spring Boot**, com foco em construção de APIs REST seguindo boas práticas, arquitetura em camadas e organização para portfólio.

---

## Tecnologias e Dependências

**Linguagem:** Java (JDK 21)

**Framework:** Spring Boot

**Gerenciador de Dependências:** Maven

### Principais Dependências

* Spring Web
* Spring Data JPA
* Spring Boot Starter Validation
* H2 Database (em memória)

---

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

* **JDK 21** – configurada corretamente no ambiente
* **Maven** – para gerenciamento de dependências
* **IDE** – recomendada: IntelliJ IDEA

---

## Instalação e Execução

### Clone o repositório

```bash
git clone https://github.com/Yara-Silva05/API-ServiceScheduling.git
```

### Abra o projeto na IDE

Importe o projeto na sua IDE (ex.: IntelliJ IDEA) e configure o uso da **JDK 21**.

### Baixe as dependências

O Maven irá baixar automaticamente todas as dependências necessárias ao abrir o projeto.

### Inicie o projeto

Pela IDE ou via terminal:

```bash
mvn spring-boot:run
```

---

## Acesso à Aplicação

* **API:** http://localhost:8080
* **Workspace Postman:** https://www.postman.com/yara-silvazion-6310043/workspace/projeto-api-service-scheduling/collection/51875077-4684535f-b3a0-49cb-b7b8-d41e495454dc?action=share&creator=51875077

---

## Acessando o Banco de Dados H2

Após iniciar a aplicação, acesse:

```
http://localhost:8080/h2-console
```

Utilize as seguintes configurações:

* **Driver Class:** org.h2.Driver
* **JDBC URL:** jdbc:h2:file:./banco
* **User Name:** admin
* **Password:** 1234

Clique em **Connect** para acessar o console do banco de dados.

---

## Estrutura do Projeto (Arquitetura em Camadas)

O projeto segue uma arquitetura em camadas, organizada da seguinte forma:

* **controllers**: Responsáveis por receber as requisições HTTP e expor os endpoints da API.
* **services**: Camada de regras de negócio e processamento da aplicação.
* **repositories**: Interfaces de acesso e persistência de dados (Spring Data JPA).
* **models**: Entidades que representam o domínio do sistema.
* **dtos**: Objetos de transferência de dados (requests e responses).
* **exceptions**: Exceções personalizadas e tratamento global de erros.

---

## Contribuição

Contribuições são bem-vindas!

* **Issues:** Utilize para sugerir melhorias ou reportar problemas
* **Pull Requests:** Envie contribuições para evolução do projeto

**Padrão de commits:**

* `feat:` nova funcionalidade
* `fix:` correção de bugs
* `wip:` trabalho em andamento

---

## Melhorias Futuras

* Implementação de envio de e-mails para notificações de agendamento utilizando Spring Boot Starter Mail.
* Implementação de testes unitários e de integração
* Adição de autenticação e autorização (Spring Security)
* Persistência com banco de dados relacional externo
* Documentação detalhada com JavaDoc
* Implementação do Swagger (SpringDoc OpenAPI) para documentação da API

---

## Contato

**Autora:** Yara Silva Alves

* GitHub: https://github.com/Yara-Silva05
* LinkedIn: https://linkedin.com/in/yara-silva-alves-dev
