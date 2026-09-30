# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/fintech/transactions/infrastructure/security/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/fintech/transactions/infrastructure/security/JwtAuthenticationFilter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/fintech/transactions/infrastructure/security/JwtTokenUtil.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/fintech/transactions/infrastructure/security/AuthEntryPointJwt.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/fintech/transactions/infrastructure/security/JwtTokenUtilTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/fintech/transactions/infrastructure/security/AuthEntryPointJwt.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/fintech/transactions/infrastructure/adapter/JpaTransactionRepository.java` — `Transaction.id`: Se invoca `id` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/adapter/JpaTransactionRepository.java` — `Transaction.accountId`: Se invoca `accountId` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/adapter/JpaTransactionRepository.java` — `Transaction.amount`: Se invoca `amount` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/adapter/JpaTransactionRepository.java` — `Transaction.currency`: Se invoca `currency` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/adapter/JpaTransactionRepository.java` — `Transaction.type`: Se invoca `type` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/adapter/JpaTransactionRepository.java` — `Transaction.timestamp`: Se invoca `timestamp` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/adapter/JpaTransactionRepository.java` — `Transaction.description`: Se invoca `description` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/adapter/JpaTransactionRepository.java` — `Transaction.status`: Se invoca `status` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/application/TransactionService.java` — `Transaction.status`: Se invoca `status` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `Transaction.id`: Se invoca `id` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `Transaction.accountId`: Se invoca `accountId` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `Transaction.amount`: Se invoca `amount` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `Transaction.currency`: Se invoca `currency` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `Transaction.type`: Se invoca `type` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `Transaction.timestamp`: Se invoca `timestamp` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `Transaction.description`: Se invoca `description` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `Transaction.status`: Se invoca `status` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `ProcessTransactionRequest.accountId`: Se invoca `accountId` sobre `ProcessTransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `ProcessTransactionRequest.amount`: Se invoca `amount` sobre `ProcessTransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `ProcessTransactionRequest.currency`: Se invoca `currency` sobre `ProcessTransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `ProcessTransactionRequest.type`: Se invoca `type` sobre `ProcessTransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `ProcessTransactionRequest.description`: Se invoca `description` sobre `ProcessTransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `ProcessTransactionRequest.status`: Se invoca `status` sobre `ProcessTransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java` — `ProcessTransactionRequest.reason`: Se invoca `reason` sobre `ProcessTransactionRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/application/TransactionServiceTest.java` — `Transaction.accountId`: Se invoca `accountId` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/application/TransactionServiceTest.java` — `Transaction.amount`: Se invoca `amount` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/application/TransactionServiceTest.java` — `Transaction.currency`: Se invoca `currency` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/application/TransactionServiceTest.java` — `Transaction.type`: Se invoca `type` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/application/TransactionServiceTest.java` — `Transaction.id`: Se invoca `id` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/application/TransactionServiceTest.java` — `Transaction.get`: Se invoca `get` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/application/TransactionServiceTest.java` — `TransactionService.getTransactionsByAccountIdAndDateRange`: Se invoca `getTransactionsByAccountIdAndDateRange` sobre `TransactionService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/application/TransactionServiceTest.java` — `Transaction.timestamp`: Se invoca `timestamp` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/application/TransactionServiceTest.java` — `Transaction.description`: Se invoca `description` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/application/TransactionServiceTest.java` — `Transaction.status`: Se invoca `status` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/infrastructure/controller/TransactionControllerTest.java` — `Transaction.id`: Se invoca `id` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/infrastructure/controller/TransactionControllerTest.java` — `Transaction.accountId`: Se invoca `accountId` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/infrastructure/controller/TransactionControllerTest.java` — `Transaction.amount`: Se invoca `amount` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/infrastructure/controller/TransactionControllerTest.java` — `Transaction.currency`: Se invoca `currency` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/infrastructure/controller/TransactionControllerTest.java` — `Transaction.type`: Se invoca `type` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/infrastructure/controller/TransactionControllerTest.java` — `Transaction.timestamp`: Se invoca `timestamp` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/fintech/transactions/infrastructure/controller/TransactionControllerTest.java` — `Transaction.description`: Se invoca `description` sobre `Transaction`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced

### Brecha de conocimiento
Experto en el marco de trabajo (framework) mas relevante en su lenguaje de programación principal, lo que le permite escribir código más legible y reducir la redundancia. Ha implementado al menos dos mecanismos de autenticación e identifica el uso de un JWT

