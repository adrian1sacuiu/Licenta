package services.DAO;

import entities.Order;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import services.DAO.controller.SessionController;

import java.sql.Date;
import java.util.List;

@Repository
public class OrderDao extends SessionController {
	private static final Logger logger = Logger.getLogger(OrderDao.class);

	public boolean addOrder(Order order) throws Exception {
		logger.info("Inside addOrder method.");
		boolean result = false;

		try {
			getCurrentSession().save(order);
			result = true;

		} catch (Exception e) {
			logger.error("in addOrder method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	public boolean updateOrder(Order order) throws Exception {
		logger.info("Inside updateOrder method.");
		boolean result = false;

		try {
			getCurrentSession().merge(order);
			result = true;

		} catch (Exception e) {
			logger.error("in updateOrder method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	public boolean deleteOrder(Order order) throws Exception {
		logger.info("Inside deleteOrder method.");
		boolean result = false;

		try {
			getCurrentSession().delete(order);
			result = true;

		} catch (Exception e) {
			logger.error("in deleteOrder method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() throws Exception {
		logger.info("Inside getAllOrders method.");
		List<Order> orders = null;

		try {
			orders = getCurrentSession().createCriteria(Order.class).list();

		} catch (Exception e) {
			logger.error("in getAllOrders method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return orders;
	}

	public Order getOrderById(Long id) throws Exception {
		logger.info("Inside getOrderById method.");
		Order order = null;

		try {
			order = (Order) getCurrentSession().get(Order.class, id);
		} catch (Exception e) {
			logger.error("in getOrderById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return order;
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrdersByPrice(String price) throws Exception {
		logger.info("Inside getOrdersByPrice method.");
		List<Order> orders = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getOrdersByPrice");
			query.setParameter("price", price);

			orders = (List<Order>) query.list();

		} catch (Exception e) {
			logger.error("in getOrdersByPrice method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return orders;
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrdersBySupplierName(String supplierName) throws Exception {
		logger.info("Inside getOrdersBySupplierName method.");
		List<Order> orders = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getOrdersBySupplierName");
			query.setParameter("supplierName", supplierName);

			orders = (List<Order>) query.list();

		} catch (Exception e) {
			logger.error("in getOrdersBySupplierName method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return orders;
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrdersByPurchaseDate(Date purchaseDate) throws Exception {
		logger.info("Inside getOrdersByPurchaseDate method.");
		List<Order> orders = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getOrdersByPurchaseDate");
			query.setParameter("purchaseDate", purchaseDate);

			orders = (List<Order>) query.list();

		} catch (Exception e) {
			logger.error("in getOrdersByPurchaseDate method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return orders;
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrdersByIsReceived(boolean isReceived) throws Exception {
		logger.info("Inside getOrdersByIsReceived method.");
		List<Order> orders = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getOrdersByIsReceived");
			query.setParameter("isReceived", isReceived);

			orders = (List<Order>) query.list();

		} catch (Exception e) {
			logger.error("in getOrdersByIsReceived method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return orders;
	}

}
