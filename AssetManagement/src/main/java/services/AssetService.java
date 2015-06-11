package services;

import domain.Asset;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.AssetDao;

import java.util.List;

/**
 * Created by Adrian on 06-Aug-14.
 */
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

	public List<Asset> getAllAssets() {
		logger.info("in getAllAssets method.");

		return assetDao.getAllAssets();
	}

}
