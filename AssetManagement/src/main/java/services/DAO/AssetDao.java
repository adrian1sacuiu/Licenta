package services.DAO;

import entities.Asset;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import services.DAO.controller.SessionController;

import java.util.List;

@Repository
public class AssetDao extends SessionController {
	private static final Logger logger = Logger.getLogger(AssetDao.class);

	public Asset addAsset(Asset asset) throws Exception {
		logger.info("Inside addAsset method.");

		try {
			getCurrentSession().save(asset);

		} catch (Exception e) {
			logger.error("in addAsset method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return asset;
	}

	public boolean updateAsset(Asset asset) throws Exception {
		logger.info("Inside updateAsset method.");
		boolean result = false;

		try {
			getCurrentSession().update(asset);
			result = true;

		} catch (Exception e) {
			logger.error("in updateAsset method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	public boolean deleteAsset(Asset asset) throws Exception {
		logger.info("Inside deleteAsset method.");
		boolean result = false;

		try {
			getCurrentSession().delete(asset);
			result = true;

		} catch (Exception e) {
			logger.error("in deleteAsset method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
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
	public List<Asset> getAssetsByName(String name) {
		logger.info("Inside getAssetsByName method.");
		List<Asset> assets = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getAssetsByName");
			query.setParameter("name", name);

			assets = (List<Asset>) query.list();

		} catch (Exception e) {
			logger.error("in getAssetsByName method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return assets;
	}

	@SuppressWarnings("unchecked")
	public List<Asset> getAssetsByType(String type) {
		logger.info("Inside getAssetsByType method.");
		List<Asset> assets = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getAssetsByType");
			query.setParameter("type", type);

			assets = (List<Asset>) query.list();

		} catch (Exception e) {
			logger.error("in getAssetsByType method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return assets;
	}

	@SuppressWarnings("unchecked")
	public List<Asset> getAssetsByIsAvailable(boolean isAvailable) {
		logger.info("Inside getAssetsByIsAvailable method.");
		List<Asset> assets = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getAssetsByIsAvailable");
			query.setParameter("isAvailable", isAvailable);

			assets = (List<Asset>) query.list();

		} catch (Exception e) {
			logger.error("in getAssetsByIsAvailable method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return assets;
	}

	@SuppressWarnings("unchecked")
	public List<Asset> getAssetsByIsOnStock(boolean isOnStock) {
		logger.info("Inside getAssetsByIsOnStock method.");
		List<Asset> assets = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getAssetsByIsOnStock");
			query.setParameter("isOnStock", isOnStock);

			assets = (List<Asset>) query.list();

		} catch (Exception e) {
			logger.error("in getAssetsByIsOnStock method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return assets;
	}

}
