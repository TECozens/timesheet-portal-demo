package com.admiral.tsp.timesheetportal.agency.services;

import com.admiral.tsp.timesheetportal.agency.Agency;
import com.admiral.tsp.timesheetportal.contractor.Contractor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AgencyProcessor implements AgencyCreator {

    private AgencyRepoJPA agencyRepoJPA;

    @Autowired
    public AgencyProcessor(AgencyRepoJPA aAJPARepo) {
        agencyRepoJPA = aAJPARepo;
    }


    @Override
    @Transactional
    public void makeAgency(Agency newAgency) {
        log.info(String.valueOf(agencyRepoJPA.saveAndFlush(newAgency).getId()));
        log.info(newAgency.toString());
    }
}
