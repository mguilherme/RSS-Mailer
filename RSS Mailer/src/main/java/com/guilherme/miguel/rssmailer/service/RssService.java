package com.guilherme.miguel.rssmailer.service;

import com.guilherme.miguel.rssmailer.model.FeedItem;

/**
 * RSS Service Interface
 * @author Miguel Guilherme
 *
 */
public interface RssService {

	/**
	 * Retrieve the last available feed item, null if it's already in memory.
	 * @return the last available feed item
	 */
	public FeedItem getFeed();
	
}
