package services;

import domain.Request;
import domain.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.RequestDao;
import services.DAO.UserDao;

import java.sql.Date;
import java.util.List;

@Transactional
@Service
public class RequestService {
	private static final Logger logger = Logger.getLogger(RequestService.class);

	@Autowired
	RequestDao requestDao;
	
	@Autowired
	UserDao userDao;

	public boolean addRequest(Request request) throws Exception {
		logger.info("in addRequest method.");

		return requestDao.addRequest(request);
	}

	public boolean updateRequest(Request request) throws Exception {
		logger.info("in updateRequest method.");

		return requestDao.updateRequest(request);
	}

	public boolean deleteRequest(Request request) throws Exception {
		logger.info("in deleteRequest method.");

		return requestDao.deleteRequest(request);
	}

	@Transactional(readOnly = true)
	public List<Request> getAllRequests() {
		logger.info("in getAllRequests method.");

		return requestDao.getAllRequests();
	}

	@Transactional(readOnly = true)
	public Request getRequestById(Long id) {
		logger.info("in getRequestById method.");

		return requestDao.getRequestById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Request> getRequestsByStartDate(Date startDate) {
		logger.info("in getRequestsByStartDate method.");

		return requestDao.getRequestsByStartDate(startDate);
	}
	
	@Transactional(readOnly = true)
	public List<Request> getRequestsByEndDate(Date endDate) {
		logger.info("in getRequestsByEndDate method.");

		return requestDao.getRequestsByEndDate(endDate);
	}
	
	@Transactional(readOnly = true)
	public List<Request> getRequestsByStatus(String status) {
		logger.info("in getRequestsByStatus method.");

		return requestDao.getRequestsByStatus(status);
	}
	
	@Transactional(readOnly = true)
	public List<Request> getRequetsForUser(Long id){
		logger.info("Inside getRequetsForUser method.");
		User user = userDao.getUserById(id);
		
		return user.getRequests();
	}
}
