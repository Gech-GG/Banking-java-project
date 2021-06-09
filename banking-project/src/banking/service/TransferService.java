package banking.service;

import java.sql.SQLException;

import banking.model.Transfer;

public interface TransferService {

	boolean createTransfer(Transfer transfer) throws SQLException;
}
