package utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class SendMailSMTP {

    String filePath=System.getProperty("user.dir")+"/reports/reports_11-10-23-05-2024.html";

    public void sendMail(){
        String username="rishirajbasu456@gmail.com";
        String password="rmwl swus aiai xhxn";
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(username));
        
            message.setRecipients(
            Message.RecipientType.TO, InternetAddress.parse("rishimark7@gmail.com"));
            message.setSubject("Extent Reports");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        MimeMultipart multipart =null;
        String msg = "Sending mail with Extent Reports attached";
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        try {
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
            multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        try {
            attachmentBodyPart.attachFile(new File(filePath));
            Transport.send(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
