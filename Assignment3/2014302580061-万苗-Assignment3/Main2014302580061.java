package assignment3;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Main2014302580061 {
    public static void main(String[] args) throws IOException, SQLException{
	long a=System.currentTimeMillis();
	ListOff launch=new ListOff();
	launch.run();
	System.out.println("\r<br>Ö´ÐÐºÄÊ± : "+(System.currentTimeMillis()-a)/1000f+" Ãë ");
     }
};
	

