package com.admiral.tsp.timesheetportal.web.controllers.passwordreset;

import com.admiral.tsp.timesheetportal.data.domain.ConfirmationToken;
import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.data.jpa.token.ConfirmationTokenRepository;
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
    private final ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    public ResetController(PasswordEncoder passwordEncoder, UserJpa userJpa, ConfirmationTokenRepository confirmationTokenRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userJpa = userJpa;
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    @GetMapping("/confirmReset")
    public String goToConfirmReset(@RequestParam("token") String confirmationToken, Model model) {

        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {

            User user = userJpa.getByUsername(token.getUser().getUsername());

            model.addAttribute("User", user);

            model.addAttribute("resetKey", new ResetForm());


            return "confirmReset";

        } else {

            log.error("Error: The link is invalid or broken.");
            return "404";

        }

    }

    @PostMapping("/confirmResetPassword")
    public String resetUserPassword(@ModelAttribute("resetKey") ResetForm resetForm,
                                    User user) {

        if (user.getUsername() != null) {

            User tokenUser = userJpa.getByUsername(user.getUsername());

            userJpa.updatePassword(tokenUser.getId(), passwordEncoder.encode(resetForm.getPassword()));
            System.out.println(resetForm.getPassword());
            System.out.println(resetForm.getUsername());

            System.out.println(user.getUsername());

            return "redirect:/login";

        } else {

            log.error("Error: The link is invalid or broken.");

        }
        return "redirect:/passwordReset";
    }

}
