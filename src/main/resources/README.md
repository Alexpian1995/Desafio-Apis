# 🧵 ForoHub - Sistema de Foros con Autenticación JWT

ForoHub es una API REST construida con Spring Boot que permite el registro, autenticación y gestión de usuarios utilizando JWT (JSON Web Token). Los datos se almacenan en una base de datos MySQL.

---

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot 3+
- Spring Security
- JWT (JSON Web Token)
- MySQL
- JPA / Hibernate
- Lombok
- Maven

---

## 🏁 Funcionalidades

- Registro de usuarios (`/register`)
- Login con autenticación JWT (`/login`)
- Protección de rutas privadas con token
- CRUD de tópicos (en desarrollo o implementado)
- Validación de credenciales

---

## 📂 Estructura del proyecto

```
src/
├── config/         # Configuración de seguridad y JWT
├── controller/     # Controladores REST
├── repositorio/    # Interfaces JPA
├── usuario/        # Modelo de entidad Usuario
├── ForoHubApplication.java
```

---

## 🔐 Seguridad

El sistema usa JWT para autenticación. Una vez que haces login, obtienes un token que debes enviar en las siguientes solicitudes usando el header:

```
Authorization: Bearer tu_token_aquí
```

---

## ⚙️ Configuración inicial

### 1. Clona el proyecto

```bash
git clone https://github.com/tuusuario/forohub.git
cd forohub
```

### 2. Configura tu base de datos MySQL

Crea la base de datos:

```sql
CREATE DATABASE forohub;
```

### 3. Configura `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/forohub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
jwt.secret=mi_clave_super_secreta
jwt.expiration=3600000
```

### 4. Ejecuta la aplicación

```bash
./mvnw spring-boot:run
```

---

## 🧪 Pruebas con Insomnia / Postman

### 📝 Registro

**POST** `http://localhost:8080/register`

```json
{
  "username": "admin",
  "password": "123456"
}
```

### 🔐 Login

**POST** `http://localhost:8080/login`

```json
{
  "username": "admin",
  "password": "123456"
}
```

Respuesta esperada:

```json
{
  "token": "eyJhbGciOiJIUzI1NiIs..."
}
```

### 🔒 Acceso a rutas protegidas

**GET** `http://localhost:8080/topicos`  
Con header:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiIs...
```

---

## 👨‍💻 Autor

Desarrollado por **Alexander Alzate**  
[LinkedIn](https://linkedin.com/in/tuusuario) • [GitHub](https://github.com/tuusuario)

---

## 📄 Licencia

MIT © 2025