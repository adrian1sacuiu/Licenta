package services;

import domain.Asset;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.AssetDao;

import java.util.List;

@Transactional
@Service
public class AssetService{
	private static final Logger logger = Logger.getLogger(AssetService.class);

	@Autowired
	AssetDao assetDao;
	
	public Asset addAsset(Asset asset) {
		logger.info("in addAsset method.");

		return assetDao.addAsset(asset);
	}

	public boolean updateAsset(Asset asset){
		logger.info("in updateAsset method.");
		
		return assetDao.updateAsset(asset);
	}
	
	public boolean deleteAsset(Asset asset) {
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
	
	public List<Asset> getAssetsByName(String name) {
		logger.info("Inside getAssetsByName method.");

		return assetDao.getAssetsByName(name);
	}
	
	public List<Asset> getAssetsByType(String type) {
		logger.info("Inside getAssetsByType method.");

		return assetDao.getAssetsByType(type);
	}
	
	public List<Asset> getAssetsByIsAvailable(boolean isAvailable) {
		logger.info("Inside getAssetsByIsAvailable method.");

		return assetDao.getAssetsByIsAvailable(isAvailable);
	}
	
	public List<Asset> getAssetsByIsOnStock(boolean isOnStock) {
		logger.info("Inside getAssetsByIsOnStock method.");

		return assetDao.getAssetsByIsOnStock(isOnStock);
	}
}
