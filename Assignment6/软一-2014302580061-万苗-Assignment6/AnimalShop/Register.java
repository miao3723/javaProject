package AnimalShop;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;

 


import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static Register frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private java.sql.Connection connectMysql=null;
	private Statement statement=null;
	private ResultSet rs=null;
	private JLabel label_3;
	private String address="jdbc:mysql://127.0.0.1:3306/Assignment?user=root&password=wm680818";

	
	public Register() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(Exception e){
	   	      System.out.print("Error loading Mysql Driver!");
	   	      e.printStackTrace();

		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u90AE\u7BB1");
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		
		JLabel label_1 = new JLabel("\u7B2C\u4E00\u6B21\u5BC6\u7801");
		
		JLabel label_2 = new JLabel("\u7B2C\u4E8C\u6B21\u5BC6\u7801");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try{
					label_3.setText("");
					connectMysql=  DriverManager.getConnection( address);
					statement=(Statement) connectMysql.createStatement();
					rs=statement.executeQuery("select * from 2014302580061_professor_info");
					
					while(rs.next()){
						 if((rs.getString("teachername")).equals(textField_1.getText())){
							 label_3.setText("该用户名已经被注册，请更改");
						 } 
						 }
						//numberWord[numberLength]=(double) (numberWord1/j);
					
				}
					catch(Exception es){
					    
				   	    es.printStackTrace();System.out.print("wrong");
				   	      es.printStackTrace();
					}
				 
				PreparedStatement ps1=null; 
				if((passwordField.getText()).equals(passwordField_1.getText())){
		        try {
		        	
					ps1=(PreparedStatement) connectMysql.prepareStatement("INSERT assignment6_userinformation(userName,password,email)VALUES(?,?,?)");
					 
					ps1.setString(1,textField_1.getText());
				 
					ps1.setString(2, passwordField.getText());
					ps1.setString(3,textField.getText());
					String sqlWord="CREATE TABLE "+textField_1.getText()+"(pet VARCHAR(40) not null primary key,number INT);";
					java.sql.PreparedStatement pstmt =  connectMysql.prepareStatement(sqlWord);
					pstmt.executeUpdate();
				 
					ps1.addBatch();
				    ps1.executeBatch();
					dispose();
					AfterRegister afterPage=new AfterRegister("你已注册成功，请登录");
					afterPage.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
			else{
				label_3.setText("第一次与第二次密码不一致，请重新输入");
				Register register=new Register();
				register.setVisible(true);
			}
			}
		});
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		label_3 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addComponent(button))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(passwordField_1, 148, 148, 148))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))
					.addGap(23))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(button))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
