package com.Prestamos.PrestamosSB.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrestamoRepository extends CrudRepository<Loan,Long> {


    Optional<List<Loan>> findAllByClientId(Long ClientId);

}
