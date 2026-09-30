# Mejora de Seguridad y Legibilidad en Desarrollo Backend con Java

El equipo de desarrollo de una empresa fintech necesita un especialista en backend con experiencia en Java para mejorar la seguridad y legibilidad del código. El sistema actual maneja transacciones financieras con un volumen de 10 000 operaciones por hora durante las horas pico. Se requiere implementar y mejorar mecanismos de autenticación utilizando JWT para asegurar las transacciones y reducir la redundancia del código.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Especialista en Framework con Proficiencia en Seguridad y Legibilidad de Código |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 2 semanas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Análisis de Requisitos y Revisión de Código

**Objetivo:** Identificar áreas de mejora en la seguridad y legibilidad del código existente.

**Tiempo estimado:** 3 días

**Instrucciones:**

- Revisar el código actual para identificar puntos débiles en la seguridad y legibilidad.
- Documentar las áreas que requieren mejoras y proponer soluciones.

**Entregable:** Documento de análisis con propuestas de mejora.

<details>
<summary>Pistas de conocimiento</summary>

- Considerar el impacto de los cambios en la funcionalidad existente.
- Evaluar la claridad y consistencia del código.

</details>

### Fase 2: Implementación de Mecanismos de Autenticación

**Objetivo:** Implementar y mejorar mecanismos de autenticación utilizando JWT.

**Tiempo estimado:** 5 días

**Instrucciones:**

- Implementar un mecanismo de autenticación basado en JWT.
- Asegurar que el nuevo mecanismo no afecte negativamente el rendimiento del sistema.

**Entregable:** Mecanismo de autenticación implementado y probado.

<details>
<summary>Pistas de conocimiento</summary>

- Utilizar bibliotecas y frameworks que faciliten la implementación de JWT.
- Realizar pruebas unitarias y de integración para validar el nuevo mecanismo.

</details>

### Fase 3: Refactorización y Optimización del Código

**Objetivo:** Refactorizar el código para mejorar la legibilidad y reducir la redundancia.

**Tiempo estimado:** 4 días

**Instrucciones:**

- Refactorizar el código existente para mejorar la legibilidad y reducir la redundancia.
- Asegurar que los cambios no introduzcan nuevos errores o vulnerabilidades.

**Entregable:** Código refactorizado y optimizado.

<details>
<summary>Pistas de conocimiento</summary>

- Utilizar patrones de diseño para mejorar la estructura del código.
- Realizar pruebas de regresión para validar que los cambios no introducen errores.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un JWT y por qué es importante en la autenticación?
- **paraQueSirve**: ¿Para qué sirve refactorizar el código en términos de seguridad y legibilidad?
- **comoSeUsa**: ¿Cómo se usa un JWT en la autenticación de un sistema backend?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar mecanismos de autenticación y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de un nuevo mecanismo de autenticación en un sistema existente?

## Criterios de Evaluacion

- Implementación de un mecanismo de autenticación utilizando JWT.
- Refactorización del código para mejorar la legibilidad y reducir la redundancia.
- Documentación de propuestas de mejora y resultados obtenidos.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
