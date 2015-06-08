package services.DAO;

import domain.User;

import java.util.List;

/**
 * Created by Adrian on 05-Aug-14.
 */
public interface UserDao {
	public User addUser(User user);

	public User deleteUser(User user);

	public User getUserById(Long id);

	public List<User> getAllUsers();

	public void updateUser(User user);
}
