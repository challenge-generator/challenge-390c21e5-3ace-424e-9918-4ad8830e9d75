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