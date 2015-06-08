package services;

import domain.Asset;
import domain.Transaction;
import domain.User;
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
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	AssetDao assetDao;
	@Autowired
	TransactionDao transactionDao;

	public User createUser(User user) {
		return userDao.addUser(user);
	}

	@Transactional(readOnly = true)
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}

	public User deleteUser(Long id) {
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
		User user = getUserById(id);
		user.setPassword(password);
		userDao.updateUser(user);
		return password;
	}

	public String changeEmail(Long id, String email) {
		User user = getUserById(id);
		user.setEmail(email);
		userDao.updateUser(user);
		return email;
	}

	@Transactional(readOnly = true)
	public List<Asset> getUserAssets(Long id) {
		List<Asset> assets = getUserById(id).getAssets();
		Hibernate.initialize(assets);
		return assets;
	}

	@Transactional(readOnly = true)
	public List<Transaction> getUserTransactions(Long id) {
		List<Transaction> transactions = getUserById(id).getTransactions();
		Hibernate.initialize(transactions);
		return transactions;
	}

	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
