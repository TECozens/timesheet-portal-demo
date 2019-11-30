package com.admiral.tsp.timesheetportal.contractor.services;

import com.admiral.tsp.timesheetportal.contractor.Contractor;
import com.admiral.tsp.timesheetportal.data.UserRepository;
import com.admiral.tsp.timesheetportal.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContractorProcessor implements ContractorJpaRepo {

    // Autowired the generic referenced JPA repository inside the implemented Repo
    // This cleans up the layout of the code and bundles together the JPA interfaces
    private ContractorRepository contractorRepository;
    private UserRepository UserJpaRepo;

    @Autowired
    public ContractorProcessor(ContractorRepository contractorRepository,
                               UserRepository UserJpaRepo) {
        this.contractorRepository = contractorRepository;
        this.UserJpaRepo = UserJpaRepo;
    }


    @Override
    @Transactional
    public Contractor makeContractor(Contractor newC) {
        Contractor updated = contractorRepository.saveAndFlush(newC);
        log.info(updated.toString());

        return updated;
    }

    @Override
    public Optional<Contractor> getByID(Integer ID) {
        return contractorRepository.getContractorById(ID);
    }

    @Override
    public Optional<Contractor> getByUsername(String name) {
        return contractorRepository.getContractorByUsername(name);
    }

    @Override
    public Optional<Contractor> getByUser(User user) {
        return contractorRepository.getContractorByUser(user);
    }

    @Override
    public List<Contractor> getAll() {
        return contractorRepository.getAllContractor();
    }
}
