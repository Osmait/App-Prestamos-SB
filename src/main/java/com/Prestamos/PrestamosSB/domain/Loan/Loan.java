package com.Prestamos.PrestamosSB.domain.Loan;

import com.Prestamos.PrestamosSB.domain.Client.Client;
import com.Prestamos.PrestamosSB.domain.Transaction.Transaction;
import com.Prestamos.PrestamosSB.domain.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;



import java.time.LocalDateTime;


import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")
public class Loan  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Double amount;


    @Column(name = "payment_date",nullable = false)
    private LocalDateTime PaymentDate;

    @Column(nullable = false)
    private Double interest;

    @Column(name ="amount_of_payments",nullable = false)
    private Integer amountOfPayments;

    @Column(name = "status",columnDefinition = "boolean default false")
    private boolean status ;

    @Column(name = "deleted",columnDefinition = "boolean default false")
    private  boolean deleted;

    @Column(name = "create_at" )
    @CreationTimestamp
    private LocalDateTime CreateAt;


    @OneToMany(mappedBy = "loan")
    @JsonManagedReference
    List<Transaction> transactions;

    @Column(name = "client_id",nullable = false)
    private UUID clientId;




}
