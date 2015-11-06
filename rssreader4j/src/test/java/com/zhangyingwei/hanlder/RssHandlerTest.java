package com.zhangyingwei.hanlder;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zhangyingwei.handler.RssHandler;
import com.zhangyingwei.model.RssModel;

public class RssHandlerTest {
	public static void main(String[] args) {
		String url = "http://blog.zhangyingwei.com/atom.xml";
//		String url = "http://www.zi-han.net/feed";
		RssModel rssmodel = RssHandler.buildRssModel(url);
		System.out.println(rssmodel.getRssHead());
		System.out.println(rssmodel.getRssEntitys());
	}
}
