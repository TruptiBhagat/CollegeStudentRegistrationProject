package com.app.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailSenderService {
	@Autowired
	private JavaMailSender jms;
	
	public void sendEmail(String body,String subject,String to) {
		
		SimpleMailMessage smg = new SimpleMailMessage();
		smg.setText(body);
		smg.setSubject(subject);
		smg.setTo(to);
		jms.send(smg);
	}
	
	public void sendEmailMime(String body, String subject, String to) throws Exception {

	    MimeMessage mim = jms.createMimeMessage();
	    MimeMessageHelper mmh = new MimeMessageHelper(mim, false); // false = no attachment

	    mmh.setText(body, true);
	    mmh.setSubject(subject);
	    mmh.setTo(to);
	    mmh.setFrom("bhagattrupti19@gmail.com"); // always set from

	    jms.send(mim);
	}

}
