package banking.service;

import java.sql.SQLException;

import banking.model.Account;

public interface AccountService {

	Account getAccountById(int account_id) throws SQLException;
	void createAccount(Account account) throws SQLException;
	boolean updateBalance(int account_id, double amount) throws SQLException;
	public void deposit(Account account, double amount) throws SQLException;
	public void withdraw(Account account, double amount) throws SQLException;
	public void transfer(Account fromAccount, Account toAccount, double amount,String reason) throws SQLException;
}
