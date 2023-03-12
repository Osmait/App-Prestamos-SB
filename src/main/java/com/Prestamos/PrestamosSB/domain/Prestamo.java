package com.Prestamos.PrestamosSB.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private Double monto;

    @Column(name = "client_id")
    private Long clientId;

    @ManyToOne
    @JoinColumn(name = "client_id",insertable = false,updatable = false)
    private Client client;

    public Prestamo(Double monto, Long clientId) {
        this.monto = monto;
        this.clientId = clientId;

    }

    public Prestamo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        monto = monto;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", Monto=" + monto +
                ", clientId=" + clientId +
                '}';
    }
}
