package com.admiral.tsp.timesheetportal.web.controllers.passwordReset;

import com.admiral.tsp.timesheetportal.data.domain.ConfirmationToken;
import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.data.jpa.passwordreset.ConfirmationTokenRepository;
import com.admiral.tsp.timesheetportal.data.jpa.user.UserJpa;
import com.admiral.tsp.timesheetportal.web.forms.passwordreset.PasswordResetForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@SessionAttributes({"passwordKey","userKey"})
public class PasswordResetController {

    private final UserJpa userJpa;
    private final ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    public PasswordResetController(UserJpa userJpa, ConfirmationTokenRepository confirmationTokenRepository) {
        this.userJpa = userJpa;
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    @GetMapping("/passwordReset")
    public String goToPasswordReset(Model model){


        model.addAttribute("passwordKey", new PasswordResetForm());

        return "passwordReset";

    }

    @PostMapping("/passwordTokenSend")
    public String forgotPasswordDetails(@Valid @ModelAttribute("passwordKey") PasswordResetForm passwordResetForm,
                              BindingResult bindingResult,
                              Model model) {

        List<User> users = userJpa.findUsers();

        if(bindingResult.hasErrors()) {

            log.error(bindingResult.toString());
            log.error("Password Reset Form has binding errors");

            model.addAttribute("userKey", users);
            model.addAttribute("passwordKey", passwordResetForm);

            return "passwordReset";

        }

        return "redirect:/sendPassword/";

    }

    @GetMapping("/sendPassword")
    public String submitPassword(@ModelAttribute("passwordKey") PasswordResetForm passwordResetForm) throws IOException, MessagingException {

        String username = passwordResetForm.getUsername();

        User userEmail = userJpa.getEmailByUsername(username);

        PasswordResetEmail passwordResetEmail = new PasswordResetEmail();

        ConfirmationToken confirmationToken = new ConfirmationToken(userEmail);
        confirmationTokenRepository.save(confirmationToken);
        passwordResetEmail.passwordResetEmail(userEmail, confirmationToken);

        return "redirect:/login";

    }

}
