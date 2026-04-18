# AnimeTracker - Catalogue Backend

Backend Spring Boot du projet **AnimeTracker**, centré sur le **catalogue d'animes**.
Ce module fournit une base de connaissance "froide" : informations officielles sur les animes, séparées de la future watchlist utilisateur.

## Contexte académique
Projet réalisé dans le cadre du **M2 MIAGE Numérique Responsable**.

## Repository de publication
Le projet doit être publié uniquement sur :

git@github.com:ElMouddenRiad/SpringBoot-SOLID-backend-feature-architecture-AnimeTracker-Catalogue.git

## English summary
This Spring Boot project focuses on the **AnimeTracker Catalogue Backend**.
It provides a clean backend for the catalog of anime titles, separated from the future user watchlist.

Main goals:
- strict layer separation,
- **SOLID** principles,
- encapsulation of JPA entities,
- API exposure through DTOs only.

## Objectif
Construire une architecture backend propre, testable et évolutive en respectant :
- la séparation stricte des couches,
- les principes **SOLID**,
- l'encapsulation des entités JPA,
- une exposition API uniquement via des DTOs.

## Objective
Build a clean, testable and evolutive backend while respecting:
- strict layer separation,
- **SOLID** principles,
- encapsulation of JPA entities,
- API exposure through DTOs only.

## Stack technique
- Java 25
- Spring Boot 4.0.2
- Spring Data JPA
- H2 en mémoire
- Spring Web MVC
- Springdoc OpenAPI / Swagger UI
- Lombok
- Gradle

## Technical stack
- Java 25
- Spring Boot 4.0.2
- Spring Data JPA
- H2 in-memory database
- Spring Web MVC
- Springdoc OpenAPI / Swagger UI
- Lombok
- Gradle

## Architecture cible
Le projet est organisé par **feature** autour du catalogue :

- **API / Controllers** : point d'entrée HTTP, manipulation de DTOs uniquement
- **Service** : logique métier, orchestration, conversion DTO ↔ entité
- **Repository** : accès aux données via Spring Data JPA
- **Entity** : modèle de persistance interne à la couche métier
- **DTOs** : contrats d'échange exposés à l'extérieur
- **Mapper** : conversion entre entités et DTOs

## Target architecture
The project is organized by **feature** around the catalogue:

- **API / Controllers**: HTTP entry point, DTO-only handling
- **Service**: business logic, orchestration, DTO ↔ entity conversion
- **Repository**: data access through Spring Data JPA
- **Entity**: internal persistence model
- **DTOs**: external data contracts
- **Mapper**: entity and DTO conversion

### Principe important
Aucune entité JPA ne doit être exposée directement par l'API.

### Important principle
No JPA entity should be exposed directly by the API.

## Fonctionnalités prévues du catalogue
- créer un anime
- récupérer la liste des animes
- récupérer un anime par identifiant
- exposer la documentation Swagger pour tester les endpoints

## Endpoints REST attendus
> Le préfixe retenu est `/api/animes`

- `GET /api/animes`
- `GET /api/animes/{id}`
- `POST /api/animes`

## Documentation interactive
Swagger UI est disponible via :

- `http://localhost:8080/swagger-ui.html`
- ou `http://localhost:8080/swagger-ui/index.html`

La spec OpenAPI est exposée sur :
- `http://localhost:8080/v3/api-docs`

## Base de données
Le projet utilise **H2 en mémoire**.

Console H2 :
- `http://localhost:8080/h2-console`

Paramètre JDBC utilisé dans la configuration actuelle :
- `jdbc:h2:mem:devDb`

## Lancement du projet
### Compilation
```bash
./gradlew.bat build
```

### Démarrage
```bash
./gradlew.bat bootRun
```

## Test rapide via Swagger
1. Démarrer l'application
2. Ouvrir Swagger UI
3. Tester un `POST /api/animes`
4. Relancer un `GET /api/animes`
5. Tester un `GET /api/animes/{id}`

### Exemple de payload de création
```json
{
  "title": "Attack on Titan",
  "synopsis": "Humanity fights giant creatures behind walls.",
  "studio": "Wit Studio",
  "episodes": 25,
  "genres": "Action,Drama,Fantasy"
}
```

## État actuel du projet
Le projet est encore **en phase d'itération**.

Points à finaliser / renforcer :
- stabiliser l'organisation des packages,
- compléter les contrôleurs et services,
- ajouter des tests unitaires et d'intégration,
- améliorer la documentation OpenAPI si nécessaire,
- préparer l'évolution vers la future watchlist.

## Valeur pédagogique
Ce projet illustre :
- l'injection de dépendances,
- la séparation des responsabilités,
- la construction d'un domaine métier simple mais évolutif,
- la mise à disposition d'une API testable avec Swagger.

## Licence
Projet académique réalisé dans le cadre d'un TP Spring Boot.
