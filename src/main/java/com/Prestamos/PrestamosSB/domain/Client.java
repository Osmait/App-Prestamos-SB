package com.Prestamos.PrestamosSB.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;



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

    private String img;


    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Loan> loans;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",updatable = false)
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
