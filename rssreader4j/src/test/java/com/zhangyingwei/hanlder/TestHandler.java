package com.zhangyingwei.hanlder;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.junit.Test;
import com.zhangyingwei.rssreader4j.handler.XmlHandler;
import com.zhangyingwei.rssreader4j.model.RssEntity;
import com.zhangyingwei.rssreader4j.model.RssHead;

public class TestHandler {
	
	@Test
	public static void test1() throws Exception{
//		String url = "http://blog.zhangyingwei.com/atom.xml";
		String url = "http://blog.daimajia.com/feed/";
		Document document = XmlHandler.readDocument(url);
		List<Element> es = ((Element) document.getRootElement().elements().get(0)).elements();
		for(Element ele:es){
			System.out.println(ele.getName());
		}
//		System.out.println(e.getName());
//		System.out.println(e.getText());
	}
	
	public void test2() throws Exception{
		String url = "http://blog.zhangyingwei.com/atom.xml";
		Document document = XmlHandler.readDocument(url);
		RssHead rssHead = XmlHandler.readRssHead(document.getRootElement());
		System.out.println(rssHead);
	}
	
	public static void test3() throws Exception{
//		String url = "http://blog.zhangyingwei.com/atom.xml";
		String url = "http://blog.daimajia.com/feed/";
		Document document = XmlHandler.readDocument(url);
		List<RssEntity> rssEntitys = XmlHandler.readRssEneity(document.getRootElement());
		for(RssEntity entity:rssEntitys){
			System.out.println(entity);
		}
	}
	
	public static void main(String[] args) throws Exception {
//		String url = "http://blog.zhangyingwei.com/atom.xml";
////		String url = "http://blog.daimajia.com/feed/";
//		Document document = XmlHandler.readDocument(url);
//		RssHead rssHead = XmlHandler.readRssHead(document.getRootElement());
//		System.out.println(rssHead);
		
		test3();
	}
}
