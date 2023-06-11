package com.Prestamos.PrestamosSB.domain.Client;



import com.Prestamos.PrestamosSB.domain.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface ClientRepository extends JpaRepository<Client,UUID> {


    Optional<List<Client>> findAllByUserId(UUID id);





}
