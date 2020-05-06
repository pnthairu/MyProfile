import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

	public class BankGUI extends JFrame implements ActionListener{
		
		// Using hash map to enable search account numbers
		private Map<Integer,Double> accounts = new HashMap<Integer,Double>();
		
		//Declaring variables 
			private JTextField leftTextField;			// text box for account number		
			private JTextField rightTextField;			// text box for amount		
			private JRadioButton saveCheckBox;			// check box to select saving account
			private JRadioButton checkingCheckBox;		// check box to select checking account	
			private JRadioButton depositCheckBox;		// check box for deposit	
			private JRadioButton withdrawCheckBox;		// check box for withdrawal	
			private JRadioButton balanceCheckBox;		// check box to check account balance	
			private JButton createButton;				// button to create new account	
			private JButton executeButton;				// button to execute a transaction			
			private JButton eomButton;					// End of day process button
			private JButton reportButton;				// button for report	
			private JButton clearButton;				// button to clear the screen		
			private JButton exitButton;					// Button to exit the application
			private JTextArea statusArea;				// System out put area
			private JOptionPane accountNamPane;

	// Array list to store account formation
	public ArrayList<Account> accountList = new ArrayList<Account>();	

	private DecimalFormat dollar = new DecimalFormat("$#0.00");

	//Method to design the GUI
	public BankGUI()
	{   
		//
		super("Equity Investment Credit Union");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			setSize(490, 455);			
			setLayout(new BorderLayout());			
			setLocationRelativeTo(null);			
			setVisible(true);			
			JScrollPane scrollpane;			
			JPanel mainPanel = new JPanel(new GridBagLayout());			
			GridBagConstraints topConstraints = new GridBagConstraints();			
			topConstraints.insets = new Insets(5, 10, 3, 5);			
			topConstraints.gridx = 0;			
			topConstraints.gridy = 0;			
			topConstraints.weightx = 1;			
			topConstraints.gridwidth = 2;			
			
			//Label for the header of the bank information
			JLabel topLabelLine1 = new JLabel("Equity Investment Credit Union", JLabel.CENTER);			
			JLabel topLabelLine2 = new JLabel("1030 Sheridine Road, Oskaloosa, iowa", JLabel.CENTER);	
			
			mainPanel.setBackground(Color.lightGray);
			mainPanel.add(topLabelLine1, topConstraints);			
			topConstraints.insets = new Insets(-2, 10, -5, 5);		
			topConstraints.gridy = 1;  
			
			
			mainPanel.add(topLabelLine2, topConstraints);				
			leftTextField = new JTextField();			
			topConstraints.insets = new Insets(20, 10, 3, 55);			
			topConstraints.gridwidth = 1;			
			topConstraints.fill = GridBagConstraints.HORIZONTAL;			
			topConstraints.gridx = 0;			
			topConstraints.gridy = 2;	
			
			mainPanel.add(leftTextField, topConstraints);			
			rightTextField = new JTextField();			
			topConstraints.insets = new Insets(20, -42, 3, 10);			
			topConstraints.gridx = 1;			
			topConstraints.gridy = 2;	
			
			mainPanel.add(rightTextField, topConstraints);			
			JLabel acctLabel = new JLabel("Account ID (1010XX)", JLabel.CENTER);			
			topConstraints.insets = new Insets(0, 0, 0, 45);			
			topConstraints.gridx = 0;
			topConstraints.gridy = 3;
			
			mainPanel.add(acctLabel, topConstraints);			
			JLabel amtLabel = new JLabel("Amount", JLabel.CENTER);			
			topConstraints.gridx = 1;			
			topConstraints.gridy = 3;
			
			mainPanel.add(amtLabel, topConstraints);				
			saveCheckBox = new JRadioButton("Savings");			
			topConstraints.insets = new Insets(0, 10, 0, 60);			
			topConstraints.gridx = 0;			
			topConstraints.gridy = 4;
			
			mainPanel.add(saveCheckBox, topConstraints);			
			checkingCheckBox = new JRadioButton("Checking");			
			topConstraints.insets = new Insets(0, 10, 0, 60);			
			topConstraints.gridx = 0;			
			topConstraints.gridy = 5;
			
			mainPanel.add(checkingCheckBox, topConstraints);			
			depositCheckBox = new JRadioButton("Deposit");			
			topConstraints.insets = new Insets(0, -40, 0, 0);			
			topConstraints.gridx = 1;			
			topConstraints.gridy = 4;	
			
			
			mainPanel.add(depositCheckBox, topConstraints);				
			withdrawCheckBox = new JRadioButton("Withdraw");			
			topConstraints.insets = new Insets(0, -40, 0, 0);			
			topConstraints.gridx = 1;			
			topConstraints.gridy = 5;	
			
			mainPanel.add(withdrawCheckBox, topConstraints);			
			balanceCheckBox = new JRadioButton("Balance");			
			topConstraints.insets = new Insets(0, -40, 0, 0);			
			topConstraints.gridx = 1;			
			topConstraints.gridy = 6;
			
			mainPanel.add(balanceCheckBox, topConstraints);			
			ButtonGroup group = new ButtonGroup();			
			group.add(depositCheckBox);			
			group.add(withdrawCheckBox);			
			group.add(balanceCheckBox);
			
			ButtonGroup creategroup = new ButtonGroup();			
			creategroup.add(saveCheckBox);			
			creategroup.add(checkingCheckBox);				
			createButton = new JButton("Create Account");			
			topConstraints.insets = new Insets(10, 10, 10, 55);			
			topConstraints.gridx = 0;			
			topConstraints.gridy = 7;
			
			mainPanel.add(createButton, topConstraints);			
			executeButton = new JButton("Execute");			
			topConstraints.insets = new Insets(5, -40, 5, 10);			
			topConstraints.gridx = 1;			
			topConstraints.gridy = 7;			
			mainPanel.add(executeButton, topConstraints);			
			
			eomButton = new JButton("End of Day");			
			topConstraints.insets = new Insets(5, 10, 3, 55);			
			topConstraints.gridx = 0;			
			topConstraints.gridy = 8;			
			mainPanel.add(eomButton, topConstraints);			
			
			reportButton = new JButton("A/C No. Sort Report");			
			topConstraints.insets = new Insets(5, -40, 3, 10);			
			topConstraints.gridx = 1;			
			topConstraints.gridy = 8;			
			mainPanel.add(reportButton, topConstraints);
			
			clearButton = new JButton("Clear Screen");			
			topConstraints.insets = new Insets(5, 10, 3, 55);			
			topConstraints.gridx = 0;			
			topConstraints.gridy = 9;			
			mainPanel.add(clearButton, topConstraints);			
			
			exitButton = new JButton("Exit");			
			topConstraints.insets = new Insets(5, -40, 5, 10);			
			topConstraints.gridx = 1;			
			topConstraints.gridy = 9;			
			mainPanel.add(exitButton, topConstraints);
			
			//Setting up output text area
			statusArea = new JTextArea();
			//setting the size
			topConstraints.insets = new Insets(5, 5, 3, -500);			
			topConstraints.gridx = 0;			
			topConstraints.gridy = 30;			
			statusArea.setEditable(false);	
			//setting background color of the text
			statusArea.setForeground(Color.blue);			
			statusArea.setBounds(30, 30, 30, 30);			
			statusArea.setSize(300, 300);			
			statusArea.setBackground(mainPanel.getBackground());			
			mainPanel.add(statusArea,topConstraints);			
			add(mainPanel, BorderLayout.PAGE_START);			
			JScrollPane pane = new JScrollPane(statusArea);			
			statusArea.setBackground(Color.LIGHT_GRAY);			
			statusArea.setOpaque(true);			
			pane.setBackground(Color.white);			
			pane.setOpaque(true);			
			pane.setMaximumSize(new Dimension(30,300));			
			pane.setPreferredSize(new Dimension(300, 200));  			
			add(pane);			
			pane.getViewport().setBackground(Color.WHITE);  

			//Adding listeners			
			leftTextField.addActionListener(this);			
			rightTextField.addActionListener(this);	
			saveCheckBox.addActionListener(this);			
			checkingCheckBox.addActionListener(this);			
			depositCheckBox.addActionListener(this);			
			withdrawCheckBox.addActionListener(this);			
			balanceCheckBox.addActionListener(this);			
			createButton.addActionListener(this);			
			executeButton.addActionListener(this);			
			eomButton.addActionListener(new BankGUI.EndMonthButtonListener());			
			reportButton.addActionListener(new BankGUI.ReportButtonListener());	
			clearButton.addActionListener(new BankGUI.clearButtonListener());	
			//clearButton.addActionListener(this);			
			exitButton.addActionListener(this);	
			setVisible(true);			
		}
	
	//method for the to perform action
	public void actionPerformed(ActionEvent e){
		Object action = e.getSource();			
		String amount = rightTextField.getText();		
		String accountNo = leftTextField.getText();	
		String accountName = accountNamPane.MESSAGE_PROPERTY;
				
		int accNo;	
		String accName;		
		double amountDouble;		
		try{		
		if(action.equals(createButton)){		
		createAccount(Double.parseDouble(amount));		
		}			
			if(action.equals(executeButton) && depositCheckBox.isSelected())
			{		
				accNo = Integer.parseInt(accountNo);	
				accName = String.valueOf(accountName);
				amountDouble = Double.parseDouble(amount);		
				deposit(accNo, accName, amountDouble);	
			}	
		
		else if(action.equals(executeButton) && withdrawCheckBox.isSelected())
			{		
				accNo = Integer.parseInt(accountNo);	
				accName = String.valueOf(accountName);
				amountDouble = Double.parseDouble(amount);		
				withdraw(accNo,accName, amountDouble);		
			}		
		
		else if(action.equals(executeButton) && balanceCheckBox.isSelected())
		{		
			accNo = Integer.parseInt(accountNo);	
			accName = String.valueOf(accountName);
			checkBalance(accNo);		
		}
		
		else if(action.equals(executeButton))
			{		
				accNo = Integer.parseInt(accountNo);
				accName = String.valueOf(accountName);
				amountDouble = Double.parseDouble(amount);		
				adjustBalance(accNo, amountDouble);			
			}	
			
		else if (action.equals(clearButton))
		{
			accNo = Integer.parseInt(accountNo);
			accName = String.valueOf(accountName);
			amountDouble = Double.parseDouble(amount);	
			
			
		}
			
		else if(action.equals(exitButton))
		{		
			System.exit(ABORT);
		}	
		
		}	
		
		//output message if the account number does not exit
		catch (Exception ex) 
		{		
			statusArea.append("\n"+accountNo + " is an invalid account number");		
			
		}			
	}

	// Create new account method
	private void createAccount(double initialDeposit)
	{
		int accountNo;	
		
		//setting the starting point account number
		int largest = 101000;
		for(int x: accounts.keySet())
		{
			if(x>largest)
				largest = x;
		}
		//incrementing each account number created by 1
		accountNo = largest+1;
		if(accountNo>999999)		
		{
			statusArea.append(" Maximum account limit exceeded!!");
		}
		else{
			double amount = Double.parseDouble(rightTextField.getText());
			//setting up the name, the balance and monthly fee when creating a CHECKING account
			if (BankGUI.this.checkingCheckBox.isSelected())		{
				String accountNam = String.valueOf((JOptionPane.showInputDialog("Please enter full Names of Account holder")));
				double minimum = Double.parseDouble(JOptionPane.showInputDialog("Please enter the minimum balance"));
				double fee = Double.parseDouble(JOptionPane.showInputDialog("Please enter the monthly fee"));
				accountList.add(new Checking(accountNo, accountNam, amount, fee, minimum));  

				accounts.put(accountNo, minimum);
				statusArea.append("\nNew Checking account ID #"+accountNo+","+accountNam+" created\nWith an initial balance of "+getCurrencyFormat(accounts.get(accountNo)));
				leftTextField.setText(String.valueOf(accountNo));
			}

			else if (BankGUI.this.saveCheckBox.isSelected())
			{
				//setting up the name, the balance and monthly fee when creating a SAVINGS account
				String accountNam = String.valueOf((JOptionPane.showInputDialog("Please enter full Names of Account holder")));
				double minimum = Double.parseDouble(JOptionPane.showInputDialog("Please enter the minimum balance"));
				double rate = Double.parseDouble(JOptionPane.showInputDialog("Please enter the annual interest rate"));				
				accountList.add(new Savings(accountNo, accountNam, amount, rate, minimum));				
				accounts.put(accountNo, minimum);				
				statusArea.append("\nNew Savings account ID #"+accountNo+"," + accountNam+ " created\nWith an initial balance of "+getCurrencyFormat(accounts.get(accountNo)));				
				leftTextField.setText(String.valueOf(accountNo));				
				}				
				else				
				{				
					statusArea.append("\nPlease Select Savings or Checking");				
				}				
			}				
		}
		
		// method to adjust balance after either deposit or withdrawal
		private void adjustBalance(int accountNo, double newBalance)
		{	
			//searching account number using hash map
			if(!accounts.containsKey(accountNo)){		
				statusArea.append("\nAccount doesn't exists");		
		}	
			
		else{		
			accounts.put(accountNo, newBalance);			
			statusArea.append("\nNew Balance of Account #"+accountNo+ "\nis "+getCurrencyFormat(newBalance));		
			}		
		}

		//method to deposit amount
		private void deposit(int accountNo,String accName, double deposit)
		{	
			//searching account number using hash map
			if(!accounts.containsKey(accountNo))
			{		
				statusArea.append("\nAccount doesn't exists");		
			}		
		else{	
			
			// adding amount to the account 
			double oldBal = accounts.get(accountNo);		
			accounts.put(accountNo, oldBal+deposit);		
			statusArea.setText("Deposited " + getCurrencyFormat(deposit) + " into account #" + accountNo + ","+accName +" \nCurrent Balance is "+getCurrencyFormat(accounts.get(accountNo)));		
			}		
		}
		
		//method to withdraw amount
		
		private void withdraw(int accountNo, String accName, double withdrawl)
		{		
			//searching account number using hash map
			if(!accounts.containsKey(accountNo)){		
				statusArea.append("\nAccount doesn't exists");		
		}		
		else{		
			double oldBal = accounts.get(accountNo);			
			if(oldBal-withdrawl<0)
				{		
					statusArea.append("\nNot much amount left in Account #"+accountNo+ "," + accName +"\nCheck Balance");		
				}		
			else{		
				accounts.put(accountNo, oldBal-withdrawl);		
				statusArea.setText("Withdrew " + getCurrencyFormat(withdrawl) + " from account #" + accountNo + "," + accName +" \nCurrent Balance is "+getCurrencyFormat(accounts.get(accountNo)));		
			}		
			}		
		}

		//method to check account balance 
		private void checkBalance(int accountNo)
		{		
			if(!accounts.containsKey(accountNo))	
				{		
					statusArea.append("\nAccount doesn't exists");		
				}		
			else{		
				double bal = accounts.get(accountNo);			 
				statusArea.append("\nThe Current balance in account #"+accountNo+" is "+getCurrencyFormat(bal));		
				}		
		}
		
		//method of currency format
		private String getCurrencyFormat(double number)
		{
			DecimalFormat format = new DecimalFormat("#0.00");		
			return "$"+format.format(number);		
		}
		
		//End of day process button
		private class EndMonthButtonListener implements ActionListener		
		{
			private EndMonthButtonListener() {}				  
		
			
		public void actionPerformed(ActionEvent e)		
		{		
			for (Account type : BankGUI.this.accountList) 
			{		
				type.closeDay();		
			}		
			statusArea.append("\nEnd of month processing completed");		
			}		
		}

		private class ReportButtonListener implements ActionListener		
		{		
			private ReportButtonListener() {}			  
		
		public void actionPerformed(ActionEvent e)		
		{		
			String Reportbutton = "";			
			for (Account type : accountList)		
		{		
				int accountNo = type.getID();
				String accountNam = type.getName();
				String Reporttypes;		
				if ((type instanceof Savings)) 
				{		
					Reporttypes = "Savings ";		
				} else {		
					Reporttypes = "Checking ";	
				}	
			
					Reportbutton = Reportbutton + "\n" + Reporttypes + "account #"+accountNo+","+accountNam+" has a balance of "+getCurrencyFormat(accounts.get(accountNo)); 
		
				}		
				statusArea.append(Reportbutton);
				
			}		
		}
		
		private class clearButtonListener implements ActionListener		
		{		
			private clearButtonListener() {}			  
		
		public void actionPerformed(ActionEvent e)		
		{		
			for (Account type : BankGUI.this.accountList) 
			{	
									
			}		
			statusArea.append(" ");		
			}					
					
		}

	public static void main(String[] args){
		
		BankGUI CommunityBank = new BankGUI();
		Font f = new Font(CommunityBank.getFont().getName(),Font.BOLD, CommunityBank.getFont().getSize());
		CommunityBank.statusArea.setFont(f);
	}
}

