package banking.model;

public class Account {
	
	private int account_no;
	private String firstName;
	private String lastName;
	private double balance;
	
/*	public Account(int account_no, String firstName, String lastName, double balance) {
		this.account_no = account_no;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	*/
	
	public Account(String firstName, String lastName, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	public Account() {
		
	}

	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [account_no=" + account_no + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", balance=" + balance + "]";
	}

	public Transaction deposit(double amount) {
		Transaction tran = new Transaction("deposit",amount,this.account_no);
		this.balance = this.balance + amount;
		return tran;
	}
	
	public Transaction withdraw(double amount) {
		Transaction tran = new Transaction("withdraw",amount,this.account_no);
		this.balance = this.balance - amount;
		return tran;
	}
	
	public Transfer transfer(Account a1, Account a2,double amount) {
		Transfer transfer = new Transfer(a1.account_no,a2.account_no,amount);
		a1.balance = a1.balance - amount;
		a2.balance = a2.balance + amount;
		return transfer;
	}
	
	
	
	
	

}
