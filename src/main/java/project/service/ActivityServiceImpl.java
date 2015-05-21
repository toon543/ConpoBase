package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.ActivityDAO;
import project.entity.Activity;
import project.entity.Image;
import project.entity.User;
import project.repository.UserRepository;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Punjasin on 5/13/2015.
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService{
@Autowired
ActivityDAO activityDAO;
    @Autowired
    UserRepository userRepository;

    @Override

    public List<Activity> getActivitys() {
        return activityDAO.getActivitys();
    }

    @Override
    public Activity getActivity(Long id) {
        return activityDAO.getActivity(id);
    }

    @Override
    public Activity addActivity(Activity activity) {
      final  String username="punjasinjapan@gmail.com";
       final String password="medic123";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            List<User> user=new ArrayList<User>(userRepository.findAll());
            for(int i=0;i<user.size();i++){


            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("no-reply@watpharsingh.clouldapp.net"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.get(i).getEmail()));
            message.setSubject("You have new Activity to check");
            message.setText("Dear Subscriber,"
                    + "\n\n New Activity has been added to the website \n please visit");
                Transport.send(message);

                System.out.println("Done");
            }




        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


        return activityDAO.addActivity(activity);
    }

    @Override
    public Activity deleteActivity(Long id) {
        Activity activity=activityDAO.getActivity(id);
        return activityDAO.deleteActivity(activity);
    }

    @Override
    public Activity updateActivity(Activity activity) {
        activity.setImages(activityDAO.getActivity(activity.getId()).getImages());
        return activityDAO.updateActivity(activity);
    }



    @Override

    public Activity addImage(Activity activity, Image image) {
        activity.getImages().add(image);
        activityDAO.updateActivity(activity);
        return activity;
    }
}
