package com.admiral.tsp.timesheetportal.web.controllers.passwordReset;

import com.admiral.tsp.timesheetportal.data.domain.ConfirmationToken;
import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.data.jpa.passwordreset.ConfirmationTokenJpa;
import com.admiral.tsp.timesheetportal.data.jpa.user.UserJpa;
import com.admiral.tsp.timesheetportal.web.forms.passwordreset.ResetForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@SessionAttributes({"resetKey"})
public class ResetController {

    private final PasswordEncoder passwordEncoder;
    private final UserJpa userJpa;
    private final ConfirmationTokenJpa confirmationTokenJpa;

    @Autowired
    public ResetController(PasswordEncoder passwordEncoder, UserJpa userJpa, ConfirmationTokenJpa confirmationTokenJpa) {
        this.passwordEncoder = passwordEncoder;
        this.userJpa = userJpa;
        this.confirmationTokenJpa = confirmationTokenJpa;
    }

    @GetMapping("/confirmReset")
    public String goToConfirmReset(@RequestParam("token") String confirmationToken, Model model) {

        ConfirmationToken token = confirmationTokenJpa.findByConfirmationToken(confirmationToken);

        if (token != null) {

            User user = userJpa.getByUsername(token.getUser().getUsername());
            ResetForm resetForm = new ResetForm();
            resetForm.setUsername(user.getUsername());
            model.addAttribute("resetKey", resetForm);


            return "confirmReset";

        } else {

            log.error("Error: The link is invalid or broken.");
            return "404";

        }

    }

    @PostMapping("/confirmResetPassword")
    public String resetUserPassword(@ModelAttribute("resetKey") ResetForm resetForm) {

        User tokenUser = userJpa.getByUsername(resetForm.getUsername());

        if (tokenUser.getUsername() != null) {

            userJpa.updatePassword(tokenUser.getId(),passwordEncoder.encode(resetForm.getPassword()));

            return "redirect:/login";

        } else {

            log.error("Error: The link is invalid or broken.");

        }
        return "redirect:/passwordReset";
    }

}
