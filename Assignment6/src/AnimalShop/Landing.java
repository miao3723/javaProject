package AnimalShop;

 import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JPasswordField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javax.swing.LayoutStyle.ComponentPlacement;

public class Landing extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static Landing landingPage;
	private JPasswordField passwordField;
	private Connection connectMysql=null;
	private Statement statement=null;
	private ResultSet rs=null;
	private ResultSet rs1=null;
	private JLabel label_1;
	private String address="jdbc:mysql://127.0.0.1:3306/Assignment?user=root&password=wm680818";

public Landing() {
	   try{
		Class.forName("com.mysql.jdbc.Driver");
		
	   }
	     catch(Exception e){
   	        
   	       e.printStackTrace();

	     }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 216, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setFont(new Font("华文楷体", Font.PLAIN, 14));
		
		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try{
					label_1.setText("");
					connectMysql=(Connection) DriverManager.getConnection(address);
					statement=(Statement) connectMysql.createStatement();
					rs=statement.executeQuery("select * from assignment6_userinformation");
					int i=0;
					while(rs.next()){
						
						 if((rs.getString("userName")).equals(textField.getText())&&rs.getString("password").equals(passwordField.getText())){
							 dispose();
							 i=1;
							 MainPage enter=new MainPage("<html>"+"<p>"+textField.getText()+"</p>"+"<p>"+"欢迎光临"+"</p>"+"</html>",textField.getText());   
							 enter.setVisible(true);
							 break;
						 }
						 
						   
						}
					if(i==0){
						label_1.setText("用户名或密码错误");
						 
					}
						//numberWord[numberLength]=(double) (numberWord1/j);
					
				}
					catch(Exception es){
					    
				   	    es.printStackTrace();System.out.print("wrong");
				   	      es.printStackTrace();
					}
				
			}
		});
		
		
		passwordField = new JPasswordField();
		
		label_1 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(label)
							.addGap(40)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addComponent(button))
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(label))
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addComponent(button)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
public Landing(String information,String anmial) {
	   try{
		Class.forName("com.mysql.jdbc.Driver");
		
	   }
	     catch(Exception e){
	       System.out.print("Error loading Mysql Driver!");
	       e.printStackTrace();

	     }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 216, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setFont(new Font("华文楷体", Font.PLAIN, 14));
		
		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try{
					connectMysql=(Connection) DriverManager.getConnection(address);
					statement=(Statement) connectMysql.createStatement();
					rs=statement.executeQuery("select * from assignment6_userinformation");
					int i=0;
					while(rs.next()){
						
						 if((rs.getString("userName")).equals(textField.getText())&&rs.getString("password").equals(passwordField.getText())){
							 try{
								 rs1=statement.executeQuery("select * from "+textField.getText() );
								 int petNumber=0;
								 PreparedStatement ps1=null; 
								 while(rs1.next()){
									if(rs1.getString("pet").equals(anmial)){
										 petNumber=1;
										 ps1=(PreparedStatement) connectMysql.prepareStatement("UPDATE "+textField.getText()+" SET number=? where pet=?");
										 int animalNumber=rs1.getInt("number")+1;
										 ps1.setInt(1,animalNumber);
										 ps1.setString(2,anmial );
										 ps1.addBatch();
										 ps1.executeBatch();
									}
								 }
								 if(petNumber==0){
									 ps1=(PreparedStatement) connectMysql.prepareStatement("INSERT "+textField.getText()+"(pet,number)VALUES(?,?)");
									 ps1.setString(1,anmial );
									 ps1.setInt(2, 1);
									 ps1.addBatch();
									 ps1.executeBatch();
								 }
							 }
							 catch(Exception e2){}
							 dispose();
							 i=1;
							 MainPage enter=new MainPage("<html>"+"<p>"+textField.getText()+"</p>"+"<p>"+"欢迎光临"+"</p>"+"</html>",textField.getText());   
							 enter.setVisible(true);
							 break;
						 }
						 
						   
						}
					if(i==0){
						label_1.setText("用户名或密码错误");
						dispose();
						Landing landing =new Landing(information,anmial);
						landing.setVisible(true);
					}
						//numberWord[numberLength]=(double) (numberWord1/j);
					
				}
					catch(Exception es){
					    
				   	    es.printStackTrace();System.out.print("wrong");
				   	      es.printStackTrace();
					}
				
			}
		});
		
		
		passwordField = new JPasswordField();
		
		label_1 = new JLabel(information);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(label)
							.addGap(40)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addComponent(button))
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(label))
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addComponent(button)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
