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