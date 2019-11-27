package com.admiral.tsp.timesheetportal.contractor.services;

import com.admiral.tsp.timesheetportal.contractor.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Implemented by ContractorProcessor
@Repository
public interface ContractorJpaRepo {

    Contractor makeContractor(Contractor item);
    Optional<Contractor> getByID(Long ID);
    Optional<Contractor> getByUsername(String name);
    List<Contractor> getAll();

}
