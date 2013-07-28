package com.guilherme.miguel.rssmailer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Mail Service
 * @author Miguel Guilherme
 *
 */
@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private SimpleMailMessage alertMailMessage;

	@Override
	public void sendMail(String from, String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
	}

	@Override
	public void sendAlertMail(String alert) {
		SimpleMailMessage mailMessage = new SimpleMailMessage(alertMailMessage);
		mailMessage.setText(alert);
		mailSender.send(mailMessage);
	}

}
