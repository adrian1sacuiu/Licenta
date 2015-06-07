package services;

import domain.Asset;
import domain.Transaction;
import domain.User;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import services.DAO.AssetDao;
import services.DAO.TransactionDao;
import services.DAO.UserDao;

import java.util.List;

/**
 * Created by Adrian on 06-Aug-14.
 */
@Transactional
@Service
public class AssetServiceImpl implements AssetService{
    @Autowired
    UserDao userDao;
    @Autowired
    AssetDao assetDao;
    @Autowired
    TransactionDao transactionDao;
    public Asset createAsset(Asset asset){
        return assetDao.addAsset(asset);
    }
    @Transactional(readOnly = true)
    public Asset getAssetById(Long id){
        return assetDao.getAssetById(id);
    }
    public Asset deleteAsset(Long id){
        Asset asset=assetDao.getAssetById(id);
        assetDao.deleteAsset(asset);
        return asset;
    }
    public User removeUserFromAsset(Long id){
        Asset asset=getAssetById(id);
        User user=asset.getUser();
        asset.setUser(null);
        asset.setAvailable(true);
        return user;
    }
    public List<Asset> getAllAssets(){
        return assetDao.getAllAssets();
    }
    public User getAssetUser(Long id){
        return getAssetById(id).getUser();
    }
    public List<Transaction> getAssetTransactions(Long id){
        List<Transaction> transactions=getAssetById(id).getTransactions();
        Hibernate.initialize(transactions);
        return transactions;
    }
}
