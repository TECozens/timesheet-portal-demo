package com.admiral.tsp.timesheetportal.data.jpa.passwordreset;

import com.admiral.tsp.timesheetportal.data.domain.ConfirmationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConfirmationTokenJpaImpl implements ConfirmationTokenJpa {

    ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    ConfirmationTokenJpaImpl(ConfirmationTokenRepository confirmationTokenRepository){
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    @Override
    public ConfirmationToken findByConfirmationToken(String confirmationToken) {
        return confirmationTokenRepository.findByConfirmationToken(confirmationToken);
    }

    @Override
    @Transactional
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        confirmationTokenRepository.save(confirmationToken);
    }
}
