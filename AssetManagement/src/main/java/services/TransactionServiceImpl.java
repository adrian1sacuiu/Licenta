package services;

import domain.Asset;
import domain.Transaction;
import domain.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.AssetDao;
import services.DAO.TransactionDao;
import services.DAO.UserDao;

import java.util.Date;
import java.util.List;

/**
 * Created by internship on 8/6/2014.
 */
@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {
	private static final Logger logger = Logger.getLogger(TransactionServiceImpl.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	AssetDao assetDao;
	
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

	public Long requestAssetByUser(Long idUser, Long idAsset) {
		logger.info("in requestAssetByUser method.");
		
		User user = userDao.getUserById(idUser);
		Asset asset = assetDao.getAssetById(idAsset);
		
		Transaction transaction = new Transaction();
		transaction.setAsset(asset);
		transaction.setUser(user);
		transaction.setDate(new Date());
		transaction.setStatus("Pending");
		
		transactionDao.addTransaction(transaction);
		
		return transaction.getIdTransaction();
	}

	public Asset addAssetToUser(Long idUser, Long idAsset, Long idTransaction) {
		logger.info("in addAssetToUser method.");
		
		Asset asset = assetDao.getAssetById(idAsset);
		asset.setAvailable(false);
		asset.setUser(userDao.getUserById(idUser));
		
		transactionDao.getTransactionById(idTransaction).setStatus("Completed");
		
		return asset;
	}
}
