package iss.java.mail;


import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailRealize2014302580061 implements IMailService {
	  
	@Override
	public void connect() throws MessagingException {
		// TODO Auto-generated method stub
		 
		 
	}

	@Override
	public void send(String recipient, String subject, Object content)//发邮件
			throws MessagingException {
		
		// TODO Auto-generated method stub
        String emailServer="smtp.139.com";//服务器名称
        String fromAddress="15927195736@139.com";//自己邮箱地址
		String password="wm680818";
		Properties proper=System.getProperties();
		proper.put("mail.smtp.host", emailServer);
		proper.put("mail.smtp.auth", "true");
		
		MyAuthenticator myAuth=new MyAuthenticator(fromAddress,password);
		Session session=Session.getDefaultInstance(proper, myAuth);
		MimeMessage sendMessage=new MimeMessage(session);
		InternetAddress sendAddress=new InternetAddress(fromAddress);
		sendMessage.setFrom(sendAddress);
		InternetAddress receiverAddress=new InternetAddress(recipient);
		sendMessage.addRecipient(Message.RecipientType.TO, receiverAddress);
		sendMessage.setSubject(subject);
		sendMessage.setText(content.toString());;
		sendMessage.saveChanges(); 
		Transport.send(sendMessage);
		
		System.out.println("Mail has been send");
	}

	@Override
	public boolean listen() throws MessagingException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getReplyMessageContent(String sender, String subject)//收邮件
			throws MessagingException, IOException {
		// TODO Auto-generated method stub
		// 连接pop3服务器的主机名、协议、用户名、密码  
	      String pop3Server = "pop3.139.com";  
	      String protocol = "pop3";  
		  String user = "15927195736";  
		  String password = "wm680818";  
	              // 创建一个有具体连接信息的Properties对象  
       Properties props = new Properties();  
	       props.setProperty("mail.store.protocol", protocol);  
		       props.setProperty("mail.pop3.host", pop3Server);  
	         
		     // 使用Properties对象获得Session对象  
	      Session session = Session.getInstance(props);  
		        session.setDebug(true);  
	        
      // 利用Session对象获得Store对象，并连接pop3服务器  
		       Store storeContent = session.getStore();        
		       storeContent.connect(pop3Server, user, password);  
		        
		     // 获得邮箱内的邮件夹Folder对象，以"只读"打开  
     Folder folder = storeContent.getFolder("inbox");  
		     folder.open(Folder.READ_ONLY);  
	        
		     // 获得邮件夹Folder内的所有邮件Message对象  
		      Message [] messages = folder.getMessages();  
        
		      
		     //获取邮件的标题，发件人地址 ，内容
		     String subject1 = messages[9].getSubject();  
		     
		     String text=(messages[9].getContent()).toString();
		     //输出获取到的内容     
		     System.out.println("title：" + subject1);  
		     System.out.println("address:" + sender);  
		     System.out.println(subject+text) ;   
		   
		     folder.close(false);  
		     storeContent.close();
			 return null;  
		   }  
	


		

	}


