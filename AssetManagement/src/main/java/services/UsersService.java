package services;

import domain.Asset;
import domain.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.AssetDao;
import services.DAO.UserDao;

import java.util.List;

@Service
@Transactional
public class UsersService {
	private static final Logger logger = Logger.getLogger(UsersService.class);

	@Autowired
	UserDao userDao;

	@Autowired
	AssetDao assetDao;

	public boolean addUser(User user) throws Exception {
		logger.info("in addUser method.");

		return userDao.addUser(user);
	}

	public boolean updateUser(User user) throws Exception {
		logger.info("in updateUser method.");

		return userDao.updateUser(user);
	}

	public boolean deleteUser(User user) throws Exception {
		logger.info("in deleteUser method.");

		List<Asset> assets = user.getAssets();
		if (!assets.isEmpty()) {
			for (Asset asset : assets) {
				asset.setIsAvailable(true);
				asset.setUser(null);
				assetDao.updateAsset(asset);
			}
		}

		return userDao.deleteUser(user);
	}

	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		logger.info("in getAllUsers method.");

		return userDao.getAllUsers();
	}

	@Transactional(readOnly = true)
	public User getUserById(Long id) {
		logger.info("in getUserById method.");

		return userDao.getUserById(id);
	}

	@Transactional(readOnly = true)
	public List<User> getUsersByName(String name) {
		logger.info("in getUserByName method.");

		return userDao.getUsersByName(name);
	}

	@Transactional(readOnly = true)
	public User getUserByEmail(String email) {
		logger.info("in getUserByEmail method.");

		return userDao.getUserByEmail(email);
	}

	@Transactional(readOnly = true)
	public List<User> getUsersByRole(String role) {
		logger.info("in getUsersByRole method.");

		return userDao.getUsersByRole(role);
	}
}
