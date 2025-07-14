# 🛒 E-Commerce Spring Boot Project

**Progetto personale Java / Spring Boot** per la gestione di un sistema di e-commerce.  
Sviluppato con attenzione a **struttura, sicurezza, testing e buone pratiche** da Junior Java Developer.
Obiettivo del progetto è quello di approfondire e consolidare le conoscenze riguardanti Java-Spring Boot

---

## 🚀 Tecnologie e strumenti usati

- **Java 17**
- **Spring Boot 3.5.3**
  - Spring Web (MVC, REST API)
  - Spring Security (con filtro custom)
  - Spring Data JPA
- **MySQL** come database relazionale
- **Hibernate** per l’ORM
- **Lombok** per ridurre il boilerplate
- **Validation** (`@Valid`, `@NotNull`, ecc.)
- **Gestione Errori avanzato** (`@ControllerAdvice`)
- **Swagger / OpenAPI (Springdoc)** per la documentazione REST
- **JUnit + MockMvc** per testing
- **JaCoCo** per la code coverage 

---

## 📦 Funzionalità implementate

- 🔐 **Login autenticato** via header con filtro custom (`username` / `password`)
- 👤 **Gestione utenti e ruoli** (`ADMIN`, `UTENTE`)
- 🛍️ **Gestione prodotti**
  - Inserimento / eliminazione (solo ADMIN)
  - Visualizzazione (autenticati)
- 💥 **Gestione eccezioni centralizzata** 
- 📜 **DTO** per separare i dati da esporre da quelli interni
- 🔍 **Validazione input** con messaggi di errore chiari
- 🧪 **Testing unitari e integrazione** (con MockMvc e validazione status)
- 📈 **JaCoCo coverage** generata via `mvn clean verify`


📌 TODO
Aggiungere Security con JWT 
Log strutturato con SLF4J + Logback
Frontend (React, Thymeleaf o simili)


🧑‍💻 Autore
Daniel Schiano di Zenise – Junior Java Developer
📧 zenise.1996@gmail.com