### Misión / candidato
Candidato con experiencia en desarrollo backend con Java, enfocado en mejorar seguridad y legibilidad de código.

### Reto
- Tema: Especialista en Framework con Proficiencia en Seguridad y Legibilidad de Código
- Seniority: advanced-l2
- Tipo: practical
- Título: Mejora de Seguridad y Legibilidad en Desarrollo Backend con Java
- Tiempo estimado: 2 semanas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Análisis de Requisitos y Revisión de Código — objetivo: Identificar áreas de mejora en la seguridad y legibilidad del código existente. — entregable (NO resolver): Documento de análisis con propuestas de mejora.
- Fase 2: Implementación de Mecanismos de Autenticación — objetivo: Implementar y mejorar mecanismos de autenticación utilizando JWT. — entregable (NO resolver): Mecanismo de autenticación implementado y probado.
- Fase 3: Refactorización y Optimización del Código — objetivo: Refactorizar el código para mejorar la legibilidad y reducir la redundancia. — entregable (NO resolver): Código refactorizado y optimizado.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.fintech</groupId>
    <artifactId>transactions</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>transactions</name>
    <description>Sistema de gestión de transacciones financieras con seguridad JWT</description>

    <properties>
        <java.version>21</java.version>
        <jjwt.version>0.12.5</jjwt.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <!-- JWT -->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>${jjwt.version}</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>${jjwt.version}</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>${jjwt.version}</version>
            <scope>runtime</scope>
        </dependency>

        <!-- PostgreSQL -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/fintech/transactions/TransactionsApplication.java ===
package com.fintech.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TransactionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionsApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
server:
  port: 8080
  servlet:
    context-path: /api

spring:
  application:
    name: transactions-service
  datasource:
    url: jdbc:postgresql://localhost:5432/fintech_transactions
    username: fintech_user
    password: secure_password_123
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 10
      connection-timeout: 30000
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
  security:
    jwt:
      secret: 7A24432646294A404E635266556A586E3272357538782F413F4428472B4B6250
      expiration-ms: 86400000
      refresh-expiration-ms: 172800000

logging:
  level:
    root: INFO
    com.fintech.transactions: DEBUG
    org.springframework.security: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE

