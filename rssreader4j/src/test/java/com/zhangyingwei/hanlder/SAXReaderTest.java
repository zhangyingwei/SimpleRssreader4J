package com.zhangyingwei.hanlder;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import com.zhangyingwei.rssreader4j.handler.SSLHandler;
import com.zhangyingwei.rssreader4j.util.HttpUtil;

public class SAXReaderTest {
	public static void main(String[] args) throws Exception {
		String url = "https://luolei.org/rss/";
//		String url = "https://www.gehaowu.com/notes/atom.xml";
//		String url = "http://blog.zhangyingwei.com/atom.xml";
		SSLHandler.trustAllHosts();
		String ret = HttpUtil.sendGet(url, "");
//		File file = new File(url);
//		URL path = new URL(url);
		SAXReader reader = new SAXReader();
		Document document = reader.read("emp.xml");
		System.out.println(document.getRootElement().getName());
	}
}
