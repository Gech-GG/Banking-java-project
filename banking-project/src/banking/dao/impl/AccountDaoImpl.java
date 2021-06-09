package banking.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import banking.dao.AccountDAO;
import banking.dbutil.ConnectionFactory;
import banking.model.Account;

public class AccountDaoImpl implements AccountDAO {
	
	public Account getAccountById(int accountNo) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();	
		try {
			String sql = "select * from account where account_no = " + accountNo ;	
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return extractAccount(rs);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		
		return null;

	}
	public boolean createAccount(Account acc) throws SQLException {		
		Connection conn = ConnectionFactory.getConnection();
		int rowsInserted = 0;
		try {
			String sql = "insert into account(first_name, last_name, balance) values(?,?,?);";
			PreparedStatement prepStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prepStmt.setString(1, acc.getFirstName());
			prepStmt.setString(2, acc.getLastName());
			prepStmt.setDouble(3, acc.getBalance());
			rowsInserted = prepStmt.executeUpdate();
			try (ResultSet rs = prepStmt.getGeneratedKeys()){
				if(rs.next()) {
					acc.setAccount_no(rs.getInt(1));
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
	
	
	public boolean updateAccount(Account acc) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		int updatedRow = 0;
		try {		
			String sql = "update account set first_name = ?, set last_name = ?, set balance = ? where account_no = ?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, acc.getFirstName());
			prepStmt.setString(2, acc.getLastName());
			prepStmt.setDouble(3, acc.getBalance());
			prepStmt.setDouble(4, acc.getAccount_no());
			updatedRow = prepStmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		if(updatedRow == 1)
			return true;
		else
			return false;
	}
	
	public boolean updateBalance(int account_no, double newBalance) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		int updatedRow = 0;
		try {		
			String sql = "update account set balance = ? where account_no = ?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setDouble(1, newBalance);
			prepStmt.setDouble(2, account_no);
			updatedRow = prepStmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		if(updatedRow == 1)
			return true;
		else
			return false;
	}
	
	private Account extractAccount(ResultSet rs) throws SQLException {		
			Account account = new Account();
			account.setAccount_no(rs.getInt("account_no"));
			account.setFirstName(rs.getString("first_name"));
			account.setLastName(rs.getString("last_name"));
			account.setBalance(rs.getDouble("balance"));
			
			return account;
	}
	
	
}
