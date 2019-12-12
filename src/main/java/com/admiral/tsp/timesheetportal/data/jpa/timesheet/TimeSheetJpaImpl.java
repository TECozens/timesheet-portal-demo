package com.admiral.tsp.timesheetportal.data.jpa.timesheet;

import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.services.TimeSheetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TimeSheetJpaImpl implements TimeSheetJpa {

    // Autowired the timeSheet repository inside implementation
    private final TimeSheetRepository timesheetRepository;

    @Autowired
    public TimeSheetJpaImpl(TimeSheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }


    @Override
    @Transactional
    public TimeSheet makeTimeSheet(TimeSheet newT) {

        TimeSheet updated = timesheetRepository.saveAndFlush(newT);

        log.info(updated.toString());

        return updated;
    }

    @Override
    public Optional<TimeSheet> getByID(Long id) {
        return timesheetRepository.getTimeSheetById(id);
    }

    @Override
    public List<TimeSheet> getAll() {
        return timesheetRepository.getAllTimeSheets();
    }

    @Override
    public List<TimeSheet> getUnreviewed() {
        return timesheetRepository.getUnreviewed();
    }

    @Override
    public List<TimeSheet> getByManager(User manager) {
        return timesheetRepository.getByManager(manager);
    }

    @Override
    public List<TimeSheet> getUnreviewedByManager(User manager) {
        return timesheetRepository.getUnreviewedByManager(manager);
    }

}
