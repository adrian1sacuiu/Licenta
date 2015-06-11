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
 * Created by Adrian on 05-Aug-14.
 */
@Service
@Transactional
public class UserService{
	private static final Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	AssetDao assetDao;
	
	@Autowired
	TransactionDao transactionDao;

	public User createUser(User user) {
		logger.info("in createUser method.");
		
		return userDao.addUser(user);
	}

	@Transactional(readOnly = true)
	public User getUserById(Long id) {
		logger.info("in getUserById method.");
		
		return userDao.getUserById(id);
	}
	
	@Transactional(readOnly = true)
	public List<User> getUserByName(String name) {
		logger.info("in getUserByName method.");
		
		return userDao.getUserByName(name);
	}

	public User deleteUser(Long id) {
		logger.info("in deleteUser method.");
		
		User user = userDao.getUserById(id);
		List<Asset> assets = user.getAssets();
		
		if (!assets.isEmpty()) {
			for (Asset asset : assets) {
				asset.setAvailable(true);
				asset.setUser(null);
				assetDao.updateAsset(asset);
			}
		}
		
		return (userDao.deleteUser(user));
	}

	public String changePassword(Long id, String password) {
		logger.info("in changePassword method.");
		
		User user = getUserById(id);
		user.setPassword(password);
		userDao.updateUser(user);
		
		return password;
	}

	public String changeEmail(Long id, String email) {
		logger.info("in changeEmail method.");
		
		User user = getUserById(id);
		user.setEmail(email);
		userDao.updateUser(user);
		
		return email;
	}

	@Transactional(readOnly = true)
	public List<Asset> getUserAssets(Long id) {
		logger.info("in getUserAssets method.");
		
		List<Asset> assets = getUserById(id).getAssets();
		Hibernate.initialize(assets);
		
		return assets;
	}

	@Transactional(readOnly = true)
	public List<Transaction> getUserTransactions(Long id) {
		logger.info("in getUserTransactions method.");
		
		List<Transaction> transactions = getUserById(id).getTransactions();
		Hibernate.initialize(transactions);
		
		return transactions;
	}

	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		logger.info("in getAllUsers method.");
		
		return userDao.getAllUsers();
	}
}
