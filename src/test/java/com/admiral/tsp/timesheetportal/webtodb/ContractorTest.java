package com.admiral.tsp.timesheetportal.webtodb;

import com.admiral.tsp.timesheetportal.data.jpa.TimeSheetJpa;
import com.admiral.tsp.timesheetportal.service.ContractorRepository;
import com.admiral.tsp.timesheetportal.service.TimeSheetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class ContractorTest {

    @Autowired
    ContractorRepository contractorRepository;

    @Autowired
    TimeSheetRepository timeSheetRepository;

    @Autowired
    TimeSheetJpa timeSheetJpa;

    @Autowired
    MockMvc mockMvc;

    @WithUserDetails(value = "Mo")
    @Test
    public void LoginAsContractor() throws Exception {

    }

//    @Test
//    @WithUserDetails(value = "Kevin")
//    public void CreateNewTimesheet() throws Exception {
//
//        TimeSheet testTimesheet = new TimeSheet(
//                null,
//                contractorRepository.getContractorByUsername("Kevin").get(),
//                5,
//                1,
//                LocalDate.now());
//
//        mockMvc.perform
//                (get
//                        ("/newTimeSheet")
//                        .sessionAttr("TimeSheetKey", testTimesheet)
//                )
//                .andExpect(status().isOk())
//                .andDo("/createTimesheet")
//                )
//        ;

    //check the database as well.
//    }

}
