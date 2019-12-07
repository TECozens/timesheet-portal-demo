package com.admiral.tsp.timesheetportal.data.jpa.agency;

import com.admiral.tsp.timesheetportal.data.domain.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

    @Query("SELECT a FROM Agency a WHERE a.id = :id")
    Agency getAgencyById(@Param("id") Long id);

    @Query("SELECT a FROM Agency a")
    List<Agency> getAllAgency();

}
