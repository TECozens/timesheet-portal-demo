package com.admiral.tsp.timesheetportal.web.controllers.admin.rest;

import com.admiral.tsp.timesheetportal.data.jpa.contractor.ContractorJpa;
import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.data.jpa.user.UserJpa;
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
    private UserJpa userJpa;

    @Autowired
    private ContractorJpa contractorJpa;



    @GetMapping(path = "/api/admin/updateManager/{id}/{m_id}")
    public ResponseEntity<Object> updateManager(@PathVariable("id") Long id, @PathVariable("m_id") Long m_id) {

        User manager = userJpa.getById(m_id);


        contractorJpa.updateContractor(manager, id);
        System.out.println(contractorJpa.getByID(id));

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
