package com.admiral.tsp.timesheetportal.data.jpa.token;

import com.admiral.tsp.timesheetportal.data.domain.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}