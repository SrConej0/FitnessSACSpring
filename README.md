# FitnessSACSpring

Aplicación web MVC con Spring Boot + Thymeleaf para la gestión de un gimnasio (usuarios, trainers, planes, reservas, asistencias, etc.). Se puede ejecutar de forma embebida (jar) o desplegar como WAR en Tomcat.

## Tecnologías
- Java 17+
- Spring Boot 3.5.x (Jakarta EE)
- Thymeleaf
- Spring Data JPA
- SQL Server
- Maven
- Tomcat 10.1+

## Requisitos
- JDK 17 o superior instalado.
- Maven Wrapper incluido (`mvnw.cmd` en Windows).
- Base de datos SQL Server accesible (local o remota).
- Para WAR: Tomcat 10.1.x o superior.

## Configuración
La configuración principal está en `src/main/resources/application.properties`.

Ejemplo por defecto:
```
spring.application.name=FitnessSACSpring
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=FitnessDB;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=sa
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
```

Puedes sobreescribir estas propiedades con variables de entorno al ejecutar:
- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `SPRING_DATASOURCE_DRIVER-CLASS-NAME`

## Ejecución local (server embebido)
1. Compila y arranca en puerto 8080:
   ```bash
   ./mvnw.cmd spring-boot:run
   ```
   - Si el puerto 8080 está ocupado, cambia el puerto:
     ```bash
     ./mvnw.cmd spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
     ```

2. También puedes empaquetar y ejecutar el WAR como jar embebido:
   ```bash
   ./mvnw.cmd clean package -DskipTests
   java -jar target/FitnessSACSpring-0.0.1-SNAPSHOT.war --server.port=8081
   ```

3. Accede en el navegador:
   - `http://localhost:8080/` (o el puerto que definas)

## Despliegue en Tomcat (WAR)
1. Empaqueta el proyecto:
   ```bash
   ./mvnw.cmd clean package -DskipTests
   ```
2. Copia el WAR a `TOMCAT_HOME/webapps/`.
3. Opcional: renómbralo a `FitnessSACSpring.war` para que el contexto sea `/FitnessSACSpring`.
4. Arranca Tomcat (`bin/startup.bat`) o desde tu IDE.
5. Accede:
   - `http://<host>:8080/FitnessSACSpring/`

> Nota: El contexto del WAR en Tomcat lo define el nombre del archivo. Si quieres que el embebido coincida con el contexto externo, puedes ejecutar con `--server.servlet.context-path=/FitnessSACSpring`.

## Rutas principales
- `GET /` → Página de inicio (template `index`).
- `GET /home/gestionUsuarios` → Gestión de usuarios.
- `GET /home/gestionTrainers` → Gestión de trainers.
- `GET /home/gestionSesiones` → Gestión de sesiones.
- `GET /home/gestionSanciones` → Gestión de sanciones.
- `GET /home/gestionRoles` → Gestión de roles.
- `GET /home/gestionReservas` → Gestión de reservas.
- `GET /home/gestionPlanes` → Gestión de planes.
- `GET /home/gestionMembresias` → Gestión de membresías.
- `GET /home/gestionLugares` → Gestión de lugares.
- `GET /home/gestionInformes` → Gestión de informes.
- `GET /home/gestionFaltas` → Gestión de faltas.
- `GET /home/gestionAsistencias` → Gestión de asistencias.
- `POST /login/validarUsuario` → Validación de credenciales (retorna `index` si falla y `principal` si éxito).

## Estructura del proyecto
```
src
├── main
│   ├── java
│   │   └── com.FitnessSACSpring
│   │       ├── FitnessSacSpringApplication.java
│   │       ├── ServletInitializer.java
│   │       └── controller
│   │           ├── IndexController.java
│   │           ├── HomeController.java
│   │           ├── LoginController.java
│   │           ├── PlanController.java
│   │           └── AsistenciaController.java
│   └── resources
│       ├── templates
│       │   ├── index.html
│       │   ├── principal.html
│       │   └── ... (templates de gestión)
│       └── application.properties
└── test
    └── java
```

## Problemas frecuentes
- 404 en el contexto raíz:
  - Asegúrate de que la app está desplegada y el WAR se llama como esperas (`FitnessSACSpring.war`).
  - El controlador `IndexController` mapea `GET /` y evita el 404.
- Puerto ocupado (8080):
  - Elige otro puerto con `--server.port=8081`.
- Java incompatible en Tomcat:
  - Usa JDK 17+ para el servidor Tomcat.
- Conexión a base de datos:
  - Verifica `SPRING_DATASOURCE_URL`, usuario y contraseña.
  - Si el servidor no tiene tu BD local, ajusta las credenciales.

## Desarrollo
- Compilar: `./mvnw.cmd clean package`
- Ejecutar tests: `./mvnw.cmd test`
- Formato y estilo: seguir convenciones de Spring y JavaDoc añadidos en controladores y clases de arranque.

## Contribuciones
Las contribuciones son bienvenidas. Por favor, abre un issue o PR con una descripción clara del problema o mejora.