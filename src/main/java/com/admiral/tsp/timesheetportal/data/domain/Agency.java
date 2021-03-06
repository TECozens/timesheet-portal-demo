package com.admiral.tsp.timesheetportal.data.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agency")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "findAllAgencyProcedure",
                procedureName = "FIND_AGENCY_ALL",
                resultClasses = {Agency.class})
})
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agency_name")
    private String name;

    @Email
    @Column(name = "email")
    private String agency_email;

}
