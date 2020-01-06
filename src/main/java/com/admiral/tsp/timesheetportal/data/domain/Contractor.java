package com.admiral.tsp.timesheetportal.data.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contractor")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "findAllContractorsProcedure",
                procedureName = "FIND_CONTRACTOR_ALL",
                resultClasses = {Contractor.class})
})
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private User manager;

}
