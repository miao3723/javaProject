// BalanceInquiry.java
// Represents a balance inquiry ATM transaction

public class BalanceInquiry extends Transaction
{
 // BalanceInquiry constructor
public BalanceInquiry( int userAccountNumber, GUI gui,BankDatabase atmBankDatabase )
{
 super( userAccountNumber, gui, atmBankDatabase );
 } // end BalanceInquiry constructor

 // performs the transaction
 @Override
 public void execute()
 {
	// get references to bank database and screen
	BankDatabase bankDatabase = getBankDatabase();
	
	GUI gui=new GUI();
	
	// get the available balance for the account involved
	double availableBalance =
	 bankDatabase.getAvailableBalance( getAccountNumber() );
	
	 // get the total balance for the account involved
	 double totalBalance =
	 bankDatabase.getTotalBalance( getAccountNumber() );
	
	 // display the balance information on the screen
	 gui.show( "\nBalance Information:" );
	 gui.show(" - Available balance: " );
	 gui.show( Double.toString(availableBalance ));
	 gui.show( "\n - Total balance: " );
	 gui.show( Double.toString(totalBalance) );
	 gui.show( "" );
	 } // end method execute
	 } // end class BalanceInquiry
