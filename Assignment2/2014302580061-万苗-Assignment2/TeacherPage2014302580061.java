import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
  
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
 
public class TeacherPage2014302580061 {
    
     public  Document getDocument (String url){
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
             e.printStackTrace();
         }
         return null;
     }
 
     public static void main(String[] args) throws IOException {
    	File teacherPage=new File("teacherPage.txt");
    	BufferedWriter output1 = new BufferedWriter(new FileWriter(teacherPage,true));
    	Document doc = Jsoup.connect("http://staff.whu.edu.cn/show.jsp?lang=cn&n=Cheng%20Si-Xue").get(); 
    	Elements elements1 = doc.select("div[ class=content container]");
    	Elements elements2=elements1.select("h3");//爬取姓名
        String name = elements2.get(0).text();
        System.out.println("姓名："+name);
        
        
        output1.write("姓名："+name);
        output1.write("\r\n");
        
        Elements elements6 = doc.select("div[ class=details col-md-10 col-sm-9 col-xs-7]");
        String test = elements6.get(0).text();
        
        
         
        StringBuilder sb=new StringBuilder();
        StringBuilder sb1=new StringBuilder();
        Pattern pa = Pattern.compile("[0-9]");
        Pattern pa1 = Pattern.compile("[a-z]*+@+[a-z]*+.+([a-z]*)");
        
        Matcher ma = pa.matcher(test);  
        Matcher ma1 = pa1.matcher(test);
        String number=null;
        String email=null;
        
        while (ma.find())//利用正则表达式找到电话号码  
        	       {  
        	      String group = ma.group(); 
        	      sb.append(group);
        	      number = sb.toString();
        	           
        	       }  
        System.out.println("电话："+number);
        output1.write("电话："+number);
        output1.write("\r\n");
        
        while (ma1.find())//利用正则表达式找到邮箱
        	       {  
        	        String group1 = ma1.group(); 
 	                sb1.append(group1);
 	                email = sb1.toString();
        	      }  
        System.out.println("邮箱："+email);
        output1.write("邮箱："+email);
        output1.write("\r\n");
        
        Elements elements4=doc.select("div [class=details col-md-12 col-sm-12 col-xs-12]");//爬取其他信息
        Elements elements5=elements4.select("DIV");
        String introducton= elements5.get(0).text();
        System.out.println(introducton);
        output1.write(introducton);
        output1.close();
        
        }
     } 