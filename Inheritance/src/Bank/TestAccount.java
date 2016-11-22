package Bank;

public class TestAccount {
	  public static void main(String [] args) {
	    
		SavingsAccount s =  new SavingsAccount(500.00, 4.5);
	    CheckingAccount c = new CheckingAccount(2500.00, .50);
	    s.deposit(135.22);
	    s.postInterest();
	    s.withdraw(50);
	    System.out.print("The balance of SavingsAccount s is $ ");  
	    System.out.println(s.getBalance()); 
	    c.deposit(1000.00);
	    c.processCheck(200.00);
	    c.withdraw(100.00);
	    System.out.print("The balance of CheckingAccount c is $ ");  
	    System.out.println(c.getBalance());
	  }
	} 
