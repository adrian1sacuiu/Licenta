package services.DAO;

import domain.Asset;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Adrian on 03-Aug-14.
 */
@Repository
public class AssetDaoImpl implements AssetDao{
    private SessionFactory sessionFactory;
    @Autowired
    public AssetDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
    public Asset addAsset(Asset asset){
        currentSession().save(asset);
        return asset;
    }
    public Asset deleteAsset(Asset asset){
        currentSession().delete(asset);
        return asset;
    }
    public Asset getAssetById(Long id){
        return (Asset)currentSession().get(Asset.class,id);
    }
    public List<Asset> getAllAssets(){
        return currentSession().createCriteria(Asset.class).list();
    }
    public void saveAsset(Asset asset){
        currentSession().update(asset);
    }
}
