// Deposit.java
 // Represents a deposit ATM transaction

public class Deposit extends Transaction
 {
 private double amount; // amount to deposit
 private Keypad keypad; // reference to keypad
private DepositSlot depositSlot; // reference to deposit slot
 private final static int CANCELED = 0; // constant for cancel option

 // Deposit constructor
 public Deposit( int userAccountNumber, GUI gui,
 BankDatabase atmBankDatabase, Keypad atmKeypad,
 DepositSlot atmDepositSlot )
 {
// initialize superclass variables
 super( userAccountNumber, gui, atmBankDatabase );

 // initialize references to keypad and deposit slot
 keypad = atmKeypad;
 depositSlot = atmDepositSlot;
 } // end Deposit constructor

 // perform transaction
@Override
 public void execute()
 {
 BankDatabase bankDatabase = getBankDatabase(); // get reference
 GUI gui = getScreen(); // get reference

 amount = promptForDepositAmount(); // get deposit amount from user

 // check whether user entered a deposit amount or canceled
 if ( amount != CANCELED )
 {
 // request deposit envelope containing specified amount
 gui.show(
 "\nPlease insert a deposit envelope containing " );
 gui.show(Double.toString(amount));
 gui.show( "." );

 // receive deposit envelope
 boolean envelopeReceived = depositSlot.isEnvelopeReceived();

 // check whether deposit envelope was received
 if ( envelopeReceived )
 {
	 gui.show( "\nYour envelope has been " +
"received.\nNOTE: The money just deposited will not " +
		"enclosed cash and your checks clear." );
//credit account to reflect the deposit
 bankDatabase.credit( getAccountNumber(), amount );
 } // end if
 else // deposit envelope not received
 {
	 gui.show( "\nYou did not insert an " +
 "envelope, so the ATM has canceled your transaction." );
} // end else
 } // end if
else // user canceled instead of entering amount
{
	gui.show( "\nCanceling transaction..." );
 } // end else
 } // end method execute

 // prompt user to enter a deposit amount in cents
private double promptForDepositAmount()
 {
 GUI gui = getScreen(); // get reference to screen

 // display the prompt
 gui.show("\nPlease enter a deposit amount in " +
 "CENTS (or 0 to cancel): " );
 int input = keypad.getInput(); // receive input of deposit amount

 // check whether the user canceled or entered a valid amount
if ( input == CANCELED )
 return CANCELED;

 else
{
 return ( double ) input / 100; // return dollar amount
} // end else
 } // end method promptForDepositAmount
 } // end class Deposit
