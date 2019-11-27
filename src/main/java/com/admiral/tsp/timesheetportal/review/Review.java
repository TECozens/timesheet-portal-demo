package com.admiral.tsp.timesheetportal.review;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "timesheet_id")
    private Timesheet timesheet;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "message")
    private String a;

    @Column(name = "")
    private String b;

}
