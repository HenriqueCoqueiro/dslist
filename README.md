# 🎮 DSList

Backend em Java com Spring Boot para gerenciamento de listas personalizadas de jogos, com persistência via PostgreSQL, ambiente local com Docker Compose e deploy automatizado via Railway.

---

## 🛠️ Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA (Hibernate)
* Banco H2 (testes)
* PostgreSQL (produção)
* Maven
* Docker + Docker Compose
* Railway (deploy com CI/CD)

---

## 📌 Descrição

DSList é uma API REST que gerencia jogos e listas de jogos, permitindo operações como:

* Listar todos os jogos (com dados resumidos)
* Consultar detalhes completos de um jogo
* Listar todas as listas de jogos
* Consultar jogos de uma lista específica
* Reordenar jogos dentro de uma lista

A aplicação está configurada para rodar com PostgreSQL em produção e H2 para testes locais, usando Docker Compose para ambiente local. O deploy é feito automaticamente com CI/CD pela plataforma Railway.

---

## 📨 Endpoints da API

### `GET /games`

Retorna todos os jogos com dados mínimos.

**Exemplo de resposta:**

```json
[
  {
    "id": 1,
    "title": "The Witcher 3",
    "platforms": "PC, PS4, Xbox One"
  },
  {
    "id": 2,
    "title": "God of War",
    "platforms": "PS4"
  }
]
```

---

### `GET /games/{id}`

Retorna detalhes completos de um jogo específico.

**Parâmetros:**

* `id` (Long): ID do jogo

**Exemplo de resposta:**

```json
{
  "id": 1,
  "title": "The Witcher 3",
  "year": 2015,
  "genre": "RPG",
  "platforms": "PC, PS4, Xbox One",
  "score": 9.5,
  "imgUrl": "https://example.com/witcher3.jpg",
  "shortDescription": "RPG épico de mundo aberto.",
  "longDescription": "The Witcher 3: Wild Hunt é um jogo de RPG desenvolvido pela CD Projekt RED..."
}
```

---

### `GET /lists`

Retorna todas as listas de jogos.

**Exemplo de resposta:**

```json
[
  {
    "id": 1,
    "name": "Favoritos"
  },
  {
    "id": 2,
    "name": "Zerados"
  }
]
```

---

### `GET /lists/{listId}/games`

Retorna os jogos da lista especificada.

**Parâmetros:**

* `listId` (Long): ID da lista

**Exemplo de resposta:**

```json
[
  {
    "id": 1,
    "title": "God of War",
    "platforms": "PS4"
  },
  {
    "id": 5,
    "title": "Red Dead Redemption 2",
    "platforms": "PS4, Xbox One, PC"
  }
]
```

---

### `POST /lists/{listId}/replacement`

Reordena jogos dentro da lista.

**Parâmetros:**

* `listId` (Long): ID da lista

**Body JSON:**

```json
{
  "sourceIndex": 1,
  "destinationIndex": 3
}
```

Move o jogo da posição `sourceIndex` para `destinationIndex` dentro da lista.

**Resposta:**

* 204 No Content (sem corpo) em caso de sucesso.

---

## 🗂️ Estrutura de Dados

### Entidades principais

| Entidade     | Campos principais                                                                   |
| ------------ | ----------------------------------------------------------------------------------- |
| **Game**     | id, title, year, genre, platforms, score, imgUrl, shortDescription, longDescription |
| **GameList** | id, name                                                                            |

---

### Relacionamento


---

## 🌐 Deploy

O deploy é automatizado via CI/CD pela plataforma Railway. A cada push na branch principal (`main`), o projeto é redeployado automaticamente.

---
