package services;

import domain.Transaction;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.TransactionDao;

import java.sql.Date;
import java.util.List;

@Transactional
@Service
public class TransactionService {
	private static final Logger logger = Logger.getLogger(TransactionService.class);

	@Autowired
	TransactionDao transactionDao;

	public boolean addTransaction(Transaction transaction) throws Exception {
		logger.info("in addTransaction method.");

		return transactionDao.addTransaction(transaction);
	}

	public boolean updateTransaction(Transaction transaction) throws Exception {
		logger.info("in updateTransaction method.");

		return transactionDao.updateTransaction(transaction);
	}

	public boolean deleteTransaction(Transaction transaction) throws Exception {
		logger.info("in deleteTransaction method.");

		return transactionDao.deleteTransaction(transaction);
	}

	@Transactional(readOnly = true)
	public List<Transaction> getAllTransactions() {
		logger.info("in getAllTransactions method.");

		return transactionDao.getAllTransactions();
	}

	@Transactional(readOnly = true)
	public Transaction getTransactionById(Long id) {
		logger.info("in getTransactionById method.");

		return transactionDao.getTransactionById(id);
	}

	public List<Transaction> getTransactionsByDate(Date date) {
		logger.info("Inside getTransactionsByDate method.");

		return transactionDao.getTransactionsByDate(date);
	}

	public List<Transaction> getTransactionsByStatus(String status) {
		logger.info("Inside getTransactionsByStatus method.");

		return transactionDao.getTransactionsByStatus(status);
	}

}
