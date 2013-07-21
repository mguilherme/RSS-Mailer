package com.guilherme.miguel.rssmailer.rss;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.guilherme.miguel.rssmailer.model.FeedItem;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * RSS Reader Implementation
 * @author Miguel Guilherme
 *
 */
@Component
public class RssReader {

	private final Logger log = LoggerFactory.getLogger(RssReader.class);

	@Value(value = "${feed.url}")
	private String feedUrl;

	private URL url;
	private XmlReader reader;
	private SyndEntry lastEntry;

	@PostConstruct
	public void init() {
		try {
			url = new URL(feedUrl);
		} catch (MalformedURLException e) {
			log.error("There's some problem with your url", e.getMessage());
		}
	}

	/**
	 * Retrieve the last available feed item, null if it's already in memory.
	 * @return the last available feed item
	 */
	public FeedItem getFeed() {
		FeedItem feedItem = null;
		
		try {
			reader = new XmlReader(url);
			SyndFeed feed = new SyndFeedInput().build(reader);
			SyndEntry newEntry = ((SyndEntry)feed.getEntries().get(0));
			
			if(lastEntry == null || newEntry.getPublishedDate().after(lastEntry.getPublishedDate())) {
				log.info("Retrieving new feed.");
				lastEntry = newEntry;
				feedItem = populateFeedItem(lastEntry);
			}
			
		} catch (IllegalArgumentException | FeedException | IOException e) {
			log.error("There's a problem trying to read feed", e.getMessage());
		}
		
		return feedItem;
	}
	
	/**
	 * Populates a {@link FeedItem} instance and retrieve them.
	 * @param syndEntry a {@link SyndEntry} instance
	 * @return a {@link FeedItem} instance
	 */
	private FeedItem populateFeedItem(SyndEntry syndEntry) {
		FeedItem feedItem = new FeedItem();
		feedItem.setDescription(syndEntry.getDescription().getValue());
		feedItem.setAuthor(syndEntry.getAuthor());
		feedItem.setPublishedDate(syndEntry.getPublishedDate());
		
		return feedItem;
	}
	
}
