package com.admiral.tsp.timesheetportal.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DaysWorked {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monday")
    private LocalDateTime monday;

    @Column(name = "tuesday")
    private LocalDateTime tuesday;

    @Column(name = "wednesday")
    private LocalDateTime wednesday;

    @Column(name = "thursday")
    private LocalDateTime thursday;

    @Column(name = "friday")
    private LocalDateTime friday;
}
