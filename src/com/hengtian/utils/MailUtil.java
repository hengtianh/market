package com.hengtian.utils;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.hengtian.po.User;

public class MailUtil {
	private MailSender mailSender;
    private SimpleMailMessage templateMessage;
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }
    
    public void sendMail(String email, String realName) throws Exception {
        // Do the business calculations...
        // Call the collaborators to persist the order...
        // Create a thread safe "copy" of the template message and customize it
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(email);
        msg.setText(
            "Ç×°®µÄ " + realName
                + ", ¸ÐÐ»Äú×¢²á. µã»÷¼¤»îÕË»§ "
                +"<a href='http://localhost:8080/market/users/active.action?email="+email+"'>¼¤»î</a>");
        try{
            mailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
            throw new Exception("ÓÊ¼þ·¢ËÍÊ§°Ü");
        }
    }
}
