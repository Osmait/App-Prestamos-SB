package com.Prestamos.PrestamosSB.domain;

import com.Prestamos.PrestamosSB.domain.Enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "transaction_type")
    private TransactionType transactionType;

    private Double amount;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime CreateAt;

    @ManyToOne
    @JoinColumn(name = "loan_id", referencedColumnName = "id",updatable = false)
    @JsonIgnore
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",updatable = false)
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", CreateAt=" + CreateAt +
                ", loan=" + loan +
                ", user=" + user +
                '}';
    }
}
