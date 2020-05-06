
public class Savings extends Account{

	//Declaring savings account variables
	private double interestRate;
	private double minBalance;  

	//Default constructor
	public Savings(int accountId, String name, double balance, double interest, double min)
	{
		super(accountId, name, balance);
		this.interestRate = interest;
		this.minBalance = min;
	}

	// Method to get the interest rate changed to the account
	public double getInterestRate(double ir)
  	{
	  ir = this.interestRate;
	  return ir;
  	}
  
	// Method to get savings account minimum balance
	public double getMinBalance(double minBal)
	{
		minBal = this.minBalance;
		return minBal;
	}

	//method to close end of day process 
	public void closeDay()
	{
		if (getBalance() > this.minBalance) 
		{
			this.balance *= (1.0D + this.interestRate / 12.0D);
		}
	}
}