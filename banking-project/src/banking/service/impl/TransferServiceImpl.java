package banking.service.impl;

import java.sql.SQLException;

import banking.dao.impl.TransferDaoImpl;
import banking.model.Transfer;

public class TransferServiceImpl {

	private TransferDaoImpl transferDoa = new TransferDaoImpl();
	
	public boolean createTransfer(Transfer transfer) throws SQLException {
		return transferDoa.createTransfer(transfer);
	}
	
}
