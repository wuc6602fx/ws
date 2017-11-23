package com.web;


import com.model.Event;
import com.model.EventProcess;
import com.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class IndexServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter(); 
		response.setContentType("text/html;charset=UTF-8");	
		
		EventProcess ep = (EventProcess) getServletContext().getAttribute("event");
		if(ep==null){
			System.out.println(">>Make test data");
		/***test data***/
			ArrayList<Event> testEventList = new ArrayList<Event>(); 
			Event e = new Event(0,"休閒娛樂","2016Join The World青年領袖民主營","(代表台灣免費參加國際會議)二天一夜的課程，與全國最優秀的青年領袖們一起向最頂尖的講者請益國際民主事務潛能。課程主題包括『培養鍛鍊團隊溝通』、『自我價值成長』、『如何參與國際事務』、『外交官看世界』、『大師觀點--國際政治經濟的脈動以及實際與外籍青年互動的『國際之夜』等，課程精彩豐富，是絕對不能錯過的擴展國際視野營隊！！","<p class='MsoNormal'><strong><span style='font-size: 30px;'><span style='color: rgb(155, 187, 89);'>參加方式</span></span></strong></p><p class='MsoNormal' style='margin-bottom: 10px; font-family: 'Lantinghei TC Extralight', 'Microsoft JhengHei', Arial; line-height: 20px; background-color: rgb(255, 255, 255);'>【參加對象】全國大專院校一年級(含)以上至研究所碩士班在學學生<br></p><p class='MsoNormal' style='margin-bottom: 10px; font-family: 'Lantinghei TC Extralight', 'Microsoft JhengHei', Arial; line-height: 20px; background-color: rgb(255, 255, 255);'>【報名時間】即日起至6/12&nbsp;(SUN)&nbsp;23:59</p><p class='MsoNormal' style='margin-bottom: 10px; font-family: 'Lantinghei TC Extralight', 'Microsoft JhengHei', Arial; line-height: 20px; background-color: rgb(255, 255, 255);'>【公佈時間】7/7 <span style='font-size: 10px;'>(THU)</span>&nbsp;17:00&nbsp; <span style='background-color: rgb(229, 185, 183);'>&nbsp; &nbsp;&nbsp;</span><strong><span style='background-color: rgb(75, 172, 198);'><span style='color: rgb(192, 80, 77);'><span style='background-color: rgb(95, 73, 122);'><span style='color: rgb(242, 195, 20);'><span style='background-color: rgb(149, 55, 52);'>&nbsp;公佈!!!&nbsp;</span></span></span></span></span></strong></p><p class='MsoNormal' style='margin-bottom: 10px; font-family: 'Lantinghei TC Extralight', 'Microsoft JhengHei', Arial; line-height: 20px; background-color: rgb(255, 255, 255);'>【活動時間】9/24 <span style='font-size: 10px;'>(SAT)</span>&nbsp;-&nbsp;9/25 <span style='font-size: 10px;'>(SUN)</span> </p><p class='MsoNormal' style='margin-bottom: 10px; font-family: 'Lantinghei TC Extralight', 'Microsoft JhengHei', Arial; line-height: 20px; background-color: rgb(255, 255, 255);'>【主辦單位】<span style='color: rgb(84, 141, 212);'><strong><span style='color: rgb(141, 179, 226);'><a href='http://www.zephyr.org.tw/' target='_blank' rel='nofollow'>季風文教基金會</a>&nbsp;</span><a href='http://www.zephyr.org.tw/' target='_blank' rel='nofollow'></a></strong></span>&nbsp;<a href='https://www.facebook.com/zephyrorg/' target='_blank' rel='nofollow'><img src='https://az796311.vo.msecnd.net/userupload/bd99bef0bf9e4ca4bfd106b794f347e1.jpg' alt=''></a>&nbsp;、&nbsp;<a href='http://www.newtaiwanese.org.tw/main.php' target='_blank' rel='nofollow'><strong>新台灣人文教基金會</strong></a> </p><p class='MsoNormal' style='margin-bottom: 10px; font-family: 'Lantinghei TC Extralight', 'Microsoft JhengHei', Arial; line-height: 20px; background-color: rgb(255, 255, 255);'><span></span>【講者】高希均、金溥聰、羅智成、王文華、郭壽旺等（講師邀約中）</p><p class='MsoNormal' style='margin-bottom: 10px; font-family: 'Lantinghei TC Extralight', 'Microsoft JhengHei', Arial; line-height: 20px; background-color: rgb(255, 255, 255);'>【地點】台北&nbsp;/&nbsp;劍潭清活動中心&nbsp;<span lang='EN-US'>(</span>台北市士林區中山北路四段16號<span lang='EN-US'>)<o:p></o:p></span></p><p class='MsoNormal' style='margin-bottom: 10px; font-family: 'Lantinghei TC Extralight', 'Microsoft JhengHei', Arial; line-height: 20px; background-color: rgb(255, 255, 255);'>【內容】營隊 <span style='color: rgb(242, 195, 20);'>x</span> 演講 <span style='color: rgb(242, 195, 20);'>x</span> 世界咖啡館</p><p class='MsoNormal' style='margin-bottom: 10px; font-family: 'Lantinghei TC Extralight', 'Microsoft JhengHei', Arial; line-height: 20px; background-color: rgb(255, 255, 255);'>【報名資料】<br></p><ol start='1' type='1'><li class='MsoNormal'><strong><span style='color: rgb(247, 150, 70);'>英文影片（30%)：以英文自我介紹，影片長度以2分鐘為限，影片上傳至Youtube。</span></strong></li><li class='MsoNormal'><strong><span style='color: rgb(247, 150, 70);'>申論題(50%)：「台灣問題翻轉的契機」(600字以內) (以中文撰寫）</span></strong></li><li class='MsoNormal'><strong><span style='color: rgb(247, 150, 70);'>加分項目(20%)：社團經驗、獲獎經驗等等。</span></strong><span lang='EN-US'><o:p></o:p></span></li></ol><p class='MsoNormal' style='margin-bottom: 10px; line-height: 20px; background-color: rgb(255, 255, 255); font-family: 'Lantinghei TC Extralight', 'Microsoft JhengHei', Arial;'>【費用】新台幣 2,000 (未入選者全額退費，入選者於二天一夜活動結束後，退還保證金1,000元）</p>","http://gec.nuk.edu.tw/ezfiles/1/1001/pictures/372/part_3773_9185833_91240.jpg",2016,9,24,12,0,71);
			ArrayList<Applicant> aList = new ArrayList<Applicant>();
			Applicant a = new Applicant("吳明儒","資工","00257001",Applicant.Sex.MALE);
			aList.add(a);
			Applicant b = new Applicant("陳金冰","電機","00257003",Applicant.Sex.MALE);
			aList.add(b);
			Applicant c = new Applicant("吳大漢","醫學","00257007",Applicant.Sex.MALE);
			aList.add(c);
			e.setApplicantList(aList);
			testEventList.add(e);
			Event f = new Event(1,"升學就業","薈萃坊企業參訪阿默蛋糕工廠","感謝 孫寶年教授幫忙介紹，這學期薈萃坊團隊有幸能參觀 阿默蛋糕企業工廠！（聽說阿默品管十分嚴苛常規都是拒絕參觀的！）","因為機會十分難得～教授希望讓更多學生可以了解深入企業實作及薈萃坊經營團隊在此開放少量名額給予積極主動且有興趣瞭解更多的學生～免費與我們一同企業參訪！👉名額有限！報名請洽 薈萃坊粉絲專頁👉有意願加入薈萃坊團隊者可告知粉專，會優先考","https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/12347900_496405827200968_672082238145456609_n.png?oh=662382e0449427d87dfff155283a6cb5&oe=57CE21F0",2016,6,16,15,30,124);
			Applicant aa = new Applicant("吳雅雯","國貿","00257010",Applicant.Sex.FEMALE);
			aList.add(aa);
			Applicant ab = new Applicant("王上姍","應外","00257002",Applicant.Sex.FEMALE);
			aList.add(ab);
			Applicant ac = new Applicant("王智季","中文","00257006",Applicant.Sex.FEMALE);
			aList.add(ac);
			Applicant ad = new Applicant("邱卉豐","通訊","00257004",Applicant.Sex.MALE);
			aList.add(ad);
			Applicant ae = new Applicant("陳毅瑋","生科","00257008",Applicant.Sex.MALE);
			aList.add(ae);
			testEventList.add(f);
			Event g = new Event(2,"音樂藝術","★★★2016鷗海YO演唱會~~","18:00 在育樂館前X型廣場 2016海大畢業演唱會","‪#‎highyoung鷗海yo‬‪#‎highyiung鷗海yo畢業演唱會‬‪#‎玖壹壹‬‪#‎閻奕格‬‪#‎郭靜‬‪#‎宇宙人‬‪#‎林愷倫‬‪#‎Karen‬‪#‎張立東‬‪#‎鄧福如‬‪#‎187INC‬‪#‎賴慈泓‬#鄧福如‪#‎小宇‬","https://scontent-tpe1-1.xx.fbcdn.net/l/t31.0-8/s960x960/13418596_1163327487031344_3758416313258538140_o.jpg",2016,6,16,18,0,912);
			Applicant ba = new Applicant("王智季","中文","00257006",Applicant.Sex.FEMALE);
			aList.add(ba);
			Applicant bb = new Applicant("張家玉","應外","00257009",Applicant.Sex.FEMALE);
			aList.add(bb);
			Applicant bc = new Applicant("陳昱茹","森林","00257011",Applicant.Sex.FEMALE);
			aList.add(bc);
			Applicant bd = new Applicant("吳明儒","資工","00257001",Applicant.Sex.MALE);
			aList.add(bd);
			Applicant be = new Applicant("陳毅瑋","生科","00257008",Applicant.Sex.MALE);
			aList.add(be);
			Applicant bf = new Applicant("邱卉豐","通訊","00257004",Applicant.Sex.MALE);
			aList.add(bf);
			testEventList.add(g);
			Event h = new Event(3,"升學就業","物聯網實物教學平台演講","各位同學好 資工系特邀請飆機器人_普特企業王經理前來介紹雲端物聯網(IOT)實物教學平台 時間：105/6/24(五)9:20~17:00 地點：205教室","詳細請看資工系公告‬","https://upload.wikimedia.org/wikipedia/commons/a/ab/Internet_of_Things.jpg",2016,6,24,9,20,69);
			Applicant ca = new Applicant("陳士銘","物理","00257012",Applicant.Sex.MALE);
			aList.add(ca);
			Applicant cb = new Applicant("張家玉","應外","00257009",Applicant.Sex.FEMALE);
			aList.add(cb);
			Applicant cc = new Applicant("吳雅雯","森林","00257010",Applicant.Sex.FEMALE);
			aList.add(cc);
			Applicant cd = new Applicant("王上姍","應外","00257002",Applicant.Sex.FEMALE);
			aList.add(cd);
			testEventList.add(h);
			Event i = new Event(4,"升學就業","『翻譯工讀生及義工』招募活動","美國教育基金會每年舉辦兩次美國教育展，展覽期間招募及培訓對美國教育文化有興趣、有熱情的在校學生擔任翻譯工讀生及義工。教育展的翻譯及義工是臺灣同學與美國校方的溝通橋樑。","美國教育基金會每年舉辦兩次美國教育展，展覽期間招募及培訓對美國教育文化有興趣、有熱情的在校學生擔任翻譯工讀生及義工。教育展的翻譯及義工是臺灣同學與美國校方的溝通橋樑。","http://www.aief-usa.org/sites/default/files/aief%20logo%202015_0.jpg",2016,6,29,0,0,241);
			Applicant da = new Applicant("朱順夫","機械","00257014",Applicant.Sex.MALE);
			aList.add(da);
			Applicant db = new Applicant("陳毅瑋","生科","00257008",Applicant.Sex.MALE);
			aList.add(db);
			Applicant dc = new Applicant("陳士銘","物理","00257012",Applicant.Sex.MALE);
			aList.add(dc);
			Applicant dd = new Applicant("張家玉","應外","00257009",Applicant.Sex.FEMALE);
			aList.add(dd);
			Applicant de = new Applicant("吳大漢","醫學","00257007",Applicant.Sex.MALE);
			aList.add(de);
			testEventList.add(i);
			Event j = new Event(5,"音樂藝術","相聲瓦舍《賣橘子的》","遊走紫湖畔，遇見馮翊綱的浪漫情懷；登上五行山，撞見宋少卿的恣意江湖；躲進松林裡，窺見黃士偉的風情萬種。一部集結《西遊記》唐僧師徒、《水滸傳》梁山好漢以及《三國演義》群雄豪傑的相聲作品。","‪遊走紫湖畔，遇見馮翊綱的浪漫情懷；登上五行山，撞見宋少卿的恣意江湖；躲進松林裡，窺見黃士偉的風情萬種。一部集結《西遊記》唐僧師徒、《水滸傳》梁山好漢以及《三國演義》群雄豪傑的相聲作品。‬","https://scontent.cdninstagram.com/t51.2885-15/e15/1172917_722423961192127_2000300105_n.jpg?ig_cache_key=MTE1Njk2MzM4MzcxNzkyMTQ0Ng%3D%3D.2",2016,6,14,18,0,121);
			Applicant ea = new Applicant("李雅茹","會計","00257005",Applicant.Sex.FEMALE);
			aList.add(ea);
			Applicant eb = new Applicant("楊舒杰","應外","00257017",Applicant.Sex.MALE);
			aList.add(eb);
			Applicant ec = new Applicant("王上姍","應外","00257002",Applicant.Sex.FEMALE);
			aList.add(ec);
			Applicant ed = new Applicant("陳昱茹","森林","00257011",Applicant.Sex.FEMALE);
			aList.add(ed);
			testEventList.add(j);
			Event k = new Event(6,"音樂藝術","孤女的願望-柳依蘭傳奇","圖書館1F，如果你對於柳依蘭老師想要進一步了解，千萬不要錯過專題講座。蕭瓊瑞老師略帶沙啞嗓音，搭配優美的音樂，將柳依蘭的傳奇，深深印入你的腦中，絕對要聽一次的演講，千萬不要錯過。(開放旁聽~)","‪圖書館1F，如果你對於柳依蘭老師想要進一步了解，千萬不要錯過專題講座。蕭瓊瑞老師略帶沙啞嗓音，搭配優美的音樂，將柳依蘭的傳奇，深深印入你的腦中，絕對要聽一次的演講，千萬不要錯過。(開放旁聽~)","http://artouch.com/imagefile/modern/1/2016041816046-1.jpg",2016,4,28,0,0,132);
			Applicant fa = new Applicant("吳雅雯","國貿","00257010",Applicant.Sex.FEMALE);
			aList.add(fa);
			Applicant fb = new Applicant("李雅茹","會計","00257005",Applicant.Sex.FEMALE);
			aList.add(fb);
			Applicant fc = new Applicant("吳明儒","資工","00257001",Applicant.Sex.MALE);
			aList.add(fc);
			Applicant fd = new Applicant("陳毅瑋","生科","00257008",Applicant.Sex.MALE);
			aList.add(fd);
			Applicant fe = new Applicant("王上姍","應外","00257002",Applicant.Sex.FEMALE);
			aList.add(fe);
			testEventList.add(k);
			Event l = new Event(7,"休閒娛樂","2016螢火蟲季","本校螢火蟲季系列活動迄今已16年。龍崗生態園區孕育著豐富自然生態，每年春季4-5月螢火蟲繁殖期間，辦理螢火蟲季系列解說導覽活動，邀請社區民眾共同來賞螢，成效良好。透過生態解說及導覽，倡導賞螢保育觀念及正確知識，同時推廣相關自然生態教育，歡迎報名參加。","國立臺灣海洋大學螢火蟲系列活動 (105年4月30日~105年5月8日) 【105年4月13日(三)上午9：00開放網路預約報名】 網路預約報名網址：(網路報名已額滿) https://www.beclass.com/rid=1939f9256fea0d06ce9c 本校螢火蟲季系列活動迄今已16年。龍崗生態園區孕育著豐富自然生態，每年春季4-5月螢火蟲繁殖期間，辦理螢火蟲季系列解說導覽活動，邀請社區民眾共同來賞螢，成效良好。透過生態解說及導覽，倡導賞螢保育觀念及正確知識，同時推廣相關自然生態教育，歡迎報名參加。 (一)螢火蟲季系列活動開幕 1、時間：105年5月2日(一) 17：30 2、地點：海洋大學展示廳 3、開幕式由本校學生社團表演 (二)龍崗生態園區螢火蟲生態解說預約導覽，並安排現場解說 1、每日晚上2個場次：18：00、19:00 2、現場排隊登記時間：17：30、18：30 3、每場次活動全程約一小時 4、每場次開放【網路預約報名】平日30名、假日35名 【現場報名】每場限50名 每日每場總計上限85名 5、假日龍崗生態園區解說導覽場次：10：30、15：30(各一場) 6、網路報到及現場報名登記地點：本校展示廳 (三)生態展示 1、時間：105年4月30日(六)~5月8日(日) 平日17：30-21：00、假日9：00-21：00 2、地點：展示廳 3、展示內容： (1)生態海報：由解說員以及熱帶生物研究社製作生態海報，讓民眾藉由海報吸收生態知識以及環境保育之重要性。 (2)各式生物活體展示：展示代表性的龍崗生態園區原生物種、原生魚、節肢動物、外來種、爬蟲以及螢火蟲。 (3)天文海報及互動區：由天文社製作，讓民眾藉由海報了解天文知識。 (四)紀念品發放方式 1、填寫完展區問卷並集滿四個章 2、於解說場次中回答解說員問題 3、與展區照相版合照並上傳臉書打卡 (五)停車地點 本校校內有收費停車場(計時收費，停車費每小時30元)；或可停於濱海校門口對面小艇碼頭停車場(免費) (六)注意事項 1、請穿著長袖、長褲與運動鞋等，以免被蚊蟲叮咬、蛇咬傷。 2、請自備手電筒，亮度達可照路程度即可，太亮會影響螢火蟲，並用紅色玻璃紙套住手電筒照路，請勿將光源直照螢火蟲。 3、如需紅色玻璃紙，可以至展示廳免費索取，用畢需回收。 4、請勿使用閃光燈拍照，會傷害螢火蟲。 5、尊重生命，不任意捕捉或帶回，讓牠們能繼續繁衍後代。 6、夜間賞螢，安全第一；山路危險，請勿嬉鬧、單獨行動。 7、具有特殊疾病、行動不便的遊客，請謹慎考慮上山與否。 8、舉手之勞做環保，請做好垃圾減量、分類，不亂丟垃圾。 9、若當天下雨，為避免意外，會視情況而定是否上山賞螢。 10、活動期間將進行人數管制，無預約不可自行上山。 11、若有其他任何問題，可至展示廳詢問海洋大學生態解說員，我們將熱情地為您答覆。","http://www.taiwanreports.url.tw/wp-content/uploads/2016/04/%E7%85%A7-%E6%B5%B7%E5%A4%A7%E8%9E%A2%E7%81%AB%E8%9F%B2%E5%AD%A34.30%E7%99%BB%E5%A0%B4-%E9%96%8B%E6%94%BE%E7%B6%B2%E8%B7%AF%E9%A0%90%E7%B4%84%E5%B0%8E%E8%A6%BD.jpg",2016,4,30,0,0,632);
			Applicant ga = new Applicant("陳金冰","電機","00257003",Applicant.Sex.MALE);
			aList.add(ga);
			Applicant gb = new Applicant("邱卉豐","通訊","00257004",Applicant.Sex.MALE);
			aList.add(gb);
			Applicant gc = new Applicant("陳毅瑋","生科","00257008",Applicant.Sex.MALE);
			aList.add(gc);
			Applicant gd = new Applicant("陳士銘","物理","00257012",Applicant.Sex.MALE);
			aList.add(gd);
			Applicant ge = new Applicant("吳雅雯","國貿","00257010",Applicant.Sex.FEMALE);
			aList.add(ge);
			testEventList.add(l);
			Event m = new Event(8,"音樂藝術","台北聯合大學系統聯合推廣活動-王傑四校巡迴展","王傑是巴塞隆納大學美術博士，畫家、作家、插畫家，現為文化大學推廣部旅遊速寫課程講師，並於個人畫室開設各類繪畫課程。","‪王傑是巴塞隆納大學美術博士，畫家、作家、插畫家，現為文化大學推廣部旅遊速寫課程講師，並於個人畫室開設各類繪畫課程。","http://www.ntpu.edu.tw/college/e9/files/e9_announce/20160422144432.jpg",2016,10,25,0,0,517);
			Applicant ha = new Applicant("陳必彬","會計","00257013",Applicant.Sex.MALE);
			aList.add(ha);
			Applicant hb = new Applicant("陳昱茹","森林","00257011",Applicant.Sex.FEMALE);
			aList.add(hb);
			Applicant hc = new Applicant("吳大漢","醫學","00257007",Applicant.Sex.MALE);
			aList.add(hc);
			Applicant hd = new Applicant("吳雅雯","國貿","00257010",Applicant.Sex.FEMALE);
			aList.add(hd);
			Applicant he = new Applicant("吳雅雯","國貿","00257010",Applicant.Sex.FEMALE);
			aList.add(he);
			testEventList.add(m);
			Event n = new Event(9,"休閒娛樂","2016通訊之夜-屍訊我,","深夜裡，因病毒感染的殭屍入侵了校園，然而在一陣腥風血雨過後，由一群大學生組成的偵搜隊發現了背後更不為人知的祕密...","2016通訊之夜-屍訊我, 活動時間:5/17(二) 18:00進場 18:30開始 活動地點:海洋廳","https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13010760_268518100153694_6314432970223638662_n.jpg?oh=56a5bc6e889dab0d8168bf88e99d67e6&oe=57C416F8",2016,5,17,18,0,312);
			Applicant ia = new Applicant("陳必彬","會計","00257013",Applicant.Sex.MALE);
			aList.add(ia);
			Applicant ib = new Applicant("吳明儒","資工","00257001",Applicant.Sex.MALE);
			aList.add(ib);
			Applicant ic = new Applicant("陳金冰","電機","00257003",Applicant.Sex.MALE);
			aList.add(ic);
			Applicant id = new Applicant("朱順夫","機械","00257014",Applicant.Sex.MALE);
			aList.add(id);
			Applicant ie = new Applicant("陳立珍","護理","00257015",Applicant.Sex.FEMALE);
			aList.add(ie);
			testEventList.add(n);
			Event o = new Event(10,"休閒娛樂","2016資工之夜-決戰楓資谷","一年一度的資工之夜就此展開啦！！※還記得那年一起走過的魔法森林嗎？※還記得那年一起在船上被地域巴洛谷打死嗎？※還記得和朋友一起征服殘暴炎魔的滋味嗎？不要再猶豫，機會只有一次，心動不如趕快行動快來回味你/妳的曾經吧！！","‪準備好登入楓資谷了嗎😁😁😁😁😁小編已經等不及啦😂😂😂1800準時進場！！！！！！！！！！！快來～快來～快來～","https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13226874_626867477466611_2789512950914383113_n.jpg?oh=74bc3fa00c7bf56b82da543e58110417&oe=57C36B77",2016,6,6,18,30,1462);
			Applicant ja = new Applicant("許意甫","醫學","00257016",Applicant.Sex.MALE);
			aList.add(ja);
			Applicant jb = new Applicant("吳雅雯","護理","00257010",Applicant.Sex.FEMALE);
			aList.add(jb);
			Applicant jc = new Applicant("陳毅瑋","生科","00257008",Applicant.Sex.MALE);
			aList.add(jc);
			Applicant jd = new Applicant("宋曉玲","森林","00257050",Applicant.Sex.FEMALE);
			aList.add(jd);
			Applicant je = new Applicant("陳立珍","護理","00257015",Applicant.Sex.FEMALE);
			aList.add(je);
			testEventList.add(o);
			Event p = new Event(11,"升學就業","精誠資訊有限公司實習說明會","時間：13:30~14:30地點：資工系館105教室","時間：13:30~14:30地點：資工系館105教室","http://www.ezpr.com.tw/wp-content/uploads/2015/08/logo_systex_tw_%E7%B2%BE%E8%AA%A0%E8%B3%87%E8%A8%8A.jpg",2016,5,19,13,30,151);
			Applicant ka = new Applicant("陳必彬","會計","00257013",Applicant.Sex.MALE);
			aList.add(ka);
			Applicant kb = new Applicant("王上姍","應外","00257002",Applicant.Sex.FEMALE);
			aList.add(kb);
			Applicant kc = new Applicant("陳昱茹","森林","00257011",Applicant.Sex.FEMALE);
			aList.add(kc);
			Applicant kd = new Applicant("黃旭嘉","物理","00257018",Applicant.Sex.MALE);
			aList.add(kd);
			Applicant ke = new Applicant("林淳瑜","護理","00257036",Applicant.Sex.FEMALE);
			aList.add(ke);
			testEventList.add(p);
			
			
			
			
			EventProcess testEP = new EventProcess();
			testEP.setEventList(testEventList);
			getServletContext().setAttribute("event",testEP);
		/***************/	
		}
		
		ArrayList<Event> eList = ep.getEventList();
		if(eList==null){System.out.println("eList is null.\n");}
				
		/*******Filt event arraylist according user selection*/
		String[] clubList=(String[])request.getAttribute("club");
		eList = ep.eventSelect(eList,clubList);//get clubList to filt
				
		
		/*******make json file to timeline.js，and send to jsp via request**/
		String TLJsonFile = ep.toJson(eList);
		request.setAttribute("TLJsonFile",TLJsonFile);
				
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request,response); //next web
		}
}