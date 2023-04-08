package com.Prestamos.PrestamosSB.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @OneToMany(mappedBy = "loan",fetch = FetchType.EAGER)
    @JsonIgnore
    List<Transaction> transactions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id",updatable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",updatable = false)
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", amount=" + amount +
                ", PaymentDate=" + PaymentDate +
                ", interest=" + interest +
                ", amountOfPayments=" + amountOfPayments +
                ", CreateAt=" + CreateAt +
                '}';
    }
}
