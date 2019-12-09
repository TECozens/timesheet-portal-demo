package com.admiral.tsp.timesheetportal.web.controllers.email;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class EmailManager {
    public void sendManagerMail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("timeSheetPortal3@gmail.com", "Password03");
            }
        });//account not exist

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("timeSheetPortal3@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("timeSheetPortal3@gmail.com"));//manager of contractor making ts
        msg.setSubject("TSP Time Sheet Created ");
        msg.setContent("A time sheet has been created by a contractor please review", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("A time sheet has been created by a contractor please review\",", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        msg.setContent(multipart);
        Transport.send(msg);



    }
}
