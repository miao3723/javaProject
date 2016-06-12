package AnimalShop;

 
 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.mysql.jdbc.Statement;
import javax.swing.SwingConstants;

public class Backet extends JFrame {

	private JPanel contentPane;
	private java.sql.Connection connectMysql=null;
	private Statement statement=null;
	private ResultSet rs=null;
	private JLabel lblNewLabel;

	
	public Backet(String userName) throws SQLException {
		String address="jdbc:mysql://127.0.0.1:3306/Assignment?user=root&password=wm680818";
		connectMysql=  DriverManager.getConnection(address);
		statement=(Statement) connectMysql.createStatement();
		rs=statement.executeQuery("select * from "+userName);
		String backetinformation=null;
		while(rs.next()){
			 if(backetinformation!=null)backetinformation=backetinformation+"<p>"+rs.getString("pet")+":" +rs.getInt("number")+"</p>";
			 else backetinformation="<p>"+rs.getString("pet")+":"+ rs.getInt("number")+"</p>";
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 lblNewLabel = new JLabel("<html>"+backetinformation+"</html>");
		 lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
