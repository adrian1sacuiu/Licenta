package services.DAO;

import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Adrian on 03-Aug-14.
 */
@Repository
public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
    public User addUser(User user){
        currentSession().save(user);
        return user;
    }
    public User deleteUser(User user){
        currentSession().delete(user);
        return user;
    }
    public List<User> getAllUsers(){
       return currentSession().createCriteria(User.class).list();
    }
    public User getUserById(Long id){
        return (User)currentSession().get(User.class,id);
    }
    public void saveUser(User user){
        currentSession().update(user);
    }
}
