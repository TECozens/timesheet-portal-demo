package com.admiral.tsp.timesheetportal.data.jpa.passwordreset;

import com.admiral.tsp.timesheetportal.data.domain.ConfirmationToken;



public interface ConfirmationTokenJpa {

    ConfirmationToken findByConfirmationToken(String confirmationToken);

    void saveConfirmationToken(ConfirmationToken confirmationToken);

}
