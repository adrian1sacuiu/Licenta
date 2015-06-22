package services;

import entities.Order;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.OrderDao;

import java.sql.Date;
import java.util.List;

@Transactional
@Service
public class OrderService {
	private static final Logger logger = Logger.getLogger(OrderService.class);

	@Autowired
	private OrderDao orderDao;

	public boolean addOrder(Order order) throws Exception {
		logger.info("in addOrder method.");
		boolean result = false;

		try {
			result = orderDao.addOrder(order);

		} catch (Exception e) {
			logger.error("in addOrder method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	public boolean updateOrder(Order order) throws Exception {
		logger.info("in updateOrder method.");
		boolean result = false;

		try {
			result = orderDao.updateOrder(order);

		} catch (Exception e) {
			logger.error("in updateOrder method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	public boolean deleteOrder(Order order) throws Exception {
		logger.info("in deleteOrder method.");
		boolean result = false;

		try {
			result = orderDao.deleteOrder(order);

		} catch (Exception e) {
			logger.error("in deleteOrder method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	@Transactional(readOnly = true)
	public List<Order> getAllOrders() throws Exception {
		logger.info("in getAllOrders method.");
		List<Order> orders = null;

		try {
			orders = orderDao.getAllOrders();

		} catch (Exception e) {
			logger.error("in getAllOrders method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return orders;
	}

	@Transactional(readOnly = true)
	public Order getOrderById(Long id) throws Exception {
		logger.info("in getOrderById method.");
		Order order = null;

		try {
			order = orderDao.getOrderById(id);

		} catch (Exception e) {
			logger.error("in getOrderById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return order;
	}

	@Transactional(readOnly = true)
	public List<Order> getOrdersByPrice(String price) throws Exception {
		logger.info("in getOrdersByPrice method.");
		List<Order> orders = null;

		try {
			orders = orderDao.getOrdersByPrice(price);

		} catch (Exception e) {
			logger.error("in getOrdersByPrice method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return orders;
	}

	@Transactional(readOnly = true)
	public List<Order> getOrdersBySupplierName(String supplierName) throws Exception {
		logger.info("in getOrdersBySupplierName method.");
		List<Order> orders = null;

		try {
			orders = orderDao.getOrdersBySupplierName(supplierName);

		} catch (Exception e) {
			logger.error("in getOrdersBySupplierName method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return orders;
	}

	@Transactional(readOnly = true)
	public List<Order> getOrdersByPurchaseDate(Date purchaseDate) throws Exception {
		logger.info("in getOrdersByPurchaseDate method.");
		List<Order> orders = null;

		try {
			orders = orderDao.getOrdersByPurchaseDate(purchaseDate);

		} catch (Exception e) {
			logger.error("in getOrdersByPurchaseDate method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return orders;
	}

	@Transactional(readOnly = true)
	public List<Order> getOrdersByIsReceived(boolean isReceived) throws Exception {
		logger.info("in getOrdersByIsReceived method.");
		List<Order> orders = null;

		try {
			orders = orderDao.getOrdersByIsReceived(isReceived);

		} catch (Exception e) {
			logger.error("in getOrdersByIsReceived method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return orders;
	}
}
