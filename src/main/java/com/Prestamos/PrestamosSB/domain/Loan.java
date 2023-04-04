package com.Prestamos.PrestamosSB.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;



import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")
public class Loan  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private Double amount;


    @Column(name = "payment_date",nullable = false)
    private LocalDateTime PaymentDate;

    @Column(nullable = false)
    private Double interest;

    @Column(name ="amount_of_payments",nullable = false)
    private Integer amountOfPayments;

    @Column(name = "create_at" )
    @CreationTimestamp
    private LocalDateTime CreateAt;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    List<Transaction> transactions;

    @ManyToOne
    private Client client;
    @ManyToOne
    private User user;


}
