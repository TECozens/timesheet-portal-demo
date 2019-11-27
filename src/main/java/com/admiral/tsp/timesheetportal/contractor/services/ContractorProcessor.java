package com.admiral.tsp.timesheetportal.contractor.services;

import com.admiral.tsp.timesheetportal.contractor.Contractor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ContractorProcessor implements ContractorCreator {

    private ContractorRepoJPA contractorRepoJPA;

    @Autowired
    public ContractorProcessor(ContractorRepoJPA aCJPARepo) {
        contractorRepoJPA = aCJPARepo;
    }


    @Override
    @Transactional
    public Contractor makeContractor(Contractor newContractor) {
        Contractor updatedContractor = contractorRepoJPA.saveAndFlush(newContractor);
        log.info(updatedContractor.toString());
        return updatedContractor;
    }
}
