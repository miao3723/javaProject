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
	public void send(String recipient, String subject, Object content)//���ʼ�
			throws MessagingException {
		
		// TODO Auto-generated method stub
        String emailServer="smtp.139.com";//����������
        String fromAddress="15927195736@139.com";//�Լ������ַ
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
	public String getReplyMessageContent(String sender, String subject)//���ʼ�
			throws MessagingException, IOException {
		// TODO Auto-generated method stub
		// ����pop3����������������Э�顢�û���������  
	      String pop3Server = "pop3.139.com";  
	      String protocol = "pop3";  
		  String user = "15927195736";  
		  String password = "wm680818";  
	              // ����һ���о���������Ϣ��Properties����  
       Properties props = new Properties();  
	       props.setProperty("mail.store.protocol", protocol);  
		       props.setProperty("mail.pop3.host", pop3Server);  
	         
		     // ʹ��Properties������Session����  
	      Session session = Session.getInstance(props);  
		        session.setDebug(true);  
	        
      // ����Session������Store���󣬲�����pop3������  
		       Store storeContent = session.getStore();        
		       storeContent.connect(pop3Server, user, password);  
		        
		     // ��������ڵ��ʼ���Folder������"ֻ��"��  
     Folder folder = storeContent.getFolder("inbox");  
		     folder.open(Folder.READ_ONLY);  
	        
		     // ����ʼ���Folder�ڵ������ʼ�Message����  
		      Message [] messages = folder.getMessages();  
        
		      
		     //��ȡ�ʼ��ı��⣬�����˵�ַ ������
		     String subject1 = messages[9].getSubject();  
		     
		     String text=(messages[9].getContent()).toString();
		     //�����ȡ��������     
		     System.out.println("title��" + subject1);  
		     System.out.println("address:" + sender);  
		     System.out.println(subject+text) ;   
		   
		     folder.close(false);  
		     storeContent.close();
			 return null;  
		   }  
	


		

	}


