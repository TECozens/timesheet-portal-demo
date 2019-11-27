package com.admiral.tsp.timesheetportal.agency.services;

import com.admiral.tsp.timesheetportal.agency.Agency;
import com.admiral.tsp.timesheetportal.contractor.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepoJPA extends JpaRepository<Agency, Long> {
}
