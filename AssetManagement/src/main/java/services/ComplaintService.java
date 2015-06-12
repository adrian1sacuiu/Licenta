package services;

import domain.Complaint;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.ComplaintDao;

import java.util.List;

@Transactional
@Service
public class ComplaintService{
	private static final Logger logger = Logger.getLogger(ComplaintService.class);

	@Autowired
	ComplaintDao complaintDao;
	
	public Complaint addComplaint(Complaint complaint) {
		logger.info("in addComplaint method.");

		return complaintDao.addComplaint(complaint);
	}

	public boolean updateComplaint(Complaint complaint){
		logger.info("in updateComplaint method.");
		
		return complaintDao.updateComplaint(complaint);
	}
	
	public boolean deleteComplaint(Complaint complaint) {
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
}
