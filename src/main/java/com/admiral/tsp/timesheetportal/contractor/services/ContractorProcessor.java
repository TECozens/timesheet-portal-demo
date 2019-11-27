package com.admiral.tsp.timesheetportal.contractor.services;

import com.admiral.tsp.timesheetportal.contractor.Contractor;
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
    private JpaRepository<Contractor, Long> JpaRepo;

    @Autowired
    public ContractorProcessor(JpaRepository<Contractor, Long> aJPARepo) {
        JpaRepo = aJPARepo;
    }


    @Override
    @Transactional
    public Contractor makeContractor(Contractor newC) {
        Contractor updated = JpaRepo.saveAndFlush(newC);
        log.info(updated.toString());

        return updated;
    }

    @Override
    public Optional<Contractor> getByID(Long ID) {
        return JpaRepo.findById(ID);
    }

    @Override
    public Optional<Contractor> getByUsername(String name) {
        return Optional.empty();
    }

    @Override
    public List<Contractor> getAll() {
        return JpaRepo.findAll();
    }
}
