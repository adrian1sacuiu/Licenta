package services.DAO;

import entities.Transaction;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import services.DAO.controller.SessionController;

import java.sql.Date;
import java.util.List;

@Repository
public class TransactionDao extends SessionController {
	private static final Logger logger = Logger.getLogger(TransactionDao.class);

	public boolean addTransaction(Transaction transaction) throws Exception {
		logger.info("Inside addTransaction method.");
		boolean result = false;

		try {
			getCurrentSession().save(transaction);
			result = true;

		} catch (Exception e) {
			logger.error("in addTransaction method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	public boolean updateTransaction(Transaction transaction) throws Exception {
		logger.info("Inside updateTransaction method.");
		boolean result = false;

		try {
			getCurrentSession().merge(transaction);
			result = true;

		} catch (Exception e) {
			logger.error("in updateTransaction method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	public boolean deleteTransaction(Transaction transaction) throws Exception {
		logger.info("Inside deleteTransaction method.");
		boolean result = false;

		try {
			getCurrentSession().delete(transaction);
			result = true;

		} catch (Exception e) {
			logger.error("in deleteTransaction method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> getAllTransactions() throws Exception {
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

	public Transaction getTransactionById(Long id) throws Exception {
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
	public List<Transaction> getTransactionsByDate(Date date) throws Exception {
		logger.info("Inside getTransactionsByDate method.");
		List<Transaction> transactions = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getTransactionsByDate");
			query.setParameter("date", date);

			transactions = (List<Transaction>) query.list();

		} catch (Exception e) {
			logger.error("in getTransactionsByDate method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return transactions;
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> getTransactionsByStatus(String status) throws Exception {
		logger.info("Inside getTransactionsByStatus method.");
		List<Transaction> transactions = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getTransactionsByStatus");
			query.setParameter("status", status);

			transactions = (List<Transaction>) query.list();

		} catch (Exception e) {
			logger.error("in getTransactionsByStatus method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return transactions;
	}
	
	@SuppressWarnings("unchecked")
	public List<Transaction> getTransactionsByUser(String username) throws Exception {
		logger.info("Inside getTransactionsByUser method.");
		List<Transaction> transactions = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getTransactionsByUser");
			query.setParameter("username", username);

			transactions = (List<Transaction>) query.list();

		} catch (Exception e) {
			logger.error("in getTransactionsByStatus method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return transactions;
	}
	
	@SuppressWarnings("unchecked")
	public List<Transaction> getTransactionsByAsset(Long idAsset) throws Exception {
		logger.info("Inside getTransactionsByAsset method.");
		List<Transaction> transactions = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getTransactionsByAsset");
			query.setParameter("idAsset", idAsset);

			transactions = (List<Transaction>) query.list();

		} catch (Exception e) {
			logger.error("in getTransactionsByAsset method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return transactions;
	}

}
