package Bank;

public abstract class BankAccount { // declare BankAccount class as an abstract class

	private double balance;                                                                 

    public BankAccount()   {                                                                    
		balance = 0;
    }

    public BankAccount(double initialAmount) {
        balance = initialAmount;
    }

    public void deposit(double amount) {                                             
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount)
		    balance -= amount;
        else
            System.out.println("Insufficient funds");
    } 

    public double getBalance() {                                                         
        return balance;
    }
         
    public void setBalance(double amount) {
        balance = amount;
    }    
} 
