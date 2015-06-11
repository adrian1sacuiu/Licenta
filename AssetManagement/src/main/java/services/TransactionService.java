package services;

import domain.Transaction;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.TransactionDao;

import java.util.List;

@Transactional
@Service
public class TransactionService{
	private static final Logger logger = Logger.getLogger(TransactionService.class);

	@Autowired
	TransactionDao transactionDao;

	@Transactional(readOnly = true)
	public Transaction getTransactionById(Long id) {
		logger.info("in getTransactionById method.");
		
		return transactionDao.getTransactionById(id);
	}

	@Transactional(readOnly = true)
	public List<Transaction> getAllTransactions() {
		logger.info("in getAllTransactions method.");
		
		return transactionDao.getAllTransactions();
	}

}
