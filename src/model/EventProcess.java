package com.model;

import java.util.ArrayList;

/**
 * Created by WeiRenChen on 2016/6/13.
 */
public class EventProcess {
	private ArrayList<Event> eventList;
	
	public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    public ArrayList<Event> eventSelect(ArrayList<Event> eList, String[] clubList) {
        return eList;
    }

    public String toJson(ArrayList<Event> eList) {
		StringBuffer s = new StringBuffer("{ \"events\": [");
     //return "{ \"events\": [ { \"media\": { \"url\": \"http://gec.nuk.edu.tw/ezfiles/1/1001/pictures/372/part_3773_9185833_91240.jpg\" }, \"start_date\": { \"year\": \"2016\", \"month\": \"9\", \"day\": \"24\" }, \"text\": { \"headline\": \"<a href ='/EventInfoServlet.do?id=0' >2016Join The World青年領袖民主營</a>\", \"text\": \"(代表台灣免費參加國際會議)二天一夜的課程，與全國最優秀的青年領袖們一起向最頂尖的講者請益國際民主事務潛能。課程主題包括『培養鍛鍊團隊溝通』、『自我價值成長』、『如何參與國際事務』、『外交官看世界』、『大師觀點--國際政治經濟的脈動以及實際與外籍青年互動的『國際之夜』等，課程精彩豐富，是絕對不能錯過的擴展國際視野營隊！！\" } }, { \"media\": { \"url\": \"https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/12347900_496405827200968_672082238145456609_n.png?oh=662382e0449427d87dfff155283a6cb5&oe=57CE21F0\" }, \"start_date\": { \"year\": \"2016\", \"month\": \"6\", \"day\": \"16\" }, \"text\": { \"headline\": \"<a href ='/EventInfoServlet.do?id=1' >薈萃坊企業參訪阿默蛋糕工廠</a>\", \"text\": \"感謝 孫寶年教授幫忙介紹，這學期薈萃坊團隊有幸能參觀 阿默蛋糕企業工廠！（聽說阿默品管十分嚴苛常規都是拒絕參觀的！）\" } }, { \"media\": { \"url\": \"https://scontent-tpe1-1.xx.fbcdn.net/l/t31.0-8/s960x960/13418596_1163327487031344_3758416313258538140_o.jpg\" }, \"start_date\": { \"year\": \"2016\", \"month\": \"6\", \"day\": \"16\" }, \"text\": { \"headline\": \"<a href ='/EventInfoServlet.do?id=1' >★★★2016鷗海YO演唱會~~</a>\", \"text\": \"18:00 在育樂館前X型廣場 2016海大畢業演唱會\" } } ] }";
        for(Event e:eList){
			StringBuffer ss = new StringBuffer("{ \"media\": { \"url\": \"");
			ss.append(e.getImgPath());
			ss.append("\" }, \"start_date\": { \"year\": \"");
			ss.append(String.valueOf(e.getYear()));
			ss.append("\", \"month\": \"");
			ss.append(String.valueOf(e.getMonth()));
			ss.append("\", \"day\": \"");
			ss.append(String.valueOf(e.getDay()));
			ss.append("\" }, \"text\": { \"headline\": \"<a href ='/EventInfo.do?id=");
			ss.append(String.valueOf(e.getId()));
			ss.append("'>");
			ss.append(e.getName());
			ss.append("</a>\", \"text\": \"");
			ss.append(e.getPreview());
			ss.append("\"}},");
			s.append(ss);
		}
		s.deleteCharAt(s.length()-1);
		s.append("]}");
		return s.toString();
    }
	public String removeLastChar(String s) {
    if (s == null || s.length() == 0) {
        return s;
    }
    return s.substring(0, s.length()-1);
}
}
