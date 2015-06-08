package services;

import domain.Asset;
import domain.Transaction;
import domain.User;
import java.util.List;

/**
 * Created by Adrian on 05-Aug-14.
 */
public interface UserService {
	public User createUser(User user);

	public User getUserById(Long id);

	public User deleteUser(Long id);

	public String changePassword(Long id, String password);

	public String changeEmail(Long id, String email);

	public List<User> getAllUsers();

	public List<Asset> getUserAssets(Long id);

	public List<Transaction> getUserTransactions(Long id);
}
