package com.admiral.tsp.timesheetportal.data.jpa.agency;

import com.admiral.tsp.timesheetportal.data.domain.Agency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class AgencyJpaImpl implements AgencyJpa {

    // Autowired the agency repository inside implementation
    private AgencyRepository agencyRepository;

    @Autowired
    public AgencyJpaImpl(AgencyRepository agencyRepository) {
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
    public Agency findByID(Long ID) {
        return agencyRepository.getAgencyById(ID);
    }

    @Override
    public List<Agency> findAll() {
        return agencyRepository.getAllAgency();
    }
}
