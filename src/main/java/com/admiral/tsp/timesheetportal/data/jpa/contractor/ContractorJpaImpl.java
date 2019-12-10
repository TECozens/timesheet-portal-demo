package com.admiral.tsp.timesheetportal.data.jpa.contractor;

import com.admiral.tsp.timesheetportal.data.domain.Contractor;
import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.services.ContractorRepository;
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
    private final ContractorRepository contractorRepository;

    @Autowired
    public ContractorJpaImpl(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
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
    }

    @Override
    public List<Contractor> getAll() {
        return contractorRepository.getAllContractor();
    }
}
