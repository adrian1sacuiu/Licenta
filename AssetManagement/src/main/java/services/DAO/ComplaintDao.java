package services.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import domain.Complaint;
import services.DAO.controller.SessionController;

public class ComplaintDao extends SessionController {
	private static final Logger logger = Logger.getLogger(ComplaintDao.class);

	public Complaint addComplaint(Complaint complaint) {
		logger.info("Inside addComplaint method.");

		try {
			getCurrentSession().save(complaint);

		} catch (Exception e) {
			logger.error("in addComplaint method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return complaint;
	}

	public boolean updateComplaint(Complaint complaint) {
		logger.info("Inside updateComplaint method.");
		boolean result = false;

		try {
			getCurrentSession().update(complaint);
			result = true;

		} catch (Exception e) {
			logger.error("in updateComplaint method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return result;
	}

	public boolean deleteComplaint(Complaint complaint) {
		logger.info("Inside deleteComplaint method.");
		boolean result = false;

		try {
			getCurrentSession().delete(complaint);
			result = true;

		} catch (Exception e) {
			logger.error("in deleteComplaint method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Complaint> getAllComplaints() {
		logger.info("Inside getAllComplaints method.");
		List<Complaint> complaints = null;

		try {
			complaints = getCurrentSession().createCriteria(Complaint.class).list();

		} catch (Exception e) {
			logger.error("in getAllComplaints method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return complaints;
	}

	public Complaint getComplaintById(Long id) {
		logger.info("Inside getComplaintById method.");
		Complaint complaint = null;

		try {
			complaint = (Complaint) getCurrentSession().get(Complaint.class, id);
		} catch (Exception e) {
			logger.error("in getComplaintById method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return complaint;
	}

	@SuppressWarnings("unchecked")
	public List<Complaint> getComplaintsByTitle(String title) {
		logger.info("Inside getComplaintsByTitle method.");
		List<Complaint> complaints = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getComplaintsByTitle");
			query.setParameter("title", title);

			complaints = (List<Complaint>) query.list();

		} catch (Exception e) {
			logger.error("in getComplaintsByTitle method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return complaints;
	}

	@SuppressWarnings("unchecked")
	public List<Complaint> getComplaintsByDescription(String description) {
		logger.info("Inside getComplaintsByDescription method.");
		List<Complaint> complaints = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getComplaintsByTitle");
			query.setParameter("description", description);

			complaints = (List<Complaint>) query.list();

		} catch (Exception e) {
			logger.error("in getComplaintsByDescription method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return complaints;
	}

	@SuppressWarnings("unchecked")
	public List<Complaint> getComplaintsByPriority(String priority) {
		logger.info("Inside getComplaintsByPriority method.");
		List<Complaint> complaints = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getComplaintsByPriority");
			query.setParameter("priority", priority);

			complaints = (List<Complaint>) query.list();

		} catch (Exception e) {
			logger.error("in getComplaintsByPriority method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return complaints;
	}

	@SuppressWarnings("unchecked")
	public List<Complaint> getComplaintsByStatus(String status) {
		logger.info("Inside getComplaintsByStatus method.");
		List<Complaint> complaints = null;

		try {
			Query query = getCurrentSession().getNamedQuery("getComplaintsByStatus");
			query.setParameter("status", status);

			complaints = (List<Complaint>) query.list();

		} catch (Exception e) {
			logger.error("in getComplaintsByStatus method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
		}

		return complaints;
	}
}
