package com.Prestamos.PrestamosSB.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "deleted",columnDefinition = "boolean default false")
    private  boolean deleted;


//    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
//    @JsonManagedReference
//    List<Loan> loans;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;


}
