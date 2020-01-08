package com.admiral.tsp.timesheetportal.webtodb;

import com.admiral.tsp.timesheetportal.data.domain.Contractor;
import com.admiral.tsp.timesheetportal.data.jpa.ContractorJpa;
import com.admiral.tsp.timesheetportal.data.jpa.UserJpa;
import com.admiral.tsp.timesheetportal.security.services.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class AdminManageUserTest {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    EntityManager em;

    @Autowired
    private UserJpa userJpa;

    @Autowired
    private ContractorJpa contractorJpa;


    @Test
    @WithUserDetails("Laura")
    public void LoginAsAdmin() throws Exception {
        mockMvc.perform
                (
                        get("/login")
                )
                .andExpect(view().name("/reviews"))
                .andExpect(content().string("Admin"))
        ;
    }

    @WithMockUser(roles = "ADMIN")
    @Test
    public void AdminManageUser() throws Exception {

        List<Contractor> foundContractors = contractorJpa.getAll();

        mockMvc.perform
                (get("/contractorList/3")

                )
                .andExpect(model().attribute("Contractors", foundContractors))
        ;
    }

}
