package banking.service.impl;

import java.sql.SQLException;

import banking.dao.impl.AccountDaoImpl;
import banking.model.Account;
import banking.model.Transaction;
import banking.model.Transfer;
import banking.service.AccountService;

public class AccountServiceImpl implements AccountService {
	
	private AccountDaoImpl accountDoa = new AccountDaoImpl();
	private TransactionServiceImpl transactionService = new TransactionServiceImpl();
	
	private TransferServiceImpl transferService = new TransferServiceImpl();
	
	public Account getAccountById(int account_id) throws SQLException {
		return accountDoa.getAccountById(account_id);
	}
	
	public void createAccount(Account account) throws SQLException {
		accountDoa.createAccount(account);
	}
	
	public boolean updateBalance(int account_id, double amount) throws SQLException {
		return accountDoa.updateBalance(account_id, amount);
	}
	
	//Deposit
	public void deposit(Account account, double amount) throws SQLException {
		String transactionType = "deposit";
		Transaction transaction  = new Transaction(transactionType, amount, account.getAccount_no());
		if(transactionService.createTransaction(transaction)) {
			double new_balance = account.getBalance() + amount;
			accountDoa.updateBalance(account.getAccount_no(), new_balance);
			//System.out.println("Deposited successfully and the new balance is" + account.getBalance());
			account = accountDoa.getAccountById(account.getAccount_no());
		}else {
			System.out.println("Error Creating Transaction");
		}
	}
	
	
	//Withdrawal
	public void withdraw(Account account, double amount) throws SQLException {
		String transactionType = "withdraw";
		if(account.getBalance() > amount) {
			Transaction transaction  = new Transaction(transactionType, amount, account.getAccount_no());
			if(transactionService.createTransaction(transaction)) {
				double new_balance = account.getBalance() - amount;
				accountDoa.updateBalance(account.getAccount_no(), new_balance);
				System.out.println("Withdrawn successfully and the new balance is" + account.getBalance());
				account = accountDoa.getAccountById(account.getAccount_no());
			}else {
				System.out.println("Error Withdrawing cash");
			}		
		}else {
			System.out.println("Insufficient Balance");
		}	
	}
	
	
	//Tranfer 
	public void transfer(Account fromAccount, Account toAccount, double amount,String reason) throws SQLException {
		Transfer transfer  = new Transfer(fromAccount.getAccount_no(), toAccount.getAccount_no(), amount,reason);
		if(transferService.createTransfer(transfer)) {
			System.out.println("Successfully Transfered from " + fromAccount.getFirstName() + " To " + toAccount.getFirstName());
			double newFrombalance = (fromAccount.getBalance() - amount);
			double newTobalance = toAccount.getBalance() + amount;
			accountDoa.updateBalance(fromAccount.getAccount_no(), newFrombalance);
			accountDoa.updateBalance(toAccount.getAccount_no(),newTobalance);
			fromAccount = accountDoa.getAccountById(fromAccount.getAccount_no());
			toAccount = accountDoa.getAccountById(toAccount.getAccount_no());			
		}
	}
}

