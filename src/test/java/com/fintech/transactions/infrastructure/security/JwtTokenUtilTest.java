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