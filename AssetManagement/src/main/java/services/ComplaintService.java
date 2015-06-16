package services;

import domain.Complaint;
import domain.User;

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

		return complaintDao.addComplaint(complaint);
	}

	public boolean updateComplaint(Complaint complaint) throws Exception {
		logger.info("in updateComplaint method.");

		return complaintDao.updateComplaint(complaint);
	}

	public boolean deleteComplaint(Complaint complaint) throws Exception {
		logger.info("in deleteComplaint method.");

		return complaintDao.deleteComplaint(complaint);
	}

	@Transactional(readOnly = true)
	public List<Complaint> getAllComplaints() {
		logger.info("in getAllComplaints method.");

		return complaintDao.getAllComplaints();
	}

	@Transactional(readOnly = true)
	public Complaint getComplaintById(Long id) {
		logger.info("in getComplaintById method.");

		return complaintDao.getComplaintById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Complaint> getComplaintsByTitle(String title) {
		logger.info("in getComplaintsByTitle method.");
		
		return getComplaintsByTitle(title);
	}
	
	@Transactional(readOnly = true)
	public List<Complaint> getComplaintsByDescription(String description) {
		logger.info("in getComplaintsByDescription method.");
		
		return getComplaintsByDescription(description);
	}
	
	@Transactional(readOnly = true)
	public List<Complaint> getComplaintsByPriority(String priority) {
		logger.info("in getComplaintsByPriority method.");
		
		return getComplaintsByPriority(priority);
	}
	
	@Transactional(readOnly = true)
	public List<Complaint> getComplaintsByStatus(String status) {
		logger.info("in getComplaintsByStatus method.");
		
		return getComplaintsByStatus(status);
	}
	
	@Transactional(readOnly = true)
	public List<Complaint> getComplaintsForUser(String username){
		logger.info("Inside getComplaintsForUser method.");
		
		User user = userDao.getUserByUsername(username);
		List<Complaint> complaints = user.getComplaints();
		Hibernate.initialize(complaints);;
		
		return complaints;
	}
}
