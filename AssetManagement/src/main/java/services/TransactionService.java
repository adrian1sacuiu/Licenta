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

	@Transactional(readOnly = true)
	public List<Transaction> getTransactionsByDate(Date date) {
		logger.info("Inside getTransactionsByDate method.");

		return transactionDao.getTransactionsByDate(date);
	}

	@Transactional(readOnly = true)
	public List<Transaction> getTransactionsByStatus(String status) {
		logger.info("Inside getTransactionsByStatus method.");

		return transactionDao.getTransactionsByStatus(status);
	}
	
	@Transactional(readOnly = true)
	public List<Transaction> getTransactionsForUser(String username){
		logger.info("Inside getTransactionsForUser method.");

		User user = userDao.getUserByUsername(username);		
		List<Transaction> transactions = user.getTransactions();
		Hibernate.initialize(transactions);;
		
		return transactions;
	}

}
