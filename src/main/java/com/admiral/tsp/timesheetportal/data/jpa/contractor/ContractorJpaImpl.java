package com.admiral.tsp.timesheetportal.data.jpa.contractor;

import com.admiral.tsp.timesheetportal.services.ContractorRepository;
import com.admiral.tsp.timesheetportal.data.domain.Contractor;
import com.admiral.tsp.timesheetportal.security.services.UserRepository;
import com.admiral.tsp.timesheetportal.security.data.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContractorJpaImpl implements ContractorJpa {

    // Autowired the contractor repository inside implementation
    private ContractorRepository contractorRepository;
    private UserRepository UserJpaRepo;

    @Autowired
    public ContractorJpaImpl(ContractorRepository contractorRepository,
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
    public Optional<Contractor> getByID(Long ID) {
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

    @Transactional
    @Override
    public void updateContractor(User manager, Long c_id) {
        contractorRepository.updateContractor(manager, c_id);
        return;
    }

    @Override
    public List<Contractor> getAll() {
        return contractorRepository.getAllContractor();
    }
}