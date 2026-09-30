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