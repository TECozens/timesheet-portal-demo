package com.admiral.tsp.timesheetportal;

import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.repository.TimesheetRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
<<<<<<< HEAD
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
=======
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
>>>>>>> bc86e9a1b9149f49e4d46dd4b4e251d053984962

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
        assertEquals("Joe", aTimeSheet.get().getContractor().getName());


    }

}

