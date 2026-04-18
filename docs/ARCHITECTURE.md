# Architecture du projet AnimeTracker

## 1. Contexte
AnimeTracker est un backend Spring Boot conçu pour servir de socle à une plateforme de suivi d'animes.
Le projet est volontairement découpé en deux univers :

- **Catalogue** : données stables et officielles sur les animes.
- **Watchlist** : données dynamiques liées à l'utilisateur, prévues pour une phase ultérieure.

Cette séparation permet d'anticiper une future évolution vers des services indépendants.

## 2. Objectifs d'architecture
L'architecture vise à respecter :

- **Single Responsibility Principle** : chaque classe a un rôle unique.
- **Open/Closed Principle** : extension sans modification massive.
- **Dependency Inversion Principle** : les dépendances sont injectées via abstractions.
- **Encapsulation** : les entités JPA restent internes au backend.
- **Testabilité** : la logique métier est isolée des détails de persistance.

## 3. Découpage des couches

### 3.1 Couche API
Responsable des échanges HTTP.

Rôle :
- recevoir les requêtes,
- valider les entrées,
- manipuler uniquement des DTOs,
- retourner des réponses HTTP adaptées.

Bonnes pratiques :
- pas d'accès direct à la base,
- pas d'entité JPA exposée,
- logique métier minimale.

### 3.2 Couche Service
Responsable de la logique métier.

Rôle :
- orchestrer les opérations,
- appliquer les règles métier,
- gérer les conversions entre entités et DTOs,
- centraliser la logique du catalogue.

### 3.3 Couche Data / Repository
Responsable de l'accès aux données.

Rôle :
- interroger H2 via Spring Data JPA,
- fournir les opérations CRUD,
- rester minimaliste.

### 3.4 Couche Entity
Responsable du modèle de persistance.

Rôle :
- représenter les données stockées,
- rester invisible à l'extérieur du service.

### 3.5 Couche DTO
Responsable des contrats d'échange.

Rôle :
- sécuriser l'API,
- stabiliser les payloads,
- découpler l'API du modèle JPA.

## 4. Packages attendus
Structure logique recommandée :

- `fr.miage.numres.catalog.controllers`
- `fr.miage.numres.catalog.services`
- `fr.miage.numres.catalog.repositories`
- `fr.miage.numres.catalog.entities`
- `fr.miage.numres.catalog.dtos`
- `fr.miage.numres.catalog.mappers`

## 5. Flux de traitement d'une requête
Exemple : création d'un anime.

1. Le client appelle l'API avec un DTO.
2. Le contrôleur valide la requête.
3. Le service convertit le DTO en entité.
4. Le repository sauvegarde l'entité.
5. Le service reconvertit l'entité en DTO.
6. Le contrôleur renvoie la réponse HTTP.

## 6. Swagger / OpenAPI
Springdoc expose automatiquement la documentation API.
Cela permet :

- de visualiser les endpoints,
- de tester les appels HTTP,
- de partager facilement l'API avec d'autres développeurs.

Endpoints utiles :
- `/swagger-ui.html`
- `/v3/api-docs`

## 7. Base de données
Le projet utilise H2 en mémoire.

Avantages :
- démarrage rapide,
- aucun service externe à installer,
- adapté au développement et au TP.

Limite :
- les données sont perdues au redémarrage.

## 8. Points de vigilance
Lors de la finalisation du projet, il faut vérifier :

- que Spring scanne bien les bons packages,
- que les entités JPA sont bien détectées,
- que les DTOs sont les seuls objets exposés par l'API,
- que les tests valident la couche service,
- que les logs de démarrage ne cachent pas d'erreurs de configuration.

## 9. Évolution future
Pour la suite du projet, on peut prévoir :

- la gestion de la watchlist,
- la séparation en modules ou microservices,
- des validations plus riches,
- des erreurs métier normalisées,
- une couverture de tests plus complète.
