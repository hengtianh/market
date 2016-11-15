package com.hengtian.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailUtil {
	private JavaMailSenderImpl mailSender;
    private MimeMessageHelper helper;
    
    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

	public void sendMail(String email, String realName) throws Exception {
        // Do the business calculations...
        // Call the collaborators to persist the order...
        // Create a thread safe "copy" of the template message and customize it
        MimeMessage msg = mailSender.createMimeMessage();
        helper = new MimeMessageHelper(msg,true,"utf-8");
        String message = "�װ��� " + realName
        		+ ", ��л��ע��. ��������˻� "
        		+"<a href='http://localhost:8080/market/users/active.action?email="+email+"'>����</a>";
        helper.setTo(email);
        helper.setFrom("tianhengyanzheng@163.com");
        helper.setText(message, true);
        try{
            mailSender.send(msg);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());

            throw new Exception("�ʼ�����ʧ��");
        }
    }
}
