package banking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import banking.dao.TransactionDAO;
import banking.dbutil.ConnectionFactory;
import banking.model.Account;
import banking.model.Transaction;

public class TransactionDaoImpl implements TransactionDAO {
	
	public boolean createTransaction(Transaction transaction) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		int rowsInserted = 0;
		try {
			String sql = "insert into transaction(transaction_type, amount, account_no) "
					+ "values(?,?,?);";
			PreparedStatement prepStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prepStmt.setString(1, transaction.getTransactionType());
			prepStmt.setDouble(2, transaction.getAmount());
			prepStmt.setInt(3, transaction.getAccountNo());
			rowsInserted = prepStmt.executeUpdate();
			try (ResultSet rs = prepStmt.getGeneratedKeys()){
				if(rs.next()) {
					transaction.setTransactionId(rs.getInt(1));
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		if(rowsInserted == 1)
			return true;
		else
			return false;
	}

}
