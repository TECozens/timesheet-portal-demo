package com.admiral.tsp.timesheetportal.passwordReset;

import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.data.jpa.user.UserJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@SessionAttributes({"passwordKey","userKey"})
public class PasswordResetController {

    private final PasswordEncoder passwordEncoder;
    private final UserJpa userJpa;

    @Autowired
    public PasswordResetController(PasswordEncoder passwordEncoder, UserJpa userJpa) {
        this.passwordEncoder = passwordEncoder;
        this.userJpa = userJpa;
    }

    @GetMapping("/passwordReset")
    public String goToPasswordReset(Model model){

        List<User> users = userJpa.findUsers();

        model.addAttribute("passwordKey", new PasswordResetForm());
        model.addAttribute("userKey", users);

        return "passwordReset";

    }

    @PostMapping("/passwordRetrieve")
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

        passwordResetEmail.passwordResetEmail(userEmail);

        return "redirect:/login";

    }

}
