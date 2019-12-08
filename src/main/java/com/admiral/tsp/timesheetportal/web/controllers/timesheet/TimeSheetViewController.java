package com.admiral.tsp.timesheetportal.web.controllers.timesheet;

import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
import com.admiral.tsp.timesheetportal.data.jpa.timesheet.TimeSheetJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@SessionAttributes({"TimesheetKey"})
public class TimeSheetViewController {


    private final TimeSheetJpa timesheetJpa;

    @Autowired
    public TimeSheetViewController(TimeSheetJpa timesheetJpa) {
        this.timesheetJpa = timesheetJpa;
    }


    @GetMapping("Timesheet/{i}")
    public String showTimesheetDashboardPage(@PathVariable("i") Long index, Model model) {

        Optional<TimeSheet> foundTimesheet = timesheetJpa.getByID(index);

        if (foundTimesheet.isPresent()) {
            model.addAttribute("TimesheetKey", foundTimesheet.get());

            return "timesheet_view";

        } else {
            return "404";
        }
    }
    @GetMapping("/Reviews")
    public String showTimesheetApprovalPage(Model model){
        List<TimeSheet> foundTimeSheets = timesheetJpa.getAll();

        model.addAttribute("TimesheetKey", foundTimeSheets);

        return "manager_view";

    }



}
