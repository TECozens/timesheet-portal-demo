package com.admiral.tsp.timesheetportal.admin.controllers;

import com.admiral.tsp.timesheetportal.contractor.services.ContractorJpa;
import com.admiral.tsp.timesheetportal.contractor.services.ContractorRepository;
import com.admiral.tsp.timesheetportal.data.UserJpa;
import com.admiral.tsp.timesheetportal.data.UserRepository;
import com.admiral.tsp.timesheetportal.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AdminRestController {

    @Autowired
    private ContractorRepository contractorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContractorJpa contractorJpa;



    @GetMapping(path = "/api/admin/updateManager/{id}/{m_id}")
    public ResponseEntity<Object> updateManager(@PathVariable("id") Long id, @PathVariable("m_id") Long m_id) {

        User manager = userRepository.getUserById(m_id);


        contractorJpa.updateContractor(manager, id);
        System.out.println(contractorRepository.getContractorById(id));

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
