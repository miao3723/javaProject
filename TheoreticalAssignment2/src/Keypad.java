
// Keypad.java
// Class Keypad represents an ATM¡¯s keypad

public class Keypad
 { 
   String number1="";
	 // reads data from the command line
 // no attributes have been specified yet
    int input;
// no-argument constructor
 public void getNumber1(String number){
   	 
   	 number1=number;
   	 
    }
 public Keypad()
 {
	try{ input=(int)Double.valueOf(number1).doubleValue();}
	catch(Exception e){}
 } // end no-argument Keypad constructor

 // operations
 public int getInput()
 {
	return input; 
 } // end method getInput
 
 } // end class Keypad