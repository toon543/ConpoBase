package project.service.util;

/**
 * Created by Punjasin on 5/17/2015.
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class emailutil {
     String username ;
     String password ;
    Session session;
    Properties props ;
    public emailutil(){
        this.username="punjasinjapan@gmail.com";
        this.password="medic123";
        props= new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
         session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }

    public void sentemail(String email){

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("no-reply@watpharsingh.clouldapp.net"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("You have new Activity to check");
            message.setText("Dear Subscriber,"
                    + "\n\n New Activity has been added to the website \n please visit");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
