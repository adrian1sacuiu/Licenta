package services;

import domain.Asset;
import domain.Transaction;
import domain.User;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.AssetDao;
import services.DAO.TransactionDao;
import services.DAO.UserDao;

import java.util.List;

/**
 * Created by Adrian on 06-Aug-14.
 */
@Transactional
@Service
public class AssetServiceImpl implements AssetService {
	private static final Logger logger = Logger.getLogger(AssetServiceImpl.class);

	@Autowired
	UserDao userDao;
	
	@Autowired
	AssetDao assetDao;
	
	@Autowired
	TransactionDao transactionDao;

	public Asset createAsset(Asset asset) {
		logger.info("in createAsset method.");

		return assetDao.addAsset(asset);
	}

	@Transactional(readOnly = true)
	public Asset getAssetById(Long id) {
		logger.info("in getAssetById method.");

		return assetDao.getAssetById(id);
	}

	public Asset deleteAsset(Long id) {
		logger.info("in deleteAsset method.");

		Asset asset = assetDao.getAssetById(id);
		assetDao.deleteAsset(asset);
		
		return asset;
	}

	public User removeUserFromAsset(Long id) {
		logger.info("in removeUserFromAsset method.");

		Asset asset = getAssetById(id);
		User user = asset.getUser();
		
		asset.setUser(null);
		asset.setAvailable(true);
		
		return user;
	}

	public List<Asset> getAllAssets() {
		logger.info("in getAllAssets method.");

		return assetDao.getAllAssets();
	}

	public User getAssetUser(Long id) {
		logger.info("in getAssetUser method.");

		return getAssetById(id).getUser();
	}

	public List<Transaction> getAssetTransactions(Long id) {
		logger.info("in getAssetTransactions method.");

		List<Transaction> transactions = getAssetById(id).getTransactions();
		Hibernate.initialize(transactions);
		
		return transactions;
	}
}
