package com.admiral.tsp.timesheetportal.data.jpa.passwordreset;

import com.admiral.tsp.timesheetportal.data.domain.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}