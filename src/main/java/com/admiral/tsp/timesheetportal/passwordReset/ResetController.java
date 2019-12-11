package com.admiral.tsp.timesheetportal.passwordReset;

import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.data.jpa.user.UserJpa;
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

    @GetMapping("/confirmReset?token=")
    public String validateResetToken(@RequestParam("token") String confirmationToken, Model model) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token !=null){
            User user = userJpa.getByUsername(token.getUser().getUsername());
            model.addAttribute("User", user);
            return "redirect:/confirmResetPassword";
        } else {
            log.error("Error: The link is invalid or broken.");
        }

        return "redirect:/login";

    }

    @PostMapping("/confirmResetPassword")
    public String resetUserPassword(@ModelAttribute("resetKey") ResetForm resetForm,
                                    User user) {

        if(user.getUsername() != null){
            User tokenUser = userJpa.getByUsername(user.getUsername());
            tokenUser.setPassword(passwordEncoder.encode(resetForm.getPassword()));

            return "redirect:/login";
        } else {
            log.error("Error: The link is invalid or broken.");
        }
            return "redirect:/passwordReset";
    }

}
