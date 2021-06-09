package banking.dao;

import java.sql.SQLException;

import banking.model.Transfer;

public interface TransferDAO {
	
	boolean createTransfer(Transfer transfer) throws SQLException;

}
