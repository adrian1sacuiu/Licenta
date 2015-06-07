package services.DAO;

import domain.Asset;

import java.util.List;

/**
 * Created by Adrian on 05-Aug-14.
 */
public interface AssetDao {
    public Asset addAsset(Asset asset);
    public Asset deleteAsset(Asset asset);
    public Asset getAssetById(Long id);
    public List<Asset> getAllAssets();
    public void saveAsset(Asset asset);
}
