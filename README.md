---

# 🎮 DSList

Backend developed in Java with Spring Boot for managing personalized game lists, using PostgreSQL for production persistence. The local environment is configured with Docker Compose to simplify development. Automated deployment is handled by a CI/CD pipeline implemented via Railway. This is a simple project focused on applying and consolidating practical knowledge in Docker, CI/CD, and backend development.

---

## 🛠️ Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA (Hibernate)
* H2 Database (for testing)
* PostgreSQL (production)
* Maven
* Docker + Docker Compose
* Railway (CI/CD deployment)

---

## 📌 Description

DSList is a REST API that manages games and game lists, allowing operations such as:

* List all games (with summary data)
* Retrieve full details of a specific game
* List all game lists
* Retrieve games from a specific list
* Reorder games within a list

The application is configured to run with PostgreSQL in production and H2 for local testing, using Docker Compose for the local environment. Deployment is automated with CI/CD via the Railway platform.

---

## 📨 API Endpoints

### `GET /games`

Returns all games with minimal data.

**Example response:**

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

Returns full details of a specific game.

**Parameters:**

* `id` (Long): Game ID

**Example response:**

```json
{
  "id": 1,
  "title": "The Witcher 3",
  "year": 2015,
  "genre": "RPG",
  "platforms": "PC, PS4, Xbox One",
  "score": 9.5,
  "imgUrl": "https://example.com/witcher3.jpg",
  "shortDescription": "Epic open-world RPG.",
  "longDescription": "The Witcher 3: Wild Hunt is an RPG developed by CD Projekt RED..."
}
```

---

### `GET /lists`

Returns all game lists.

**Example response:**

```json
[
  {
    "id": 1,
    "name": "Favorites"
  },
  {
    "id": 2,
    "name": "Completed"
  }
]
```

---

### `GET /lists/{listId}/games`

Returns the games of the specified list.

**Parameters:**

* `listId` (Long): List ID

**Example response:**

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

Reorders games within a list.

**Parameters:**

* `listId` (Long): List ID

**JSON Body:**

```json
{
  "sourceIndex": 1,
  "destinationIndex": 3
}
```

Moves the game from `sourceIndex` to `destinationIndex` within the list.

**Response:**

* 204 No Content on success.

---

## 🗂️ Data Structure

### Main Entities

| Entity       | Main Fields                                                                         |
| ------------ | ----------------------------------------------------------------------------------- |
| **Game**     | id, title, year, genre, platforms, score, imgUrl, shortDescription, longDescription |
| **GameList** | id, name                                                                            |

---

### Relationship

![Project Diagram](docs/dslist-model.png)

---

## 🌐 Deployment

Deployment is automated via CI/CD using the Railway platform. Every push to the main branch (`main`) triggers an automatic redeploy.

---
