package banking.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import banking.dao.impl.TransactionDaoImpl;
import banking.dbutil.ConnectionFactory;
import banking.model.Account;
import banking.model.Transaction;

public class TransactionServiceImpl {

	TransactionDaoImpl transactionDao = new TransactionDaoImpl();
	public boolean createTransaction(Transaction transaction) throws SQLException {
		return transactionDao.createTransaction(transaction);
		
	}
	
	//deposit
	//withdraw
	//transfer
}
