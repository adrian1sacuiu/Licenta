package services;

import domain.Asset;
import domain.Transaction;
import domain.User;
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
	@Autowired
	UserDao userDao;
	@Autowired
	AssetDao assetDao;
	@Autowired
	TransactionDao transactionDao;

	@Transactional(readOnly = true)
	public Transaction getTransactionById(Long id) {
		return transactionDao.getTransactionById(id);
	}

	@Transactional(readOnly = true)
	public List<Transaction> getAllTransactions() {
		return transactionDao.getAllTransactions();
	}

	public Long requestAssetByUser(Long idUser, Long idAsset) {
		User user = userDao.getUserById(idUser);
		Asset asset = assetDao.getAssetById(idAsset);
		Transaction transaction = new Transaction();
		transaction.setAsset(asset);
		transaction.setUser(user);
		transaction.setDate(new Date());
		transaction.setStatus("Pending");
		transactionDao.addTransaction(transaction);
		return transaction.getId();
	}

	public Asset addAssetToUser(Long idUser, Long idAsset, Long idTransaction) {
		Asset asset = assetDao.getAssetById(idAsset);
		asset.setAvailable(false);
		asset.setUser(userDao.getUserById(idUser));
		transactionDao.getTransactionById(idTransaction).setStatus("Completed");
		return asset;
	}
}
