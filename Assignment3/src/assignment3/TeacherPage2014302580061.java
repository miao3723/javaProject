package assignment3;

import java.io.IOException;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.mysql.jdbc.PreparedStatement;
 
public class TeacherPage2014302580061 {
    
     
     public static void teacherPaper(String url ) throws IOException, SQLException {
    	 Connection connect = null;
    	 try {
   	      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
   	      //Class.forName("org.gjt.mm.mysql.Driver");
   	     
   	    }
   	    catch (Exception e) {//�������ݿ�
   	      System.out.print("Error loading Mysql Driver!");
   	      e.printStackTrace();
   	    }
   	    try {
   	      connect = DriverManager.getConnection(
   	          "jdbc:mysql://localhost:3306/assignment","root","wm680818");
   	           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

   	      
   	      Statement stmt = connect.createStatement();
   	      ResultSet rs = stmt.executeQuery("select * from 2014302580061_professor_info");
   	                                                               
   	
   	    }
   	    catch (Exception e) {
   	      System.out.print("wrong");
   	      e.printStackTrace();
   	    }
    	Document document = Jsoup.connect(url).get(); 
    	Elements content = document .select("div[id=content]");
    	Elements elements2=content.select("h2");//��ȡ����
        String name = elements2.get(0).text();
        System.out.println("name��"+name);
       
        String test = content.get(0).text();
        
        StringBuilder stringBuilder=new StringBuilder();
       
        Pattern pa1 = Pattern.compile("(([a-z]{1,10})+@+([a-z]{1,10})+.{1,2}+edu+){0,1}");
        
        Matcher ma1 = pa1.matcher(test);
       
        String email=null;
        
        while (ma1.find())//����������ʽ�ҵ�����
        	       {  
        	        String group1 = ma1.group(); 
        	        stringBuilder.append(group1);
 	                email =  stringBuilder.toString();
        	      }  
        System.out.println("email:"+email);
        Elements elements=content.select("ul[class=titles]");
        String introduction= elements.get(0).text();
        System.out.println("introduction:"+introduction+"\n");
        PreparedStatement ps=null; 
        ps=(PreparedStatement) connect.prepareStatement("INSERT 2014302580061_professor_info(teachername,email,introduction)VALUES(?,?,?)");
        ps.setString(1,name);
        ps.setString(2, email);
        ps.setString(3,introduction);
        ps.addBatch();
        ps.executeBatch();
        }
     } 