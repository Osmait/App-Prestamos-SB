package com.Prestamos.PrestamosSB.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "loan")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private Double amount;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime CreateAt;

    @Column(name = "client_id")
    private Long clientId;

    @ManyToOne
    @JoinColumn(name = "client_id",insertable = false,updatable = false)
    private Client client;

//    @OneToMany(mappedBy = "loan",fetch =FetchType.EAGER ,cascade = CascadeType.REMOVE)
//    private List<Transaction> transactions;



}
