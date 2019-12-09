package com.admiral.tsp.timesheetportal.web.controllers.email;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class EmailContractorRejection {
    public void sendContractorMail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("timeSheetPortal3@gmail.com", "Password03");
            } //account not exist
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("timeSheetPortal3@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("timeSheetPortal3@gmail.com"));//contractor who made the sheet
        msg.setSubject("TSP-Contractor Time Sheet Rejection");
        msg.setContent("Your Time Sheet was rejected please make another" , "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);


    }
}
