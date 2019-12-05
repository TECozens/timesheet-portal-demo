package com.admiral.tsp.timesheetportal.data.domain;

import com.admiral.tsp.timesheetportal.data.domain.Timesheet;
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
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "timesheet_id")
    private Timesheet timesheet;

    @Column(name = "approved")
    private Boolean approved;

    @Column(name = "paid")
    private Boolean paid;

    @Column(name = "message")
    private String message;

    @Column(name = "communication_rating")
    private Integer communication_rating;

    @Column(name = "tech_skills_rating")
    private Integer tech_skills_rating;

    @Column(name = "quality_rating")
    private Integer quality_rating;

    @Column(name = "initiative_rating")
    private Integer initiative_rating;

    @Column(name = "productivity_rating")
    private Integer productivity_rating;

    @Column(name = "working_relationships_rating")
    private Integer working_relationships_rating;

}
