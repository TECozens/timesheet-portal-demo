package com.admiral.tsp.timesheetportal.contractor.services;

import com.admiral.tsp.timesheetportal.contractor.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorRepoJPA extends JpaRepository<Contractor, Long> {
}
