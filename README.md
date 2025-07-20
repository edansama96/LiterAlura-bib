# 📚 LiterAlura

**LiterAlura** es una aplicación Java desarrollada con Spring Boot que permite buscar, registrar y consultar libros y autores utilizando la API pública de [Gutendex](https://gutendex.com/). El proyecto está diseñado con una arquitectura de capas clara y buenas prácticas de desarrollo, facilitando su mantenimiento y escalabilidad.

---

## 🏗️ Arquitectura de Capas

El proyecto sigue la **arquitectura de capas**, separando responsabilidades en:

- **Modelo (`model`)**: Entidades JPA como `Book`, `Author`, `Language`, y clases DTO/record para mapear datos externos (`DataBook`, `DataAuthor`, etc.).
- **Repositorio (`repository`)**: Interfaces que extienden `JpaRepository` para acceso a datos y consultas personalizadas.
- **Servicio (`service`)**: Clases para lógica de negocio, consumo de APIs externas y conversión de datos.
- **Capa de Presentación (`primal`)**: Clase principal (`Primal`) que gestiona la interacción con el usuario a través de un menú por consola.
- **Configuración y arranque**: `LiterAluraApplication` como punto de entrada, gestionando la inyección de dependencias y el ciclo de vida de la aplicación.

---

## 🚀 Funcionalidades principales

- **Buscar libros por título**: Consulta la API de Gutendex, muestra resultados y permite guardar libros y autores en la base de datos.
- **Listar libros registrados**: Muestra todos los libros almacenados en la base de datos.
- **Listar autores registrados**: Visualiza todos los autores guardados.
- **Listar autores vivos en un año específico**: Permite consultar qué autores estaban vivos en un año dado.
- **Listar libros por idioma**: Filtra y muestra libros según el idioma seleccionado (Español, Inglés, Alemán, Francés, Italiano, Portugués).

---

## 🛠️ Tecnologías utilizadas

- **Java 21+**
- **Spring Boot**
- **JPA/Hibernate**
- **PostgreSQL** (configurable en `application.properties`)
- **Consumo de API REST** (Gutendex)
- **Jackson** para mapeo de JSON

---

## ⚙️ Ejecución

1. Configura las variables de entorno para la conexión a la base de datos PostgreSQL (`DB_HOST`, `DB_NAME`, `DB_USER`, `DB_PASSWORD`).
2. Ejecuta la aplicación con:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Interactúa con el menú en consola para explorar todas las funcionalidades.

---

## 💡 ¿Por qué es interesante este proyecto?

- **Aprendizaje práctico** de arquitectura de capas en Java y Spring Boot.
- **Integración real** con una API pública de libros.
- **Persistencia de datos** con relaciones muchos-a-muchos (libros/autores).
- **Consultas avanzadas** (por idioma, por año de vida de autores).
- **Código limpio y extensible**, ideal para quienes buscan ejemplos claros de buenas prácticas en Java.

---

## 📂 Estructura del proyecto

```
src/
 └─ main/
     ├─ java/
     │   └─ com/bibliotec/LiterAlura_bib/literAlura/
     │       ├─ model/
     │       ├─ repository/
     │       ├─ service/
     │       └─ primal/
     └─ resources/
         └─ application.properties
```

---

¡Explora, aprende y contribuye a **LiterAlura**!
