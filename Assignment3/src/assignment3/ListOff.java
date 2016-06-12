package assignment3;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListOff implements Runnable {
	public static TeacherPage2014302580061  teacherPage;
	
	public static void connect()throws IOException, SQLException{
		File input = new File("D:/Ô´Âë±¸µµ/eclipse´úÂë/Assignment3/test.html"); 
		 Document doc = Jsoup.parse(input,"UTF-8","http://www.wpi.edu/academics/cs/research-interests.html"); 
		 Elements webContent = doc.select("div[class=half]");
	     Elements links=webContent.select("a[href]");
	     
	    
	     for (Iterator iter = links.iterator(); iter.hasNext();) { 
	    	 Element ele = (Element) iter.next();
	    	 try{
	    	 teacherPage.teacherPaper(ele.attr("href"));
	    	 }catch(Exception e1){
	    		 }
	    	 }
	}

	public void run(){
		try {
			connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
