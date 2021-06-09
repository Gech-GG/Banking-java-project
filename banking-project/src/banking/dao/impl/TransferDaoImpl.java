package banking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import banking.dao.TransferDAO;
import banking.dbutil.ConnectionFactory;
import banking.model.Transfer;

public class TransferDaoImpl implements TransferDAO{
	
	public boolean createTransfer(Transfer transfer) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		int rowsInserted = 0;
		try {
			String sql = "insert into transfer(from_account, to_account, amount, reason) values(?,?,?,?);";
			PreparedStatement prepStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prepStmt.setInt(1, transfer.getFromAccount());
			prepStmt.setInt(2, transfer.getToAccount());
			prepStmt.setDouble(3, transfer.getAmount());
			prepStmt.setString(4, transfer.getReason());
			rowsInserted = prepStmt.executeUpdate();
			/*try (ResultSet rs = prepStmt.getGeneratedKeys()){
				if(rs.next()) {
					transfer.setTransferId(rs.getInt(1));
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}*/
			
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
