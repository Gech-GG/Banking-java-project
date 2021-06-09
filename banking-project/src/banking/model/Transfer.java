package banking.model;

public class Transfer {
	
	private int transferId;
	private int fromAccount;
	private int toAccount;
	private double amount;
	private String reason;
	
	public Transfer(int fromAccount, int toAccount, double amount, String reason) {
		
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.reason = reason;
	}
	
	public Transfer(int fromAccount, int toAccount, double amount) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public int getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}

	public int getToAccount() {
		return toAccount;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Transfer [transferId=" + transferId + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount
				+ ", amount=" + amount + ", reason=" + reason + "]";
	}
	
	
	

}
