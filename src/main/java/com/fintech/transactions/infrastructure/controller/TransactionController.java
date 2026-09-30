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