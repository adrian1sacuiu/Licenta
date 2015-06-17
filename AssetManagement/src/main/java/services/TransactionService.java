package services;

import entities.Transaction;
import entities.User;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.TransactionDao;
import services.DAO.UserDao;

import java.sql.Date;
import java.util.List;

@Transactional
@Service
public class TransactionService {
	private static final Logger logger = Logger.getLogger(TransactionService.class);

	@Autowired
	TransactionDao transactionDao;

	@Autowired
	UserDao userDao;

	public boolean addTransaction(Transaction transaction) throws Exception {
		logger.info("in addTransaction method.");
		boolean result = false;

		try {
			result = transactionDao.addTransaction(transaction);

		} catch (Exception e) {
			logger.error("in addTransaction method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	public boolean updateTransaction(Transaction transaction) throws Exception {
		logger.info("in updateTransaction method.");
		boolean result = false;

		try {
			result = transactionDao.updateTransaction(transaction);

		} catch (Exception e) {
			logger.error("in updateTransaction method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	public boolean deleteTransaction(Transaction transaction) throws Exception {
		logger.info("in deleteTransaction method.");
		boolean result = false;

		try {
			result = transactionDao.deleteTransaction(transaction);

		} catch (Exception e) {
			logger.error("in deleteTransaction method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	@Transactional(readOnly = true)
	public List<Transaction> getAllTransactions() throws Exception {
		logger.info("in getAllTransactions method.");
		List<Transaction> transactions = null;

		try {
			transactions = transactionDao.getAllTransactions();

		} catch (Exception e) {
			logger.error("in getAllTransactions method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return transactions;
	}

	@Transactional(readOnly = true)
	public Transaction getTransactionById(Long id) throws Exception {
		logger.info("in getTransactionById method.");
		Transaction transaction = null;

		try {
			transaction = transactionDao.getTransactionById(id);

		} catch (Exception e) {
			logger.error("in getTransactionById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return transaction;
	}

	@Transactional(readOnly = true)
	public List<Transaction> getTransactionsByDate(Date date) throws Exception {
		logger.info("in getTransactionsByDate method.");
		List<Transaction> transactions = null;

		try {
			transactions = transactionDao.getTransactionsByDate(date);

		} catch (Exception e) {
			logger.error("in getTransactionsByDate method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return transactions;
	}

	@Transactional(readOnly = true)
	public List<Transaction> getTransactionsByStatus(String status) throws Exception {
		logger.info("in getTransactionsByStatus method.");
		List<Transaction> transactions = null;

		try {
			transactions = transactionDao.getTransactionsByStatus(status);

		} catch (Exception e) {
			logger.error("in getTransactionsByStatus method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return transactions;
	}

	@Transactional(readOnly = true)
	public List<Transaction> getTransactionsForUser(String username) throws Exception {
		logger.info("Inside getTransactionsForUser method.");

		User user = null;
		List<Transaction> transactions = null;

		try {
			user = userDao.getUserByUsername(username);
			transactions = user.getTransactions();
			Hibernate.initialize(transactions);

		} catch (Exception e) {
			logger.error("in getTransactionsForUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return transactions;
	}

}
