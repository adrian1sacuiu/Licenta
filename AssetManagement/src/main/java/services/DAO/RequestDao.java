package services.DAO;

import entities.Request;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import services.DAO.controller.SessionController;

import java.sql.Date;
import java.util.List;

@Repository
public class RequestDao extends SessionController {
	private static final Logger logger = Logger.getLogger(RequestDao.class);

	public boolean addRequest(Request request) throws Exception {
		logger.info("Inside addRequest method.");
		boolean result = false;

		try {
			getCurrentSession().save(request);
			result = true;

		} catch (Exception e) {
			logger.error("in addRequest method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	public boolean updateRequest(Request request) throws Exception {
		logger.info("Inside updateRequest method.");
		boolean result = false;

		try {
			getCurrentSession().merge(request);
			result = true;

		} catch (Exception e) {
			logger.error("in updateRequest method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	public boolean deleteRequest(Request request) throws Exception {
		logger.info("Inside deleteRequest method.");
		boolean result = false;

		try {
			getCurrentSession().delete(request);
			result = true;

		} catch (Exception e) {
			logger.error("in deleteRequest method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Request> getAllRequests() throws Exception {
		logger.info("Inside getAllRequests method.");
		List<Request> requests = null;

		try {
			requests = getCurrentSession().createCriteria(Request.class).list();

		} catch (Exception e) {
			logger.error("in getAllRequests method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return requests;
	}

	public Request getRequestById(Long id) throws Exception {
		logger.info("Inside getRequestById method.");
		Request request = null;

		try {
			request = (Request) getCurrentSession().get(Request.class, id);
		} catch (Exception e) {
			logger.error("in getRequestById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return request;
	}

	@SuppressWarnings("unchecked")
	public List<Request> getRequestsByStartDate(Date startDate) throws Exception {
		logger.info("Inside getRequestsByStartDate method.");
		List<Request> requests = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getRequestsByStartDate");
			query.setParameter("startDate", startDate);

			requests = (List<Request>) query.list();

		} catch (Exception e) {
			logger.error("in getRequestsByStartDate method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return requests;
	}

	@SuppressWarnings("unchecked")
	public List<Request> getRequestsByEndDate(Date endDate) throws Exception {
		logger.info("Inside getRequestByEndDate method.");
		List<Request> requests = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getRequestsByEndDate");
			query.setParameter("endDate", endDate);

			requests = (List<Request>) query.list();

		} catch (Exception e) {
			logger.error("in getRequesstByEndDate method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return requests;
	}

	@SuppressWarnings("unchecked")
	public List<Request> getRequestsByStatus(String status) throws Exception {
		logger.info("Inside getRequestsByStatus method.");
		List<Request> requests = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getRequestsByStatus");
			query.setParameter("status", status);

			requests = (List<Request>) query.list();

		} catch (Exception e) {
			logger.error("in getRequestsByStatus method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return requests;
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> getRequestsByUser(String username) throws Exception {
		logger.info("Inside getRequestsByUser method.");
		List<Request> requests = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getRequestsByUser");
			query.setParameter("username", username);

			requests = (List<Request>) query.list();

		} catch (Exception e) {
			logger.error("in getRequestsByUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return requests;
	}

	@SuppressWarnings("unchecked")
	public List<Request> getRequestsByAsset(Long idAsset) throws Exception {
		logger.info("Inside getRequestsByAsset method.");
		List<Request> requests = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getRequestsByAsset");
			query.setParameter("idAsset", idAsset);

			requests = (List<Request>) query.list();

		} catch (Exception e) {
			logger.error("in getRequestsByAsset method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return requests;
	}
	
}
