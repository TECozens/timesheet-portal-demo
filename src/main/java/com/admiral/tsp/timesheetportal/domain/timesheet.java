package com.admiral.tsp.timesheetportal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;

   // @ManyToOne(fetch = FetchType.EAGER) once agency entity added then this included
  //  @JoinColumn(name = "agency_id")
  //  private Agency agency;

  //  @ManyToOne(fetch = FetchType.EAGER) once agency entity added then this included
    //@JoinColumn(name = "days_worked_id")
    //private DaysWorked days_worked_id;

    @Column(name = "approved")
    private Boolean approved;



}
