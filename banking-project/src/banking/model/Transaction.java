package banking.model;

public class Transaction {

	private int transactionId;
	private String transactionType;
	private double amount;
	private int accountNo;
	
	public Transaction(String transactionType, double amount, int accountNo) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.accountNo = accountNo;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType + ", amount="
				+ amount + ", accountNo=" + accountNo + "]";
	}
	
	
	
	
}
