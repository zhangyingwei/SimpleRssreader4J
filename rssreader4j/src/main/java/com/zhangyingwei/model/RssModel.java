package com.zhangyingwei.model;

import java.util.List;

import org.dom4j.Document;

public class RssModel {
	public static final String TYPE_FEED = "feed";
	public static final String TYPE_RSS = "rss";
	
	public RssModel(RssHead rssHead, List<RssEntity> rssEntity) {
		super();
		this.rssHead = rssHead;
		this.rssEntitys = rssEntity;
	}

	private RssHead rssHead;
	private List<RssEntity> rssEntitys;
	public RssHead getRssHead() {
		return rssHead;
	}
	public void setRssHead(RssHead rssHead) {
		this.rssHead = rssHead;
	}
	public List<RssEntity> getRssEntitys() {
		return rssEntitys;
	}
	public void setRssEntitys(List<RssEntity> rssEntity) {
		this.rssEntitys = rssEntity;
	}
}
