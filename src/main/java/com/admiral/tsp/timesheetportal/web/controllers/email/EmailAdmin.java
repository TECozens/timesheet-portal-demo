package com.admiral.tsp.timesheetportal.web.controllers.email;

import com.admiral.tsp.timesheetportal.data.jpa.user.UserJpa;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class EmailAdmin {
    public void sendAdminMail() throws AddressException, MessagingException, IOException {
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

     //List<KafkaProperties.Admin> adminEmails = UserJpa.getEmail(); //  list of admin emails referenced in list

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("timeSheetPortal3@gmail.com",false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("timeSheetPortal3@gmail.com")); // all admin
        msg.setSubject("TSP-Admin time sheet approved ");
        msg.setContent(" A time sheet has been approved and waiting for an invoice confirmation", "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);


    }
}
