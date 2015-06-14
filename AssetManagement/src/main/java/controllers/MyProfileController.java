package controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Asset;
import domain.Complaint;
import domain.Request;
import domain.Transaction;
import services.AssetService;
import services.ComplaintService;
import services.RequestService;
import services.TransactionService;
import services.UserService;

@Controller
public class MyProfileController {
	private static final Logger logger = Logger.getLogger(MyProfileController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AssetService assetService;
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "userAssets/{userId}", produces = "application/json")
	@ResponseBody
	public List<Asset> getUserAssets(@PathVariable Long userId){
		logger.info("Inside getUserAssets method");
		List<Asset> userAssets = null;
		try{
			userAssets = assetService.getAssetsForUser(userId);
			
		} catch(Exception e){
			logger.error("in getUserAssets method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return userAssets;
	}
	
	@RequestMapping(value = "userComplaints/{userId}", produces = "application/json")
	@ResponseBody
	public List<Complaint> getUserComplaints(@PathVariable Long userId){
		logger.info("Inside getUserComplaints method");
		List<Complaint> userComplaints = null;
		try{
			userComplaints = complaintService.getComplaintsForUser(userId);
			
		} catch(Exception e){
			logger.error("in getUserComplaints method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return userComplaints;
	}
	
	@RequestMapping(value = "userRequests/{userId}", produces = "application/json")
	@ResponseBody
	public List<Request> getUserRequests(@PathVariable Long userId){
		logger.info("Inside getUserRequests method");
		List<Request> userRequests = null;
		try{
			userRequests = requestService.getRequetsForUser(userId);
			
		} catch(Exception e){
			logger.error("in getUserRequests method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return userRequests;
	}
	
	@RequestMapping(value = "userTransactions/{userId}", produces = "application/json")
	@ResponseBody
	public List<Transaction> getUserTransactions(@PathVariable Long userId){
		logger.info("Inside getUserTransactions method");
		List<Transaction> userTransactions = null;
		try{
			userTransactions = transactionService.getTransactionsForUser(userId);
			
		} catch(Exception e){
			logger.error("in getUserTransactions method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return userTransactions;
	}
		
}
