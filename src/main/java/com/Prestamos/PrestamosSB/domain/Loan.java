package com.Prestamos.PrestamosSB.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "loan")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private Double amount;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime CreateAt;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    List<Transaction> transactions;

    @ManyToOne
    private Client client;





}
