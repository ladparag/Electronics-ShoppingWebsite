package Bank;

class SavingsAccount extends BankAccount  { // subclass of BackAccount
	  private double interestRate;

	  public SavingsAccount(double amount, double rate) {
	     super(amount);  // calling super class’s constructor
	     interestRate = rate;
	  }   
	  
	  public void postInterest()  {
	    double balance = getBalance();
	    double interest = interestRate/100*balance;
	    setBalance(balance + interest);
	  }
	} 
