package com.admiral.tsp.timesheetportal.contractor.services;

import com.admiral.tsp.timesheetportal.contractor.Contractor;
import com.admiral.tsp.timesheetportal.csrf.User;

import java.util.List;
import java.util.Optional;

// Implemented by ContractorJpaImpl
public interface ContractorJpa {

    Contractor makeContractor(Contractor item);
    Optional<Contractor> getByID(Integer ID);
    Optional<Contractor> getByUsername(String name);
    Optional<Contractor> getByUser(User user);
    List<Contractor> getAll();

}
