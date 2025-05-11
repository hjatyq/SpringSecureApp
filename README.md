# Demo All-in-One Spring MVC + Thymeleaf + Spring Security

Ce projet est une démonstration d'une application web construite avec **Spring Boot**, intégrant les technologies suivantes :

- Spring MVC (Web)
- Spring Security (authentification, autorisation)
- Thymeleaf (moteur de templates)
- Bootstrap 5 (design responsive)
- In-Memory Authentication

## 📦 Fonctionnalités

- Authentification des utilisateurs via Spring Security
- Gestion des rôles : `USER`, `ADMIN`
- Protection des URLs (`/user/**`, `/admin/**`)
- Navigation dynamique avec Thymeleaf
- Dropdown Bootstrap pour le menu utilisateur
- Déconnexion avec redirection

## 🧑‍💻 Utilisateurs définis

Les utilisateurs sont stockés en mémoire (`InMemoryUserDetailsManager`) :

| Nom d'utilisateur | Mot de passe | Rôles        |
|-------------------|--------------|--------------|
| user1             | 1234         | ROLE_USER    |
| user2             | 1234         | ROLE_USER    |
| admin             | 1234         | ROLE_ADMIN + ROLE_USER |

> Les mots de passe sont encodés avec **BCrypt**.

## ▶️ Lancer le projet

### Prérequis

- Java 17+
- Maven ou IDE compatible (IntelliJ, Eclipse...)

### Exécution

```bash
# Compilation du projet
mvn clean install

# Lancement de l'application
mvn spring-boot:run
