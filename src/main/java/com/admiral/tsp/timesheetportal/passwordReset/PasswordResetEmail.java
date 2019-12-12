package com.admiral.tsp.timesheetportal.passwordReset;

import com.admiral.tsp.timesheetportal.data.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class PasswordResetEmail {

    public void passwordResetEmail(User username, ConfirmationToken confirmationToken)
            throws AddressException, MessagingException, IOException {


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("timeSheetPortal3@gmail.com", "Password03");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("timeSheetPortal3@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username.getEmail()));
        msg.setSubject("Forgot Password Request");
        msg.setContent("To complete the password reset process, please click here: "
                + "http://localhost:8080/confirmReset?token=" +confirmationToken.getConfirmationToken(), "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);



    }


}
