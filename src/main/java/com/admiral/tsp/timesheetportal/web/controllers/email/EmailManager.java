package com.admiral.tsp.timesheetportal.web.controllers.email;

import com.admiral.tsp.timesheetportal.data.domain.User;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class EmailManager {
    public void sendManagerMail(User manager) throws AddressException, MessagingException, IOException {
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

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(manager.getEmail()));
        msg.setSubject("TSP-Manager Time Sheet Created ");
        msg.setContent("A time sheet has been created by a contractor please review", "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);



    }
}
