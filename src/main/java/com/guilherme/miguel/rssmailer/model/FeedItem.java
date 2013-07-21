package com.guilherme.miguel.rssmailer.model;

import java.util.Date;

/**
 * 
 * @author Miguel Guilherme
 *
 */
public class FeedItem {
	
	private String description;
	private String author;
	private Date publishedDate;

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Date getPublishedDate() {
		return publishedDate;
	}
	
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

}
