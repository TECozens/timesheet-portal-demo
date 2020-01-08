package com.admiral.tsp.timesheetportal.data;

import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.security.services.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
@Transactional
public class AdminQueryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    EntityManager em;

    @Test
    public void returnLauraById() throws Exception {
        Optional<User> aUser = userRepository.findById(2L);
        assertEquals("LAURA", aUser.get().getUsername().toUpperCase());
    }
}
