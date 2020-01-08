package com.admiral.tsp.timesheetportal.data.jpa;

import com.admiral.tsp.timesheetportal.data.domain.Agency;

import java.util.List;

// Implemented by AgencyJpaImpl
public interface AgencyJpa {

    Agency makeAgency(Agency agency);
    Agency findByID(Long ID);
    List<Agency> findAll();

}
