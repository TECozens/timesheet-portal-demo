package com.admiral.tsp.timesheetportal.data.domain;

import com.admiral.tsp.timesheetportal.data.domain.Contractor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class
Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;

    @Column(name = "days_worked")
    private Integer daysWorked;

    @Column(name = "overtime")
    private Integer overtime;

    @Column(name = "week_finish")
    private LocalDate week_finish;

}
