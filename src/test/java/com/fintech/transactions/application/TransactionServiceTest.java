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