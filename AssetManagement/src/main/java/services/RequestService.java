package services;

import domain.Request;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.RequestDao;

import java.util.List;

@Transactional
@Service
public class RequestService {
	private static final Logger logger = Logger.getLogger(RequestService.class);

	@Autowired
	RequestDao requestDao;

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
}
