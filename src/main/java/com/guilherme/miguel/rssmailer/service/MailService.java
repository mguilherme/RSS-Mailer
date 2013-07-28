package com.guilherme.miguel.rssmailer.service;

/**
 * Mail Service Interface
 * @author Miguel Guilherme
 *
 */
public interface MailService {

	/**
	 * Sends an email
	 * @param from 
	 * @param to
	 * @param subject
	 * @param body
	 */
	public void sendMail(String from, String to, String subject, String body);
	
	/**
	 * 
	 * @param alert alert message
	 */
	public void sendAlertMail(String alert);
	
}
