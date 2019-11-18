package com.admiral.tsp.timesheetportal;

import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.repository.TimesheetRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TimeSheetQueryTest {

    @Autowired
    private TimesheetRepo repo;

    @Autowired
    EntityManager em;

    @Test
    public void theOneWhereJoesTimeSheetisReturned() throws Exception {

        Optional<Timesheet> aTimeSheet = repo.findById(1L);
        assertEquals("Joe", aTimeSheet.get().getContractor());


    }

}

