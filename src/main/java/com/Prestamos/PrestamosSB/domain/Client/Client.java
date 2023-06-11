package com.Prestamos.PrestamosSB.domain.Client;

import com.Prestamos.PrestamosSB.domain.Loan.Loan;
import com.Prestamos.PrestamosSB.domain.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50 ,nullable = false)
    private String name;

    @Column(name = "last_name",length = 50 , nullable = false)
    private String lastName;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private  String phoneNumber;

    private String img;

    @Column(name = "deleted",columnDefinition = "boolean default false")
    private  boolean deleted;

    @Column(name = "create_at")
    @CreationTimestamp
    private LocalDateTime CreateAt;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;


}
