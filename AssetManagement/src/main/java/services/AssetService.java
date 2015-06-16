package services;

import domain.Asset;
import domain.User;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.AssetDao;
import services.DAO.UserDao;

import java.util.List;

@Transactional
@Service
public class AssetService {
	private static final Logger logger = Logger.getLogger(AssetService.class);

	@Autowired
	AssetDao assetDao;
	
	@Autowired
	UserDao userDao;

	public Asset addAsset(Asset asset) throws Exception {
		logger.info("in addAsset method.");

		return assetDao.addAsset(asset);
	}

	public boolean updateAsset(Asset asset) throws Exception {
		logger.info("in updateAsset method.");

		return assetDao.updateAsset(asset);
	}

	public boolean deleteAsset(Asset asset) throws Exception {
		logger.info("in deleteAsset method.");

		return assetDao.deleteAsset(asset);
	}

	@Transactional(readOnly = true)
	public List<Asset> getAllAssets() {
		logger.info("in getAllAssets method.");

		return assetDao.getAllAssets();
	}

	@Transactional(readOnly = true)
	public Asset getAssetById(Long id) {
		logger.info("in getAssetById method.");

		return assetDao.getAssetById(id);
	}

	@Transactional(readOnly = true)
	public List<Asset> getAssetsByName(String name) {
		logger.info("Inside getAssetsByName method.");

		return assetDao.getAssetsByName(name);
	}

	@Transactional(readOnly = true)
	public List<Asset> getAssetsByType(String type) {
		logger.info("Inside getAssetsByType method.");

		return assetDao.getAssetsByType(type);
	}

	@Transactional(readOnly = true)
	public List<Asset> getAssetsByIsAvailable(boolean isAvailable) {
		logger.info("Inside getAssetsByIsAvailable method.");

		return assetDao.getAssetsByIsAvailable(isAvailable);
	}

	@Transactional(readOnly = true)
	public List<Asset> getAssetsByIsOnStock(boolean isOnStock) {
		logger.info("Inside getAssetsByIsOnStock method.");

		return assetDao.getAssetsByIsOnStock(isOnStock);
	}
	
	@Transactional(readOnly = true)
	public List<Asset> getAssetsForUser(String username){
		logger.info("Inside getAssetsForUser method.");
		
		User user = userDao.getUserByUsername(username);
		List<Asset> assets = user.getAssets();
		Hibernate.initialize(assets);
		
		return assets;
	}
}
