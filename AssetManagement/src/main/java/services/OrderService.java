package services;

import domain.Order;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.OrderDao;

import java.util.List;

@Transactional
@Service
public class OrderService {
	private static final Logger logger = Logger.getLogger(OrderService.class);

	@Autowired
	OrderDao orderDao;

	public boolean addOrder(Order order) throws Exception {
		logger.info("in addOrder method.");

		return orderDao.addOrder(order);
	}

	public boolean updateOrder(Order order) throws Exception {
		logger.info("in updateOrder method.");

		return orderDao.updateOrder(order);
	}

	public boolean deleteOrder(Order order) throws Exception {
		logger.info("in deleteOrder method.");

		return orderDao.deleteOrder(order);
	}

	@Transactional(readOnly = true)
	public List<Order> getAllOrders() {
		logger.info("in getAllOrders method.");

		return orderDao.getAllOrders();
	}

	@Transactional(readOnly = true)
	public Order getOrderById(Long id) {
		logger.info("in getOrderById method.");

		return orderDao.getOrderById(id);
	}
}
