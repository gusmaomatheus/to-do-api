# 📄 TO DO API

Este é um projeto simples para estudar a criação de API's REST em clojure.

## 🚀 Tecnologias Utilizadas

- **Clojure (JDK 17 + Leiningen)**
- **Reitit**
- **Ring**
- **Jetty**
- **Next JDBC**
- **PostgreSQL**

___

## 📌 Objetivo do Projeto

Inserir e recuperar dados de uma tabela de um banco de dados para representar 'tarefas' de uma lista de afazeres.

> ℹ️ *Este projeto foi desenvolvido com o intuito de estudar mais a fundo sobre a linguagem clojure e como podemos estruturar um projeto nela. A complexidade não reflete um sistema real, o intuito era ter um primeiro contato com algumas bibliotecas comuns na criação de API's em clojure.*

___

___

## 🛠️ Como Executar

Para executar o projeto é necessário ter docker instalado.

1. Clone o repositório:
   ```sh
   git clone git@github.com:gusmaomatheus/to-do-api.git
   cd to-do-api
   ```

2. Compile e execute o projeto com Maven:
   ```sh
   docker compose up --build
   ```
___
     
___

## 📫 Endpoints Principais

A API segue os princípios REST e expõe os seguintes endpoints:

- `POST api/task` — Insere uma nova tarefa.
- `GET api/task` — Recupera todas as tarefas salvas no banco.


#### 📄 JSON's de exemplo para as requisições:

- `POST api/task`
  ```json
  {
    "title": "teste",
    "description": "teste",
    "priority": "low" // opcional (deve ser low, medium ou high)
  }
  ```
___

## 📝 Licença
Este projeto tem finalidade educacional e não possui licença de uso específica.
