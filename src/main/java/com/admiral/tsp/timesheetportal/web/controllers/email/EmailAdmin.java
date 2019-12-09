package com.admiral.tsp.timesheetportal.web.controllers.email;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
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
                return new PasswordAuthentication("timeSheetPortal@gmail.com", "password");
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("timeSheetPortal@gmail.com",false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("utorialspoint@gmail.com")); // all admin
        msg.setSubject("Time sheet has been approved ");
        msg.setContent(" A time sheet has been approved and waiting for an invoice", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(" A time sheet has been approved and waiting for an invoice ", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        msg.setContent(multipart);
        Transport.send(msg);


    }
}
