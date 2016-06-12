import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;









import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

    public class GUI extends JFrame {
    private DepositSlot depositSlot=new DepositSlot() ; // ATM's deposit slot
	private Keypad keypad=new Keypad();// ATM's keypad
	private CashDispenser cashDispenser=new CashDispenser() ;// ATM's cash dispenser
	private boolean userAuthenticated;// whether user is authenticated
	private BankDatabase bankDatabase=new BankDatabase();// account information database 
	
	private JPanel contentPane;
	private JTextPane textPane;
	private JButton btnEnter;
	int accountNumber=0;
	int number=0;
	int accountEnter=0;
	int pin;
	
        ActionListener a1= new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			number=number*10+1;
			textPane.setText(textPane.getText()+"1");
			}
        };
        ActionListener a2= new ActionListener(){
    		public void actionPerformed(ActionEvent arg0) {
    			number=number*10+2;
    			textPane.setText(textPane.getText()+"2");
    			}
            };
        ActionListener a3= new ActionListener(){
        		public void actionPerformed(ActionEvent arg0) {
        			number=number*10+3;
        			textPane.setText(textPane.getText()+"3");
        			}
                };
         ActionListener a4= new ActionListener(){
            		public void actionPerformed(ActionEvent arg0) {
            			number=number*10+4;
            			textPane.setText(textPane.getText()+"4");
            			}
                    };
         ActionListener a5= new ActionListener(){
                		public void actionPerformed(ActionEvent arg0) {
                			number=number*10+5;
                			textPane.setText(textPane.getText()+"5");
                			}
                        };
          ActionListener a6= new ActionListener(){
                    		public void actionPerformed(ActionEvent arg0) {
                    			number=number*10+6;
                    			textPane.setText(textPane.getText()+"6");
                    			}
                            };
           ActionListener a7= new ActionListener(){
                        public void actionPerformed(ActionEvent arg0) {
                        	        number=number*10+3;
                        			textPane.setText(textPane.getText()+"7");
                        			}
                                };                 
          ActionListener a8= new ActionListener(){
                         public void actionPerformed(ActionEvent arg0) {
                        	        number=number*10+3;
                            		textPane.setText(textPane.getText()+"8");
                            			}
                                    };
          ActionListener a9= new ActionListener(){
                          public void actionPerformed(ActionEvent arg0) {
                        	        number=number*10+3;
                                	textPane.setText(textPane.getText()+"9");
                                			}
                                        };
          ActionListener a0= new ActionListener(){
                        public void actionPerformed(ActionEvent arg0) {
                        	         number=number*10+3;
                                     textPane.setText(textPane.getText()+"0");
                                                  			}
                                                          };
          
          ActionListener Enter= new ActionListener(){
                            public void actionPerformed(ActionEvent arg0) {
                            	accountEnter++;
                                if(accountEnter==1){
                                	textPane.setText(textPane.getText()+"\nEnter your PIN: " );
                                	accountNumber=number;
                                	
                                }
                                else if(accountEnter==2){
                                	pin=number;
                                
                                	userAuthenticated =
                                			 bankDatabase.authenticateUser( accountNumber, pin );
                                	if ( userAuthenticated )
                               	 {
                               	
                               	textPane.setText("Main menu:"+"\n1 - View my balance"+
                               	"\n2 - Withdraw cash"+"\n3 - Deposit funds"+"\n4 - Exit\n"+"Enter a choice: ");
                               	 } // end if
                               	else
                               		{
                               		textPane.setText("Invalid account number or PIN. Please try again." );
                               		accountEnter=1;
                               		}
                                	
                               	  // end method authenticateUser
                                }
                                else if(accountEnter>=2){
                                	createTransaction( number );
                                	// return the newly created object
                       		   } // end method createTransaction}
                                	
                                number=0;
                            } 	
                                
          };  
                         
                                          
	/**
	 * Launch the application.
	 */
                                                      

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textPane = new JTextPane();
		textPane.setText("Welcome!" +"\nPlease enter your account number: " );
		
		JButton button = new JButton("1");
		button.addActionListener(a1);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(a2);
		
		JButton button_2 = new JButton("3");
		button_2.addActionListener(a3);
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(a4);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(a5);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(a6);
		
		JButton button_6 = new JButton("7");
		button_6.addActionListener(a7);
		
		JButton button_7 = new JButton("8");
		button_7.addActionListener(a8);
		
		JButton button_8 = new JButton("9");
		button_8.addActionListener(a9);
		
		JButton button_9 = new JButton("0");
		button_9.addActionListener(a0);
		
		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(Enter);
		
		JButton btnNewButton = new JButton("Take cash here");
		
		JButton btnNewButton_1 = new JButton("Insert deposit envelopse here");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_5))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(button_9)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnEnter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(button_6)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(button_7)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(button_8))))
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton_1, 0, 0, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
					.addGap(62))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(button_1)
								.addComponent(button_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_3)
								.addComponent(button_4)
								.addComponent(button_5))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_6)
								.addComponent(button_7)
								.addComponent(button_8))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_9)
								.addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)))
					.addGap(89))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void show(String message){
		textPane.setText(message);
	}

	public Component getComponent(){
		return textPane; 
		}
	private Transaction createTransaction( int type )
	  {
		GUI gui=new GUI();
	 Transaction temp = null; // temporary Transaction variable
		// determine which type of Transaction to create
		   switch ( type )
		   {
		   case 1: // create new BalanceInquiry transaction
		   temp = new BalanceInquiry(
		   accountNumber, gui, bankDatabase );
		   break;
		   case 2: // create new Withdrawal transaction
		   temp = new Withdrawal( accountNumber, gui,
		   bankDatabase, keypad, cashDispenser );
		   break;
		   case 3: // create new Deposit transaction
		   temp = new Deposit( accountNumber, gui,
		   bankDatabase, keypad, depositSlot );
		    break;
		  } // end switch
		   return temp;
	  }
	
}
