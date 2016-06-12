package AnimalShop;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class FirstEnter extends JFrame {

	private JPanel contentPane;
	static FirstEnter frame;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FirstEnter();
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
	public FirstEnter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 273);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Landing landingPage = new Landing();
							landingPage.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Register registerPage= new Register();
							registerPage.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton btnNewButton_2 = new JButton("dog");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage dog=new AnimalPage("<html><p>dog</p><p>eat bone</p><p>drink water</p><p> stay in ground</p><p> play</p><p>price:100 dollar</p></html>","dog");
				dog.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JButton btnNewButton_3 = new JButton("cat");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage cat=new AnimalPage("<html><p>cat</p><p>eat fish</p><p>drink milk</p><p> stay in roof</p><p> hug</p><p>price:200 dollar</p></html>","cat");
				cat.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JButton btnNewButton_4 = new JButton("turtle");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage turtle=new AnimalPage("<html><p>turtle</p><p>eat fish,shrimp</p><p>drink sea water</p><p> stay in sea water</p><p> bask</p><p>price:150 dollar</p></html>","turtle");
				turtle.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JButton btnNewButton_5 = new JButton("parrot");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage parrot=new AnimalPage("<html><p>parrot</p><p>eat nuts,seeds</p><p>drink water</p><p> stay in tree</p><p> fly</p><p>price:300 dollar</p></html>","turtle");
				parrot.setVisible(true);
			}
		});
		btnNewButton_5.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JButton btnNewButton_6 = new JButton("hamster");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage hamster=new AnimalPage("<html><p>hamster</p><p>eat Sunflower seed</p><p>drink water</p><p> stay in corner</p><p>eat</p><p>price:400 dollar</p></html>","hamster");
				hamster.setVisible(true);
			}
		});
		btnNewButton_6.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JButton btnNewButton_7 = new JButton("squirrel");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage squirrel=new AnimalPage("<html><p>squirrel</p><p>eat pine cone</p><p>drink water</p><p> stay in tree hole,underground</p><p>play</p><p>price:156 dollar</p></html>","squirrel");
				squirrel.setVisible(true);
			}
		});
		btnNewButton_7.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JButton btnNewButton_8 = new JButton("rabbit");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage rabbit=new AnimalPage("<html><p>rabbit</p><p>eat carrot</p><p>drink water</p><p> stay in grassland,underground</p><p>eat</p><p>price:236 dollar</p></html>","rabbit");
				rabbit.setVisible(true);
			}
		});
		btnNewButton_8.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JButton btnNewButton_9 = new JButton("snake");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage snake=new AnimalPage("<html><p>snake</p><p>eat mouse</p><p>drink water</p><p> stay in hole</p><p>bask</p><p>price:236 dollar</p></html>","snake");
				snake.setVisible(true);
			}
		});
		btnNewButton_9.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JButton btnNewButton_10 = new JButton("lizard");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage lizard=new AnimalPage("<html><p>lizard</p><p>eat bug</p><p>drink water</p><p> stay in tree</p><p>bask</p><p>price:268 dollar</p></html>","lizard");
				lizard.setVisible(true);
			}
		});
		btnNewButton_10.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JButton btnNewButton_11 = new JButton("fish");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage fish=new AnimalPage("<html><p>fish</p><p>eat aquatic plant</p><p>drink water</p><p> stay in water</p><p>swim</p><p>price:88 dollar</p></html>","fish");
				fish.setVisible(true);
			}
		});
		btnNewButton_11.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JButton btnNewButton_12 = new JButton("myna");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage myna=new AnimalPage("<html><p>myna</p><p>eat earthworm</p><p>drink water</p><p> stay in tree</p><p>fly</p><p>price:168 dollar</p></html>","myna");
				myna.setVisible(true);
			}
		});
		btnNewButton_12.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JButton btnNewButton_13 = new JButton("canary");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AnimalPage canary=new AnimalPage("<html><p>canary</p><p>eat millet</p><p>drink water</p><p> stay in tree</p><p>sing</p><p>price:432 dollar</p></html>","canary");
				canary.setVisible(true);
			}
		});
		btnNewButton_13.setFont(new Font("华文新魏", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u8BBF\u95EE\u82B1\u9E1F\u866B\u9C7C\u5BA0\u7269\u5E97\uFF0C\u8FD9\u91CC\u6709\u591A\u79CD\u5BA0\u7269");
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(59)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_5)
							.addGap(6)
							.addComponent(btnNewButton_6)
							.addGap(10)
							.addComponent(btnNewButton_7))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_8)
							.addGap(10)
							.addComponent(btnNewButton_9, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(btnNewButton_10, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_11, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(btnNewButton_12, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNewButton_13, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_5)
								.addComponent(btnNewButton_6)
								.addComponent(btnNewButton_7))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_8)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addComponent(btnNewButton_9, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addComponent(btnNewButton_10, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_11, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_12, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_13, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(6)
							.addComponent(btnNewButton_1)))
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
