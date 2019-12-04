package com.admiral.tsp.timesheetportal.agency.services;

import com.admiral.tsp.timesheetportal.agency.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Implemented by AgencyJpaImpl
public interface AgencyJpa {

    Agency makeAgency(Agency agency);
    Agency findByID(Long ID);
    List<Agency> findAll();

}
