package services.DAO;

import domain.Asset;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import services.DAO.controller.SessionController;

import java.util.List;

/**
 * Created by Adrian on 03-Aug-14.
 */
@Repository
public class AssetDao extends SessionController{
	private static final Logger logger = Logger.getLogger(AssetDao.class);
	
	public Asset addAsset(Asset asset) {
		logger.info("Inside addAsset method.");
		
		try{
			getCurrentSession().save(asset);
		} catch(Exception e){
			logger.error("in addAsset method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return asset;
	}

	public Asset deleteAsset(Asset asset) {
		logger.info("Inside deleteAsset method.");
		
		try {
			getCurrentSession().delete(asset);
		} catch (Exception e) {
			logger.error("in deleteAsset method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return asset;
	}

	public Asset getAssetById(Long id) {
		logger.info("Inside getAssetById method.");
		
		Asset asset = null;
		
		try {
			asset = (Asset) getCurrentSession().get(Asset.class, id);
		} catch (Exception e) {
			logger.error("in getAssetById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return asset;
	}

	@SuppressWarnings("unchecked")
	public List<Asset> getAllAssets() {
		logger.info("Inside getAllAssets method.");
		
		List<Asset> assets = null;
		
		try {
			assets = getCurrentSession().createCriteria(Asset.class).list();
		} catch (Exception e) {
			logger.error("in getAllAssets method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return assets;
	}

	public void updateAsset(Asset asset) {
		logger.info("Inside updateAsset method.");
		
		try {
			getCurrentSession().update(asset);
		} catch (Exception e) {
			logger.error("in updateAsset method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
	}
}
