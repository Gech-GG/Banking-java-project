package banking.dao;

import java.sql.SQLException;

import banking.model.Account;

public interface AccountDAO {

	Account getAccountById(int accountNo) throws SQLException;
	boolean createAccount(Account acc) throws SQLException ;
	boolean updateAccount(Account acc) throws SQLException ;
	boolean updateBalance(int account_no, double newBalance) throws SQLException ;
}
