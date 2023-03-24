package com.Prestamos.PrestamosSB.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    List<Client>findAllByUserId(Long id);





}
