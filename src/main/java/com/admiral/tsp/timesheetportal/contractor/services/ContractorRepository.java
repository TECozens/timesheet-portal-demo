package com.admiral.tsp.timesheetportal.contractor.services;

import com.admiral.tsp.timesheetportal.contractor.Contractor;
import com.admiral.tsp.timesheetportal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {

    @Query("SELECT c FROM Contractor c WHERE c.id =:id")
    Optional<Contractor> getContractorById(@Param("id") Long id);

    @Query("SELECT c FROM Contractor c WHERE c.user =:user")
    Optional<Contractor> getContractorByUser(@Param("user") User user);

    @Query("SELECT c FROM Contractor c, User u WHERE u.username =:username AND c.user = u")
    Optional<Contractor> getContractorByUsername(@Param("username") String username);

    @Modifying
    @Query("UPDATE Contractor c SET c.manager =:manager WHERE c.id =:c_id")
    void updateContractor(@Param("manager") User manager,@Param("c_id") Long c_id);

    @Query("SELECT c FROM Contractor c")
    List<Contractor> getAllContractor();


}
