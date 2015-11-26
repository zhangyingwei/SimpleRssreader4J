package com.zhangyingwei.rssreader4j.handler;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zhangyingwei.rssreader4j.exception.RssAppException;
import com.zhangyingwei.rssreader4j.model.RssEntity;
import com.zhangyingwei.rssreader4j.model.RssHead;
import com.zhangyingwei.rssreader4j.model.RssModel;

public class XmlHandler {
	
	/**
	 * 根据url读取document对象
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static Document readDocument(String url) throws Exception{
		Document document = null;
		if(url==null||url.equals("")||url.length()==0) throw new RssAppException("@:url is empty");
		try {
			URL path = new URL(url);
			SAXReader reader = new SAXReader();
			document = reader.read(path);
		} catch (MalformedURLException e) {
			throw new RssAppException("@:url err", e);
		} catch (DocumentException e) {
			throw new RssAppException("@:xml read err", e);
		}
		return document;
	}
	
	/**
	 * 获取root节点
	 * @param document
	 * @return
	 */
	public static Element getRootElement(Document document){
		return document.getRootElement();
	}
	
	public static RssHead readRssHead(Element rootElement){
		if(rootElement.getName().equals(RssModel.TYPE_FEED)){
			return new RssHead(rootElement.elementText("title"),
					findLink(rootElement),
					rootElement.elementText("updated"),
					null);
		}else if(rootElement.getName().equals(RssModel.TYPE_RSS)){
			return new RssHead(rootElement.element("channel").elementText("title"),
					findLink(rootElement.element("channel")),
					rootElement.element("channel").elementText("lastBuildDate"),
					rootElement.element("channel").elementText("description"));
		}
		return null;
	}
	
	public static List<RssEntity> readRssEneity(Element rootElement){
		List rssEntitys = new ArrayList();
		if(rootElement.getName().equals(RssModel.TYPE_FEED)){
			for(Element e:(List<Element>)rootElement.elements("entry")){
				rssEntitys.add(new RssEntity(e.elementText("title"),
						e.element("link").attributeValue("href"),
						e.elementText("content"), 
						e.elementText("updated"), 
						e.elementText("summary")));
			}
		}else if(rootElement.getName().equals(RssModel.TYPE_RSS)){
			for(Element e:(List<Element>)rootElement.element("channel").elements("item")){
				rssEntitys.add(new RssEntity(e.elementText("title"),
						e.elementText("link"),
						e.elementText("content"), 
						e.elementText("pubDate"), 
						e.elementText("description")));
			}
		}
		return rssEntitys;
	}
	
	private static String findLink(Element e){
		List<Element> eles = e.elements("link");
		for(Element ele:eles){
			if(ele.getText()!=null&&ele.getText()!=""){
				return ele.getText();
			}else if(ele.attributeValue("rel")==null||ele.attributeValue("rel")==""){
				return ele.attributeValue("href");
			}
		}
		return null;
	}
}
