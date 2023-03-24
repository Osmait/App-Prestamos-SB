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

    @Column(length = 50 ,nullable = false)
    private String name;

    @Column(name = "last_name",length = 50 , nullable = false)
    private String lastName;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private  String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    List<Loan> loans ;

    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
