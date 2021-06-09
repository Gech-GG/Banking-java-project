package banking.service;

import java.sql.SQLException;
import banking.model.Transfer;

public interface TransactionService {

	boolean createTransfer(Transfer transfer) throws SQLException;
}