// === ARCHIVO: src/main/java/com/fintech/transactions/domain/model/Transaction.java ===
package com.fintech.transactions.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Transaction(
        UUID id,
        UUID accountId,
        BigDecimal amount,
        String currency,
        TransactionType type,
        LocalDateTime timestamp,
        String description,
        TransactionStatus status) {

    public enum TransactionType {
        DEPOSIT, WITHDRAWAL, TRANSFER, PAYMENT
    }

    public enum TransactionStatus {
        PENDING, COMPLETED, FAILED, REVERSED
    }

    public Transaction {
        if (id == null) {
            throw new IllegalArgumentException("Transaction ID cannot be null");
        }
        if (accountId == null) {
            throw new IllegalArgumentException("Account ID cannot be null");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (currency == null || currency.length() != 3) {
            throw new IllegalArgumentException("Currency must be a 3-letter code");
        }
        if (type == null) {
            throw new IllegalArgumentException("Transaction type cannot be null");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        if (status == null) {
            throw new IllegalArgumentException("Transaction status cannot be null");
        }
    }

    public Transaction withStatus(TransactionStatus newStatus) {
        return new Transaction(this.id, this.accountId, this.amount, this.currency, 
                this.type, this.timestamp, this.description, newStatus);
    }
}

// === ARCHIVO: src/main/java/com/fintech/transactions/domain/port/TransactionRepository.java ===
package com.fintech.transactions.domain.port;

import com.fintech.transactions.domain.model.Transaction;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository {
    Transaction save(Transaction transaction);
    
    Optional<Transaction> findById(UUID id);
    
    List<Transaction> findByAccountId(UUID accountId);
    
    List<Transaction> findByAccountIdAndDateRange(UUID accountId, LocalDateTime start, LocalDateTime end);
    
    List<Transaction> findAll();
}

// === ARCHIVO: src/main/java/com/fintech/transactions/infrastructure/adapter/JpaTransactionRepository.java ===
package com.fintech.transactions.infrastructure.adapter;



import com.fintech.transactions.domain.model.TransactionStatus;
import com.fintech.transactions.domain.model.TransactionType;
import com.fintech.transactions.domain.model.Transaction;
import com.fintech.transactions.domain.port.TransactionRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public interface JpaTransactionRepository extends JpaRepository<TransactionEntity, UUID>, TransactionRepository {
    
    @Override
    default Transaction save(Transaction transaction) {
        TransactionEntity entity = TransactionEntity.fromDomain(transaction);
        TransactionEntity savedEntity = save(entity);
        return savedEntity.toDomain();
    }
    
    @Override
    default Optional<Transaction> findById(UUID id) {
        return findById(id).map(TransactionEntity::toDomain);
    }
    
    @Override
    default List<Transaction> findByAccountId(UUID accountId) {
        return findByAccountId(accountId).stream()
                .map(TransactionEntity::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    default List<Transaction> findByAccountIdAndDateRange(UUID accountId, LocalDateTime start, LocalDateTime end) {
        return findByAccountIdAndTimestampBetween(accountId, start, end).stream()
                .map(TransactionEntity::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    default List<Transaction> findAll() {
        return findAll().stream()
                .map(TransactionEntity::toDomain)
                .collect(Collectors.toList());
    }
    
    List<TransactionEntity> findByAccountId(UUID accountId);
    
    List<TransactionEntity> findByAccountIdAndTimestampBetween(UUID accountId, LocalDateTime start, LocalDateTime end);
}

@Entity
@Table(name = "transactions")
class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(nullable = false)
    private UUID accountId;
    
    @Column(nullable = false)
    private BigDecimal amount;
    
    @Column(nullable = false, length = 3)
    private String currency;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Transaction.TransactionType type;
    
    @Column(nullable = false)
    private LocalDateTime timestamp;
    
    @Column(length = 255)
    private String description;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Transaction.TransactionStatus status;

    public TransactionEntity() {
    }

    public static TransactionEntity fromDomain(Transaction transaction) {
        TransactionEntity entity = new TransactionEntity();
        entity.setId(transaction.id());
        entity.setAccountId(transaction.accountId());
        entity.setAmount(transaction.amount());
        entity.setCurrency(transaction.currency());
        entity.setType(transaction.type());
        entity.setTimestamp(transaction.timestamp());
        entity.setDescription(transaction.description());
        entity.setStatus(transaction.status());
        return entity;
    }

    public Transaction toDomain() {
        return new Transaction(
                this.id,
                this.accountId,
                this.amount,
                this.currency,
                this.type,
                this.timestamp,
                this.description,
                this.status
        );
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Transaction.TransactionType getType() {
        return type;
    }

    public void setType(Transaction.TransactionType type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transaction.TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(Transaction.TransactionStatus status) {
        this.status = status;
    }
}

// === ARCHIVO: src/main/java/com/fintech/transactions/application/TransactionService.java ===
package com.fintech.transactions.application;

import com.fintech.transactions.domain.model.Transaction;
import com.fintech.transactions.domain.model.Transaction.TransactionStatus;
import com.fintech.transactions.domain.model.Transaction.TransactionType;
import com.fintech.transactions.domain.port.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(UUID accountId, BigDecimal amount, String currency,
            TransactionType type, String description) {
        if (accountId == null) {
            throw new IllegalArgumentException("El ID de cuenta no puede ser nulo");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("La moneda no puede estar vacía");
        }
        if (type == null) {
            throw new IllegalArgumentException("El tipo de transacción no puede ser nulo");
        }

        Transaction transaction = new Transaction(
            UUID.randomUUID(),
            accountId,
            amount,
            currency.toUpperCase(),
            type,
            LocalDateTime.now(),
            description,
            TransactionStatus.PENDING
        );

        return transactionRepository.save(transaction);
    }

    @Transactional(readOnly = true)
    public Optional<Transaction> getTransactionById(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de transacción no puede ser nulo");
        }
        return transactionRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Transaction> getTransactionsByAccountId(UUID accountId) {
        if (accountId == null) {
            throw new IllegalArgumentException("El ID de cuenta no puede ser nulo");
        }
        return transactionRepository.findByAccountId(accountId);
    }

    @Transactional(readOnly = true)
    public List<Transaction> getTransactionsByDateRange(UUID accountId, LocalDateTime startDate,
            LocalDateTime endDate) {
        if (accountId == null) {
            throw new IllegalArgumentException("El ID de cuenta no puede ser nulo");
        }
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Las fechas de rango no pueden ser nulas");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        return transactionRepository.findByAccountIdAndDateRange(accountId, startDate, endDate);
    }

    @Transactional(readOnly = true)
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction updateTransactionStatus(UUID id, TransactionStatus newStatus) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de transacción no puede ser nulo");
        }
        if (newStatus == null) {
            throw new IllegalArgumentException("El nuevo estado no puede ser nulo");
        }

        Transaction transaction = transactionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Transacción no encontrada: " + id));

        Transaction updatedTransaction = transaction.withStatus(newStatus);
        return transactionRepository.save(updatedTransaction);
    }

    public Transaction processTransaction(UUID id) {
        Transaction transaction = transactionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Transacción no encontrada: " + id));

        if (transaction.status() != TransactionStatus.PENDING) {
            throw new IllegalStateException("Solo se pueden procesar transacciones en estado PENDING");
        }

        Transaction processedTransaction = transaction.withStatus(TransactionStatus.COMPLETED);
        return transactionRepository.save(processedTransaction);
    }

    public Transaction rejectTransaction(UUID id, String reason) {
        Transaction transaction = transactionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Transacción no encontrada: " + id));

        if (transaction.status() != TransactionStatus.PENDING) {
            throw new IllegalStateException("Solo se pueden rechazar transacciones en estado PENDING");
        }

        String rejectionDescription = reason != null ? 
            "Rechazada: " + reason : "Rechazada sin motivo especificado";
        Transaction rejectedTransaction = transaction.withStatus(TransactionStatus.REJECTED);
        return transactionRepository.save(rejectedTransaction);
    }

    @Transactional(readOnly = true)
    public BigDecimal calculateTotalAmountByAccount(UUID accountId, TransactionType type) {
        List<Transaction> transactions = transactionRepository.findByAccountId(accountId);
        
        return transactions.stream()
            .filter(t -> type == null || t.type() == type)
            .filter(t -> t.status() == TransactionStatus.COMPLETED)
            .map(Transaction::amount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

// === ARCHIVO: src/main/java/com/fintech/transactions/infrastructure/controller/TransactionController.java ===
package com.fintech.transactions.infrastructure.controller;

import com.fintech.transactions.application.TransactionService;
import com.fintech.transactions.domain.model.Transaction;
import com.fintech.transactions.domain.model.Transaction.TransactionStatus;
import com.fintech.transactions.domain.model.Transaction.TransactionType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public record CreateTransactionRequest(
        @NotNull(message = "El ID de cuenta es obligatorio") UUID accountId,
        @NotNull(message = "El monto es obligatorio") @Positive(message = "El monto debe ser mayor que cero") BigDecimal amount,
        @NotBlank(message = "La moneda es obligatoria") String currency,
        @NotNull(message = "El tipo de transacción es obligatorio") TransactionType type,
        String description
    ) {}

    public record UpdateStatusRequest(
        @NotNull(message = "El nuevo estado es obligatorio") TransactionStatus status
    ) {}

    public record ProcessTransactionRequest(
        String reason
    ) {}

    public record TransactionResponse(
        UUID id,
        UUID accountId,
        BigDecimal amount,
        String currency,
        TransactionType type,
        LocalDateTime timestamp,
        String description,
        TransactionStatus status
    ) {
        public static TransactionResponse fromDomain(Transaction transaction) {
            return new TransactionResponse(
                transaction.id(),
                transaction.accountId(),
                transaction.amount(),
                transaction.currency(),
                transaction.type(),
                transaction.timestamp(),
                transaction.description(),
                transaction.status()
            );
        }
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(
            @Valid @RequestBody CreateTransactionRequest request) {
        Transaction transaction = transactionService.createTransaction(
            request.accountId(),
            request.amount(),
            request.currency(),
            request.type(),
            request.description()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(TransactionResponse.fromDomain(transaction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable UUID id) {
        return transactionService.getTransactionById(id)
            .map(transaction -> ResponseEntity.ok(TransactionResponse.fromDomain(transaction)))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionResponse>> getTransactionsByAccountId(
            @PathVariable UUID accountId) {
        List<TransactionResponse> transactions = transactionService.getTransactionsByAccountId(accountId)
            .stream()
            .map(TransactionResponse::fromDomain)
            .toList();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/account/{accountId}/range")
    public ResponseEntity<List<TransactionResponse>> getTransactionsByDateRange(
            @PathVariable UUID accountId,
            @RequestParam @NotNull LocalDateTime startDate,
            @RequestParam @NotNull LocalDateTime endDate) {
        List<TransactionResponse> transactions = transactionService
            .getTransactionsByDateRange(accountId, startDate, endDate)
            .stream()
            .map(TransactionResponse::fromDomain)
            .toList();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> getAllTransactions() {
        List<TransactionResponse> transactions = transactionService.getAllTransactions()
            .stream()
            .map(TransactionResponse::fromDomain)
            .toList();
        return ResponseEntity.ok(transactions);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TransactionResponse> updateTransactionStatus(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateStatusRequest request) {
        Transaction transaction = transactionService.updateTransactionStatus(id, request.status());
        return ResponseEntity.ok(TransactionResponse.fromDomain(transaction));
    }

    @PostMapping("/{id}/process")
    public ResponseEntity<TransactionResponse> processTransaction(@PathVariable UUID id) {
        Transaction transaction = transactionService.processTransaction(id);
        return ResponseEntity.ok(TransactionResponse.fromDomain(transaction));
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<TransactionResponse> rejectTransaction(
            @PathVariable UUID id,
            @RequestBody ProcessTransactionRequest request) {
        Transaction transaction = transactionService.rejectTransaction(id, request.reason());
        return ResponseEntity.ok(TransactionResponse.fromDomain(transaction));
    }

    @GetMapping("/account/{accountId}/total")
    public ResponseEntity<Map<String, BigDecimal>> calculateTotalAmount(
            @PathVariable UUID accountId,
            @RequestParam(required = false) TransactionType type) {
        BigDecimal total = transactionService.calculateTotalAmountByAccount(accountId, type);
        return ResponseEntity.ok(Map.of("total", total));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest()
            .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, String>> handleIllegalState(IllegalStateException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(Map.of("error", ex.getMessage()));
    }
}

// === ARCHIVO: src/main/java/com/fintech/transactions/infrastructure/security/SecurityConfig.java ===
package com.fintech.transactions.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers("/api/v1/transactions/**").authenticated()
                .anyRequest().authenticated()
            );
        
        return http.build();
    }
}

// === ARCHIVO: src/main/java/com/fintech/transactions/infrastructure/security/JwtAuthenticationFilter.java ===
package com.fintech.transactions.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filtro de autenticación JWT para validar tokens en las solicitudes entrantes.
 * Este filtro intercepta cada request y valida el token JWT presente en el header Authorization.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Extraer el token JWT del header Authorization
        String jwt = parseJwt(request);

        // Validar el token y establecer la autenticación en el contexto de seguridad
        if (jwt != null && jwtTokenUtil.validateToken(jwt)) {
            String username = jwtTokenUtil.getUsernameFromToken(jwt);

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
    }
}

// === ARCHIVO: src/main/java/com/fintech/transactions/infrastructure/security/JwtTokenUtil.java ===
package com.fintech.transactions.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Utilidad para generar, validar y extraer información de tokens JWT.
 * Provee métodos para crear tokens, validar su integridad y extraer claims.
 */
@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * Extrae el nombre de usuario del token JWT.
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * Extrae la fecha de expiración del token JWT.
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * Extrae un claim específico del token usando un resolver de claims.
     */
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extrae todos los claims del token.
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Genera la clave de firma usada para firmar y verificar tokens.
     */
    private SecretKey getSigningKey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Verifica si el token ha expirado.
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * Genera un token JWT para un usuario.
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    /**
     * Crea el token JWT con los claims especificados.
     */
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(getSigningKey())
                .compact();
    }

    /**
     * Valida el token JWT verificando expiración y estructura.
     */
    public Boolean validateToken(String token) {
        try {
            getAllClaimsFromToken(token);
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }
}

// === ARCHIVO: src/main/java/com/fintech/transactions/infrastructure/security/AuthEntryPointJwt.java ===
package com.fintech.transactions.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Manejador de errores para solicitudes no autorizadas.
 * Retorna una respuesta JSON con detalles del error cuando se intenta
 * acceder a recursos protegidos sin autenticación válida.
 */
@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        logger.error("Unauthorized error: {}", authException.getMessage());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        body.put("error", "Unauthorized");
        body.put("message", authException.getMessage());
        body.put("path", request.getServletPath());

        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), body);
    }
}

// === ARCHIVO: src/test/java/com/fintech/transactions/application/TransactionServiceTest.java ===
package com.fintech.transactions.application;

import com.fintech.transactions.domain.model.Transaction;
import com.fintech.transactions.domain.model.Transaction.TransactionStatus;
import com.fintech.transactions.domain.model.Transaction.TransactionType;
import com.fintech.transactions.domain.port.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests para TransactionService")
class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    private Transaction sampleTransaction;
    private UUID accountId;

    @BeforeEach
    void setUp() {
        accountId = UUID.randomUUID();
        sampleTransaction = new Transaction(
            UUID.randomUUID(),
            accountId,
            new BigDecimal("1500.00"),
            "USD",
            TransactionType.DEBIT,
            LocalDateTime.now(),
            "Pago de servicio",
            TransactionStatus.COMPLETED
        );
    }

    @Test
    @DisplayName("Crear transacción exitosamente")
    void shouldCreateTransactionSuccessfully() {
        when(transactionRepository.save(any(Transaction.class))).thenReturn(sampleTransaction);

        Transaction result = transactionService.createTransaction(
            accountId,
            new BigDecimal("1500.00"),
            "USD",
            TransactionType.DEBIT,
            "Pago de servicio"
        );

        assertThat(result).isNotNull();
        assertThat(result.accountId()).isEqualTo(accountId);
        assertThat(result.amount()).isEqualByComparingTo(new BigDecimal("1500.00"));
        assertThat(result.currency()).isEqualTo("USD");
        assertThat(result.type()).isEqualTo(TransactionType.DEBIT);
        verify(transactionRepository).save(any(Transaction.class));
    }

    @Test
    @DisplayName("Obtener transacción por ID existente")
    void shouldFindTransactionById() {
        UUID transactionId = sampleTransaction.id();
        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(sampleTransaction));

        Optional<Transaction> result = transactionService.getTransactionById(transactionId);

        assertThat(result).isPresent();
        assertThat(result.get().id()).isEqualTo(transactionId);
    }

    @Test
    @DisplayName("Obtener transacción por ID no existente retorna vacío")
    void shouldReturnEmptyWhenTransactionNotFound() {
        UUID nonExistentId = UUID.randomUUID();
        when(transactionRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        Optional<Transaction> result = transactionService.getTransactionById(nonExistentId);

        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Obtener transacciones por accountId")
    void shouldFindTransactionsByAccountId() {
        List<Transaction> transactions = List.of(
            sampleTransaction,
            new Transaction(
                UUID.randomUUID(),
                accountId,
                new BigDecimal("2500.00"),
                "USD",
                TransactionType.CREDIT,
                LocalDateTime.now(),
                "Depósito",
                TransactionStatus.PENDING
            )
        );
        when(transactionRepository.findByAccountId(accountId)).thenReturn(transactions);

        List<Transaction> result = transactionService.getTransactionsByAccountId(accountId);

        assertThat(result).hasSize(2);
        assertThat(result).allMatch(t -> t.accountId().equals(accountId));
    }

    @Test
    @DisplayName("Obtener transacciones por accountId y rango de fechas")
    void shouldFindTransactionsByAccountIdAndDateRange() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(7);
        LocalDateTime endDate = LocalDateTime.now();
        List<Transaction> transactions = List.of(sampleTransaction);
        when(transactionRepository.findByAccountIdAndDateRange(accountId, startDate, endDate))
            .thenReturn(transactions);

        List<Transaction> result = transactionService.getTransactionsByAccountIdAndDateRange(
            accountId, startDate, endDate
        );

        assertThat(result).hasSize(1);
        assertThat(result.get(0).accountId()).isEqualTo(accountId);
    }

    @Test
    @DisplayName("Actualizar estado de transacción exitosamente")
    void shouldUpdateTransactionStatus() {
        UUID transactionId = sampleTransaction.id();
        Transaction updatedTransaction = new Transaction(
            transactionId,
            sampleTransaction.accountId(),
            sampleTransaction.amount(),
            sampleTransaction.currency(),
            sampleTransaction.type(),
            sampleTransaction.timestamp(),
            sampleTransaction.description(),
            TransactionStatus.FAILED
        );
        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(sampleTransaction));
        when(transactionRepository.save(any(Transaction.class))).thenReturn(updatedTransaction);

        Transaction result = transactionService.updateTransactionStatus(
            transactionId,
            TransactionStatus.FAILED
        );

        assertThat(result.status()).isEqualTo(TransactionStatus.FAILED);
        verify(transactionRepository).save(any(Transaction.class));
    }

    @Test
    @DisplayName("Actualizar estado de transacción no existente lanza excepción")
    void shouldThrowExceptionWhenUpdatingNonExistentTransaction() {
        UUID nonExistentId = UUID.randomUUID();
        when(transactionRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        assertThatThrownBy(() ->
            transactionService.updateTransactionStatus(nonExistentId, TransactionStatus.COMPLETED)
        ).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("Transacción no encontrada");
    }

    @Test
    @DisplayName("Obtener todas las transacciones")
    void shouldFindAllTransactions() {
        List<Transaction> transactions = List.of(
            sampleTransaction,
            new Transaction(
                UUID.randomUUID(),
                UUID.randomUUID(),
                new BigDecimal("500.00"),
                "EUR",
                TransactionType.CREDIT,
                LocalDateTime.now(),
                "Transferencia",
                TransactionStatus.COMPLETED
            )
        );
        when(transactionRepository.findAll()).thenReturn(transactions);

        List<Transaction> result = transactionService.getAllTransactions();

        assertThat(result).hasSize(2);
    }

    @Test
    @DisplayName("Validar monto negativo lanza excepción")
    void shouldThrowExceptionForNegativeAmount() {
        assertThatThrownBy(() ->
            transactionService.createTransaction(
                accountId,
                new BigDecimal("-100.00"),
                "USD",
                TransactionType.DEBIT,
                "Monto negativo"
            )
        ).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("monto");
    }

    @Test
    @DisplayName("Validar currency vacía lanza excepción")
    void shouldThrowExceptionForEmptyCurrency() {
        assertThatThrownBy(() ->
            transactionService.createTransaction(
                accountId,
                new BigDecimal("100.00"),
                "",
                TransactionType.DEBIT,
                "Currency vacía"
            )
        ).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("currency");
    }
}

// === ARCHIVO: src/test/java/com/fintech/transactions/infrastructure/controller/TransactionControllerTest.java ===
package com.fintech.transactions.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fintech.transactions.application.TransactionService;
import com.fintech.transactions.domain.model.Transaction;
import com.fintech.transactions.domain.model.Transaction.TransactionStatus;
import com.fintech.transactions.domain.model.Transaction.TransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
@DisplayName("Tests de integración para TransactionController")
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TransactionService transactionService;

    private Transaction sampleTransaction;
    private UUID accountId;

    @BeforeEach
    void setUp() {
        accountId = UUID.randomUUID();
        sampleTransaction = new Transaction(
            UUID.randomUUID(),
            accountId,
            new BigDecimal("1500.00"),
            "USD",
            TransactionType.DEBIT,
            LocalDateTime.of(2025, 1, 15, 10, 30, 0),
            "Pago de servicio",
            TransactionStatus.COMPLETED
        );
    }

    @Test
    @DisplayName("POST /api/transactions debe crear transacción exitosamente con autenticación")
    @WithMockUser(username = "user", roles = {"USER"})
    void shouldCreateTransactionWhenAuthenticated() throws Exception {
        Transaction.CreateTransactionRequest request = new Transaction.CreateTransactionRequest(
            accountId,
            new BigDecimal("1500.00"),
            "USD",
            TransactionType.DEBIT,
            "Pago de servicio"
        );
        when(transactionService.createTransaction(any(), any(), any(), any(), any()))
            .thenReturn(sampleTransaction);

        mockMvc.perform(post("/api/transactions")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(sampleTransaction.id().toString()))
            .andExpect(jsonPath("$.accountId").value(sampleTransaction.accountId().toString()))
            .andExpect(jsonPath("$.amount").value(1500.00))
            .andExpect(jsonPath("$.currency").value("USD"));
    }

    @Test
    @DisplayName("POST /api/transactions debe retornar 401 sin autenticación")
    void shouldReturn401WhenNotAuthenticated() throws Exception {
        Transaction.CreateTransactionRequest request = new Transaction.CreateTransactionRequest(
            accountId,
            new BigDecimal("1500.00"),
            "USD",
            TransactionType.DEBIT,
            "Pago de servicio"
        );

        mockMvc.perform(post("/api/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("GET /api/transactions/{id} debe retornar transacción por ID")
    @WithMockUser(username = "user", roles = {"USER"})
    void shouldGetTransactionById() throws Exception {
        UUID transactionId = sampleTransaction.id();
        when(transactionService.getTransactionById(transactionId))
            .thenReturn(Optional.of(sampleTransaction));

        mockMvc.perform(get("/api/transactions/{id}", transactionId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(transactionId.toString()))
            .andExpect(jsonPath("$.amount").value(1500.00));
    }

    @Test
    @DisplayName("GET /api/transactions/{id} debe retornar 404 cuando no existe")
    @WithMockUser(username = "user", roles = {"USER"})
    void shouldReturn404WhenTransactionNotFound() throws Exception {
        UUID nonExistentId = UUID.randomUUID();
        when(transactionService.getTransactionById(nonExistentId))
            .thenReturn(Optional.empty());

        mockMvc.perform(get("/api/transactions/{id}", nonExistentId))
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET /api/transactions debe retornar todas las transacciones")
    @WithMockUser(username = "user", roles = {"USER"})
    void shouldGetAllTransactions() throws Exception {
        List<Transaction> transactions = List.of(
            sampleTransaction,
            new Transaction(
                UUID.randomUUID(),
                accountId,
                new BigDecimal("2500.00"),
                "EUR",
                TransactionType.CREDIT,
                LocalDateTime.now(),
                "Depósito",
                TransactionStatus.PENDING
            )
        );
        when(transactionService.getAllTransactions()).thenReturn(transactions);

        mockMvc.perform(get("/api/transactions"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(2))
            .andExpect(jsonPath("$[0].currency").value("USD"))
            .andExpect(jsonPath("$[1].currency").value("EUR"));
    }

    @Test
    @DisplayName("GET /api/transactions/account/{accountId} debe retornar transacciones por cuenta")
    @WithMockUser(username = "user", roles = {"USER"})
    void shouldGetTransactionsByAccountId() throws Exception {
        List<Transaction> transactions = List.of(sampleTransaction);
        when(transactionService.getTransactionsByAccountId(accountId))
            .thenReturn(transactions);

        mockMvc.perform(get("/api/transactions/account/{accountId}", accountId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].accountId").value(accountId.toString()));
    }

    @Test
    @DisplayName("PUT /api/transactions/{id}/status debe actualizar estado de transacción")
    @WithMockUser(username = "user", roles = {"USER"})
    void shouldUpdateTransactionStatus() throws Exception {
        UUID transactionId = sampleTransaction.id();
        Transaction updatedTransaction = new Transaction(
            transactionId,
            sampleTransaction.accountId(),
            sampleTransaction.amount(),
            sampleTransaction.currency(),
            sampleTransaction.type(),
            sampleTransaction.timestamp(),
            sampleTransaction.description(),
            TransactionStatus.FAILED
        );
        when(transactionService.updateTransactionStatus(eq(transactionId), any()))
            .thenReturn(updatedTransaction);

        mockMvc.perform(put("/api/transactions/{id}/status", transactionId)
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content("\"FAILED\""))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("FAILED"));
    }

    @Test
    @DisplayName("DELETE /api/transactions/{id} debe retornar método no permitido")
    @WithMockUser(username = "user", roles = {"USER"})
    void shouldReturnMethodNotAllowedForDelete() throws Exception {
        UUID transactionId = UUID.randomUUID();

        mockMvc.perform(delete("/api/transactions/{id}", transactionId)
                .with(csrf()))
            .andExpect(status().isMethodNotAllowed());
    }

    @Test
    @DisplayName("GET /api/transactions con rol ADMIN debe retornar todas las transacciones")
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void shouldGetAllTransactionsAsAdmin() throws Exception {
        when(transactionService.getAllTransactions()).thenReturn(List.of(sampleTransaction));

        mockMvc.perform(get("/api/transactions"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(1));
    }
}

// === ARCHIVO: src/test/java/com/fintech/transactions/infrastructure/security/JwtTokenUtilTest.java ===
package com.fintech.transactions.infrastructure.security;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Superficie de práctica - implementar según las fases del reto")
@DisplayName("Tests para JwtTokenUtil - SUPERFICIE DE PRÁCTICA")
class JwtTokenUtilTest {

    @Test
    @DisplayName("Generar token JWT exitosamente")
    void shouldGenerateJwtToken() {
        fail("Implementar: generar token JWT con username y roles");
    }

    @Test
    @DisplayName("Validar token JWT válido")
    void shouldValidateValidToken() {
        fail("Implementar: validar token JWT y retornar username si es válido");
    }

    @Test
    @DisplayName("Validar token JWT expirado")
    void shouldRejectExpiredToken() {
        fail("Implementar: rechazar token JWT expirado");
    }

    @Test
    @DisplayName("Extraer username del token JWT")
    void shouldExtractUsernameFromToken() {
        fail("Implementar: extraer username del payload del token JWT");
    }

    @Test
    @DisplayName("Validar token con firma incorrecta")
    void shouldRejectTokenWithInvalidSignature() {
        fail("Implementar: rechazar token JWT con firma inválida");
    }
}
```
