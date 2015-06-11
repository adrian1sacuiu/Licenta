package services.DAO;

import domain.User;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import services.DAO.controller.SessionController;

import java.util.List;

@Repository
public class UserDao extends SessionController{
	private static final Logger logger = Logger.getLogger(UserDao.class);
	
	public User addUser(User user) {
		logger.info("Inside addUser method.");
		
		try {
			getCurrentSession().save(user);
		} catch (Exception e) {
			logger.error("in addUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return user;
	}

	public User deleteUser(User user) {
		logger.info("Inside deleteUser method.");
		
		try {
			getCurrentSession().delete(user);
		} catch (Exception e) {
			logger.error("in deleteUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		logger.info("Inside getAllUsers method.");
		
		List<User> users = null;
		
		try {
			users = getCurrentSession().createCriteria(User.class).list();
		} catch (Exception e) {
			logger.error("in getAllUsers method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return users;
	}

	public User getUserById(Long id) {
		logger.info("Inside getUserById method.");
		
		User user = null;
		
		try {
			user = (User) getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			logger.error("in getUserById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserByName(String name){
		logger.info("Inside getUserByName method.");
		
		List<User> users = null;
		
		try {
			Query query = getCurrentSession().getNamedQuery("getUserByName");
			logger.info(query.getQueryString());
			query.setParameter("name", name);
			users = (List<User>)query.list();
		} catch (Exception e) {
			logger.error("in getUserByName method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
		
		return users;
	}
	
	public void updateUser(User user) {
		logger.info("Inside updateUser method.");
		
		try {
			getCurrentSession().update(user);
		} catch (Exception e) {
			logger.error("in updateUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}
	}
}
