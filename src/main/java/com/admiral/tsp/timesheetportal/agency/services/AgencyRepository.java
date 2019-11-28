package com.admiral.tsp.timesheetportal.agency.services;

import com.admiral.tsp.timesheetportal.agency.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AgencyRepository extends JpaRepository<Agency, Long> {
}
