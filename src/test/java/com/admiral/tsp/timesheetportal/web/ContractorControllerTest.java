package com.admiral.tsp.timesheetportal.web;

import com.admiral.tsp.timesheetportal.service.TimeSheetRepository;
import com.admiral.tsp.timesheetportal.web.controllers.contractor.ContractorController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ContractorController.class)
public class ContractorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TimeSheetRepository tRepo;

    @Test
    public void timesheetContractorIsMo() throws Exception {

    }
}
