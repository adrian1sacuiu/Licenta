import domain.Asset;
import domain.Transaction;
import org.junit.Test;
import domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.AssetService;
import services.DAO.UserDaoImpl;
import services.TransactionService;
import services.UserService;
import services.UserServiceImpl;

import java.util.List;

/**
 * Created by Adrian on 04-Aug-14.
 */

public class UserTest {
	
    @Test
    public void addAndDisplayUsers(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService=(UserService)ctx.getBean("userServiceImpl");
        AssetService assetService=(AssetService)ctx.getBean("assetServiceImpl");
        TransactionService transactionService=(TransactionService)ctx.getBean("transactionServiceImpl");
        User user=new User();
        user.setName("AAAA");
        user.setPassword("parola");
        user.setEmail("aaa@yahoo.com");
        user.setRole("rol");
        userService.createUser(user);
        Asset asset=new Asset();
        asset.setName("4Tech");
        asset.setType("mouse");
        assetService.createAsset(asset);
        System.out.println(assetService.getAssetById(asset.getId())+"\n");
        Long transactionId=transactionService.requestAssetByUser(user.getId(),asset.getId());
        transactionService.addAssetToUser(user.getId(),asset.getId(),transactionId);
        List<Asset> assets=userService.getUserAssets(user.getId());
        System.out.println(user+"\n");
        userService.changePassword(user.getId(),"parolanoua");
        for(Asset asset1:assets){
            System.out.println(asset1+"\n");
        }
        List<Transaction> transactions=userService.getUserTransactions(user.getId());
        for(Transaction transaction1:transactions){
            System.out.println(transaction1);
        }
        //assetService.deleteAsset(asset.getId());
        userService.deleteUser(user.getId());
        System.out.println(userService.getUserById(user.getId()));
        System.out.println(transactionService.getTransactionById(transactionId));
    }
}
