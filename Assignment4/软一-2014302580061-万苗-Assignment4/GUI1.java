
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GUI1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private Connection connectMysql=null;
	private Statement statement=null;
	private ResultSet rs=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}
		catch(Exception e){
	   	      System.out.print("Error loading Mysql Driver!");
	   	      e.printStackTrace();

		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI1 frame = new GUI1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	ActionListener searchAction=new ActionListener(){
		
		public void actionPerformed(ActionEvent arg0){
		String searchString=textField.getText();
		textArea.setText("");
		String[] searchWord=searchString.split("\\s"); //把获取到的搜索词存到数组中
		int i=searchWord.length;
		
		try{
		connectMysql=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/my_schema?user=root&password=123456");
		statement=(Statement) connectMysql.createStatement();
		rs=statement.executeQuery("select * from 2014302580061_professor_info");
		int numberWord1=0;
		while(rs.next()){
			String[] mysqlData=(rs.getString("teachername")+" "+rs.getString("email")+" "+rs.getString("introduction")).split("\\s");
			int j=mysqlData.length;
			for(int m=0;m<i;m++){
					for(int k=0;k<j;k++){
					if(searchWord[m].equalsIgnoreCase(mysqlData[k])){
						numberWord1++;
						}
					System.out.println(searchWord[m]+"\n"+mysqlData[k]+"\n");
				}
				System.out.println(numberWord1);
				}
			
			if(numberWord1!=0){
				textArea.setText(textArea.getText()+rs.getString("teachername")+"\n"+rs.getString("email")+"\n"+rs.getString("introduction")+"\n");
				}
			numberWord1=0;
			}
			//numberWord[numberLength]=(double) (numberWord1/j);
		
	}
		catch(Exception e){
		    
	   	    e.printStackTrace();System.out.print("wrong");
	   	      e.printStackTrace();
		}
		}
	};
	
	public GUI1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(searchAction);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		contentPane.setLayout(gl_contentPane);
	}
}
