package com.Prestamos.PrestamosSB.domain;

import com.Prestamos.PrestamosSB.domain.Enums.TransactionType;
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

    @ManyToOne()
    private Loan loan;







}
