package com.Prestamos.PrestamosSB.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(name = "last_name",length = 50)
    private String lastName;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private  String phoneNumber;

    @Column(name = "user_id")
    private  Long userId;

    @OneToMany(mappedBy = "client")
    private List<Loan> prestamos;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;


}
