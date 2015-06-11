package services.DAO;

import domain.Transaction;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import services.DAO.controller.SessionController;

import java.util.List;

@Repository
public class TransactionDao extends SessionController{
	private static final Logger logger = Logger.getLogger(TransactionDao.class);
	
	public Transaction addTransaction(Transaction transaction) {
		logger.info("Inside addTransaction method.");
		
		try {
			getCurrentSession().save(transaction);
		} catch (Exception e) {
			logger.error("in addTransaction method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return transaction;
	}

	public Transaction deleteTransaction(Transaction transaction) {
		logger.info("Inside deleteTransaction method.");
		
		try {
			getCurrentSession().delete(transaction);
		} catch (Exception e) {
			logger.error("in deleteTransaction method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return transaction;
	}

	public Transaction getTransactionById(Long id) {
		logger.info("Inside getTransactionById method.");
		
		Transaction transaction = null;
		
		try {
			transaction = (Transaction) getCurrentSession().get(Transaction.class, id);
		} catch (Exception e) {
			logger.error("in getTransactionById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return transaction;
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> getAllTransactions() {
		logger.info("Inside getAllTransactions method.");
		
		List<Transaction> transactions = null;
		
		try {
			transactions = getCurrentSession().createCriteria(Transaction.class).list();
		} catch (HibernateException e) {
			logger.error("in getAllTransactions method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return transactions;
	}

	public void updateTransaction(Transaction transaction) {
		logger.info("Inside updateTransaction method.");
		
		try {
			getCurrentSession().update(transaction);
		} catch (Exception e) {
			logger.error("in updateTransaction method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
	}
}
