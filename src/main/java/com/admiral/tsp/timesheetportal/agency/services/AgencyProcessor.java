package com.admiral.tsp.timesheetportal.agency.services;

import com.admiral.tsp.timesheetportal.agency.Agency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AgencyProcessor implements AgencyJpaRepo {

    // Autowired the generic referenced JPA repository inside the implemented Repo
    // This cleans up the layout of the code and bundles together the JPA interfaces
    private AgencyRepository agencyRepository;

    @Autowired
    public AgencyProcessor(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }


    @Override
    @Transactional
    public Agency makeAgency(Agency newA) {
        Agency updated = agencyRepository.saveAndFlush(newA);
        log.info(updated.toString());

        return updated;
    }

    @Override
    public Agency findByID(Integer ID) {
        return agencyRepository.getAgencyById(ID);
    }

    @Override
    public List<Agency> findAll() {
        return agencyRepository.getAllAgency();
    }
}
