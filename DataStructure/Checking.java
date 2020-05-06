public class Checking extends Account{

	// Declaring checking account variables
	private double fee;
	private double minimum;  

	//Default constructor
	public Checking(int accountId, String name, double balance, double monthly, double min)
	{
		super(accountId, name, balance); // inheriting variables form the super class (account)
		fee = monthly;
		minimum = min;
	}  

	//method to get monthly cost fee 
	public double getFee(double monthcost)
	{
		monthcost = fee;
		return monthcost;
	}  

	//method to get account minimum balance
	public double getMinimum(double min1)
	{
		min1 = minimum;
		return min1;
	}
  
	//method to run end of day process
	public void closeDay()
	{
		if (getBalance() < minimum) 
		{
			balance -= fee;
		} 
	}
}