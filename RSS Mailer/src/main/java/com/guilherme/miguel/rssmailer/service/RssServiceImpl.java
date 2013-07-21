package com.guilherme.miguel.rssmailer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.miguel.rssmailer.model.FeedItem;
import com.guilherme.miguel.rssmailer.rss.RssReader;

/**
 * RSS Service
 * @author Miguel Guilherme
 *
 */
@Service
public class RssServiceImpl implements RssService {

	@Autowired
	private RssReader rssReader;
	
	@Override
	public FeedItem getFeed() {
		return rssReader.getFeed();
	}

}
