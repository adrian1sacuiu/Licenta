package services.DAO;

import domain.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Adrian on 03-Aug-14.
 */
@Repository
public class TransactionDaoImpl implements TransactionDao {
    private SessionFactory sessionFactory;
    @Autowired
    public TransactionDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
    public Transaction addTransaction(Transaction transaction){
        currentSession().save(transaction);
        return transaction;
    }
    public Transaction deleteTransaction(Transaction transaction){
        currentSession().delete(transaction);
        return transaction;
    }
    public Transaction getTransactionById(Long id){
        return (Transaction)currentSession().get(Transaction.class,id);
    }
    public List<Transaction> getAllTransactions(){
        return currentSession().createCriteria(Transaction.class).list();
    }
    public void saveTransaction(Transaction transaction){
        currentSession().update(transaction);
    }
}
