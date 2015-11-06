package com.zhangyingwei.handler;

import java.util.List;

import org.dom4j.Document;

import com.zhangyingwei.exception.AppException;
import com.zhangyingwei.model.RssEntity;
import com.zhangyingwei.model.RssHead;
import com.zhangyingwei.model.RssModel;

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
			throw new AppException("@:build rsshead err", e);
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
			throw new AppException("@:build rssentity err", e);
		}
		return rssEntitys;
	}
}
