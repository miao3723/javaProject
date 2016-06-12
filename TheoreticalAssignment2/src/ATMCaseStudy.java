import java.awt.EventQueue;

//import java.awt.EventQueue;
// ATMCaseStudy.java
// Driver program for the ATM case study
public class ATMCaseStudy
 {
 // main method creates and runs the ATM
	public static void main(String[] args) {
 	   EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 	  
    }
//Description	Resource	Path	Location	Type
