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