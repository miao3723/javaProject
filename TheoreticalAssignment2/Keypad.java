// Keypad.java
// Class Keypad represents an ATM¡¯s keypad
import java.util.Scanner;
public class Keypad
 {
	private Scanner input; // reads data from the command line
 // no attributes have been specified yet

// no-argument constructor
 public Keypad()
 {
	 input = new Scanner( System.in );
 } // end no-argument Keypad constructor

 // operations
 public int getInput()
 {
	 return input.nextInt();
 } // end method getInput
 } // end class Keypad