package com.zhangyingwei.rssreader4j.handler;

import java.util.List;
import org.dom4j.Document;
import com.zhangyingwei.rssreader4j.exception.RssAppException;
import com.zhangyingwei.rssreader4j.model.RssEntity;
import com.zhangyingwei.rssreader4j.model.RssHead;
import com.zhangyingwei.rssreader4j.model.RssModel;

public class RssHandler {
	
	/**
	 * 构建RssModel对象
	 * @param url
	 * @return
	 */
	public static RssModel buildRssModel(String url){
		return new RssModel(buildRssHead(url), buildRssEntitys(url));
	}
	
	/**
	 * 构建RssHead对象
	 * @param url
	 * @return
	 */
	public static RssHead buildRssHead(String url){
		RssHead rssHead = null;
		try {
			Document document = XmlHandler.readDocument(url);
			rssHead = XmlHandler.readRssHead(document.getRootElement());
		} catch (Exception e) {
			throw new RssAppException("@:build rsshead err", e);
		}
		return rssHead;
	}
	
	/**
	 * 构建RssEntitys对象
	 * @param url
	 * @return
	 */
	public static List<RssEntity> buildRssEntitys(String url){
		List<RssEntity> rssEntitys = null;
		try {
			Document document = XmlHandler.readDocument(url);
			rssEntitys = XmlHandler.readRssEneity(document.getRootElement());
		} catch (Exception e) {
			throw new RssAppException("@:build rssentity err", e);
		}
		return rssEntitys;
	}
}
