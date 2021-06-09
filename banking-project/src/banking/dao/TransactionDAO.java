package banking.dao;

import java.sql.SQLException;
import banking.model.Transaction;

public interface TransactionDAO {

	boolean createTransaction(Transaction transaction) throws SQLException;
}
