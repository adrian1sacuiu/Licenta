package services;

import entities.Complaint;
import entities.User;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.ComplaintDao;
import services.DAO.UserDao;

import java.util.List;

@Transactional
@Service
public class ComplaintService {
	private static final Logger logger = Logger.getLogger(ComplaintService.class);

	@Autowired
	ComplaintDao complaintDao;

	@Autowired
	UserDao userDao;

	public boolean addComplaint(Complaint complaint) throws Exception {
		logger.info("in addComplaint method.");
		boolean result = false;

		try {
			result = complaintDao.addComplaint(complaint);

		} catch (Exception e) {
			logger.error("in addComplaint method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	public boolean updateComplaint(Complaint complaint) throws Exception {
		logger.info("in updateComplaint method.");
		boolean result = false;

		try {
			result = complaintDao.updateComplaint(complaint);

		} catch (Exception e) {
			logger.error("in updateComplaint method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	public boolean deleteComplaint(Complaint complaint) throws Exception {
		logger.info("in deleteComplaint method.");
		boolean result = false;

		try {
			result = complaintDao.deleteComplaint(complaint);

		} catch (Exception e) {
			logger.error("in deleteComplaint method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return result;
	}

	@Transactional(readOnly = true)
	public List<Complaint> getAllComplaints() throws Exception {
		logger.info("in getAllComplaints method.");
		List<Complaint> complaints = null;

		try {
			complaints = complaintDao.getAllComplaints();

		} catch (Exception e) {
			logger.error("in getAllComplaints method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return complaints;
	}

	@Transactional(readOnly = true)
	public Complaint getComplaintById(Long id) throws Exception {
		logger.info("in getComplaintById method.");
		Complaint complaint = null;

		try {
			complaint = complaintDao.getComplaintById(id);

		} catch (Exception e) {
			logger.error("in getComplaintById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return complaint;
	}

	@Transactional(readOnly = true)
	public List<Complaint> getComplaintsByTitle(String title) throws Exception {
		logger.info("in getComplaintsByTitle method.");
		List<Complaint> complaints = null;

		try {
			complaints = complaintDao.getComplaintsByTitle(title);

		} catch (Exception e) {
			logger.error("in getComplaintsByTitle method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return complaints;
	}

	@Transactional(readOnly = true)
	public List<Complaint> getComplaintsByDescription(String description) throws Exception {
		logger.info("in getComplaintsByDescription method.");
		List<Complaint> complaints = null;

		try {
			complaints = complaintDao.getComplaintsByDescription(description);

		} catch (Exception e) {
			logger.error("in getComplaintsByDescription method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return complaints;
	}

	@Transactional(readOnly = true)
	public List<Complaint> getComplaintsByPriority(String priority) throws Exception {
		logger.info("in getComplaintsByPriority method.");
		List<Complaint> complaints = null;

		try {
			complaints = complaintDao.getComplaintsByPriority(priority);

		} catch (Exception e) {
			logger.error("in getComplaintsByPriority method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return complaints;
	}

	@Transactional(readOnly = true)
	public List<Complaint> getComplaintsByStatus(String status) throws Exception {
		logger.info("in getComplaintsByStatus method.");
		List<Complaint> complaints = null;

		try {
			complaints = complaintDao.getComplaintsByStatus(status);

		} catch (Exception e) {
			logger.error("in getComplaintsByStatus method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return complaints;
	}

	@Transactional(readOnly = true)
	public List<Complaint> getComplaintsForUser(String username) throws Exception {
		logger.info("Inside getComplaintsForUser method.");
		User user = null;
		List<Complaint> complaints = null;

		try {
			user = userDao.getUserByUsername(username);
			complaints = user.getComplaints();
			Hibernate.initialize(complaints);

		} catch (Exception e) {
			logger.error("in getComplaintsForUser method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			throw e;
		}

		return complaints;
	}
}
