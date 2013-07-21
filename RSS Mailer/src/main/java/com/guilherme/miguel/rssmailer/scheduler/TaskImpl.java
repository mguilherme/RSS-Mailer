package com.guilherme.miguel.rssmailer.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.guilherme.miguel.rssmailer.model.FeedItem;
import com.guilherme.miguel.rssmailer.service.RssService;

/**
 * Task Implementation
 * @author Miguel Guilherme
 *
 */
@Component
public class TaskImpl implements Task {

	private final Logger log = LoggerFactory.getLogger(TaskImpl.class);
	
	@Autowired
	private RssService rssService;
	
	@Scheduled(cron = "${refresh.rate}")
	public void runJob() {
		// TODO: Create a Service to retrieve RSS
		FeedItem feedItem = rssService.getFeed();
		
		if(feedItem != null) {
			log.info("Description" + feedItem.getDescription());
			log.info("Author" + feedItem.getAuthor());
		}
		
	}
	
}
