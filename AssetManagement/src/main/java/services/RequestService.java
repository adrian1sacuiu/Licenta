package services;

import entities.Request;

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
		boolean result = false;

		try {
			result = requestDao.addRequest(request);

		} catch (Exception e) {
			logger.error("in addRequest method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	public boolean updateRequest(Request request) throws Exception {
		logger.info("in updateRequest method.");
		boolean result = false;

		try {
			result = requestDao.updateRequest(request);

		} catch (Exception e) {
			logger.error("in updateRequest method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	public boolean deleteRequest(Request request) throws Exception {
		logger.info("in deleteRequest method.");
		boolean result = false;

		try {
			result = requestDao.deleteRequest(request);

		} catch (Exception e) {
			logger.error("in deleteRequest method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	@Transactional(readOnly = true)
	public List<Request> getAllRequests() throws Exception {
		logger.info("in getAllRequests method.");
		List<Request> requests = null;

		try {
			requests = requestDao.getAllRequests();

		} catch (Exception e) {
			logger.error("in getAllRequests method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return requests;
	}

	@Transactional(readOnly = true)
	public Request getRequestById(Long id) throws Exception {
		logger.info("in getRequestById method.");
		Request request = null;

		try {
			request = requestDao.getRequestById(id);

		} catch (Exception e) {
			logger.error("in getRequestById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return request;
	}

	@Transactional(readOnly = true)
	public List<Request> getRequestsByDate(Date date) throws Exception {
		logger.info("in getRequestsByDate method.");
		List<Request> requests = null;

		try {
			requests = requestDao.getRequestsByDate(date);

		} catch (Exception e) {
			logger.error("in getRequestsByDate method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return requests;
	}

	@Transactional(readOnly = true)
	public List<Request> getRequestsByStatus(String status) throws Exception {
		logger.info("in getRequestsByStatus method.");
		List<Request> requests = null;

		try {
			requests = requestDao.getRequestsByStatus(status);

		} catch (Exception e) {
			logger.error("in getRequestsByStatus method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return requests;
	}

	@Transactional(readOnly = true)
	public List<Request> getRequetsByUser(String username) throws Exception {
		logger.info("Inside getRequetsByUser method.");
		List<Request> requests = null;

		try {
			requests = requestDao.getRequestsByUser(username);

		} catch (Exception e) {
			logger.error("in getRequetsByUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return requests;
	}
	
	@Transactional(readOnly = true)
	public List<Request> getRequestsByAsset(Long idAsset) throws Exception {
		logger.info("Inside getRequestsByAsset method.");
		List<Request> requests = null;

		try {
			requests = requestDao.getRequestsByAsset(idAsset);

		} catch (Exception e) {
			logger.error("in getRequestsByAsset method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return requests;
	}
}
