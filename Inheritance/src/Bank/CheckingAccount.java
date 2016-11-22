package Bank;

class CheckingAccount extends BankAccount {  // another subclass of BankAccount
	  private double minBalance;
	  private double charge;
	  
	  public CheckingAccount(double minAmount, double charge) {
	    super(); // calling super class’s constructor
	    minBalance = minAmount;
	    this.charge = charge;
	  }
	  
	  public void processCheck(double amount)  {
	    if (getBalance() >= minBalance)
	      super.withdraw(amount);
	    else 
	      super.withdraw(amount + charge);      
	  }
	  
	  public void withdraw(double amount) { // method overriding
	    processCheck(amount);
	  }
	} 
