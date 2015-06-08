package services;

import domain.Asset;
import domain.Transaction;
import domain.User;

import java.util.List;

/**
 * Created by Adrian on 06-Aug-14.
 */
public interface AssetService {
	public Asset createAsset(Asset asset);

	public Asset getAssetById(Long id);

	public Asset deleteAsset(Long id);

	public User removeUserFromAsset(Long id);

	public List<Asset> getAllAssets();

	public User getAssetUser(Long id);

	public List<Transaction> getAssetTransactions(Long id);
}
