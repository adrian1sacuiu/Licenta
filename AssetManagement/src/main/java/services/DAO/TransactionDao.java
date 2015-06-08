package services.DAO;

import domain.Transaction;

import java.util.List;

/**
 * Created by Adrian on 05-Aug-14.
 */
public interface TransactionDao {
	public Transaction addTransaction(Transaction transaction);

	public Transaction deleteTransaction(Transaction transaction);

	public Transaction getTransactionById(Long id);

	public List<Transaction> getAllTransactions();

	public void updateTransaction(Transaction transaction);
}
