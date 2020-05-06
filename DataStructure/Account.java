public abstract class Account 
{
	//Declaring variables
	private int accountId;
	private String name;
	double balance;

	//Default constructor 
	public Account()
	{
		accountId=0;
		balance=0;
	}

	//Constructor with 3 parameters
	public Account(int newID, String newName, double initialBalance)
	{
		accountId = newID;
		name = newName;
		balance = initialBalance;
	}

	// setter method for account number
	public void setID(int newID)
	{
		accountId = newID;
	}

	//getter method account id with is the account no
	public int getID()
	{
		return accountId;
	}
	
	// setter method for account holder name
	public void setName(String newName)
	{
		name = newName;
	}

	//getter method account name holder
	public String getName()
	{
		return name;
	}
	
	// Method to set new account balance
	public void setbalance(double newBalance)
	{		balance = newBalance;
	}

	// method to set account initial balance
	public double setBalance (double initialBalance)
	{
		return initialBalance;
	}
	
	// getter method to get account balance
	public double getBalance()
	{
		return balance;
	}

	//Method to deduction account balance
	public void withdraw(double amount)
	{
		balance -= amount;
	}

	//method to add amount to the account
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	public int compareTo(Account another) {
        return this.name.compareTo(another.getName());
    }

	
	public abstract void closeDay();

}







