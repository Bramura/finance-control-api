# Finance Control API

API REST para controle financeiro pessoal desenvolvida com Java e Spring Boot.

O projeto permite o gerenciamento de receitas e despesas, oferecendo operações completas de CRUD, filtros por categoria e tipo, cálculo de saldo financeiro e geração de resumo financeiro consolidado.

## Tecnologias Utilizadas

* Java 21
* Spring Boot 3
* Spring Data JPA
* Hibernate
* H2 Database
* Maven
* Swagger / OpenAPI
* Jakarta Validation

## Arquitetura

O projeto foi desenvolvido seguindo a arquitetura em camadas:

* Controller → Recebe as requisições HTTP
* Service → Contém as regras de negócio
* Repository → Acesso aos dados
* DTO → Transferência de dados
* Exception Handler → Tratamento global de erros

## Funcionalidades

### CRUD de Transações

* Cadastrar transação
* Listar transações
* Buscar transação por ID
* Atualizar transação
* Excluir transação

### Filtros

* Buscar por categoria
* Buscar por tipo (receita ou despesa)

### Indicadores Financeiros

* Cálculo de saldo
* Resumo financeiro consolidado

### Validações

* Descrição obrigatória
* Valor obrigatório
* Categoria obrigatória
* Tipo obrigatório

### Tratamento de Erros

* Validação de campos
* Recursos não encontrados (404)
* Respostas padronizadas para a API

## Estrutura do Projeto

src/main/java/com/bramura/controlefinanceiroapi

├── controller

├── dto

├── exception

├── model

├── repository

├── service

└── ControlefinanceiroapiApplication

## Endpoints

### Transações

| Método | Endpoint         |
| ------ | ---------------- |
| GET    | /transacoes/     |
| GET    | /transacoes/{id} |
| POST   | /transacoes/     |
| PUT    | /transacoes/{id} |
| DELETE | /transacoes/{id} |

### Filtros

| Método | Endpoint                          |
| ------ | --------------------------------- |
| GET    | /transacoes/categoria/{categoria} |
| GET    | /transacoes/tipo/{tipo}           |

### Indicadores

| Método | Endpoint           |
| ------ | ------------------ |
| GET    | /transacoes/saldo  |
| GET    | /transacoes/resumo |

## Exemplo de Cadastro

POST /transacoes/

```json
{
  "descricao": "Salário",
  "valor": 3500.00,
  "categoria": "Trabalho",
  "tipo": "receita"
}
```

## Exemplo de Saldo

GET /transacoes/saldo

```json
{
  "mensagem": "Saldo calculado com sucesso",
  "dados": {
    "totalReceitas": 3500.0,
    "totalDespesas": 350.0,
    "saldo": 3150.0
  }
}
```

## Exemplo de Resumo

GET /transacoes/resumo

```json
{
  "mensagem": "Resumo calculado com sucesso",
  "dados": {
    "quantidadeReceitas": 1,
    "quantidadeDespesas": 1,
    "totalReceitas": 3500.0,
    "totalDespesas": 350.0,
    "saldo": 3150.0
  }
}
```

## Como Executar

Clone o repositório:

```bash
git clone https://github.com/seu-usuario/finance-control-api.git
```

Entre na pasta:

```bash
cd finance-control-api
```

Execute:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:

```text
http://localhost:8080
```

## Documentação Swagger

Após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui.html
```

ou

```text
http://localhost:8080/swagger-ui/index.html
```

## Objetivo do Projeto

Este projeto foi desenvolvido para consolidar conhecimentos em:

* APIs REST
* Spring Boot
* Spring Data JPA
* Boas práticas de arquitetura
* DTOs
* Validações
* Tratamento de exceções
* Organização de projetos backend

## Autor

Brayan Miyamura

Estudante de Análise e Desenvolvimento de Sistemas com foco em desenvolvimento backend utilizando Java, Spring Boot e Python.
