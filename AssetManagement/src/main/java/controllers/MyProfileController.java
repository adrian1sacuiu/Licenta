package controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Asset;
import entities.Complaint;
import entities.Request;
import entities.Transaction;
import services.AssetService;
import services.ComplaintService;
import services.RequestService;
import services.TransactionService;
import services.UsersService;

@Controller
public class MyProfileController {
	private static final Logger logger = Logger.getLogger(MyProfileController.class);
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private AssetService assetService;
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private TransactionService transactionService;
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userAssets/{username}", produces = "application/json")
	@ResponseBody
	public List<Asset> getUserAssets(@PathVariable String username){
		logger.info("Inside getUserAssets method");
		List<Asset> userAssets = null;
		try{
			userAssets = assetService.getAssetsForUser(username);
			
		} catch(Exception e){
			logger.error("in getUserAssets method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return userAssets;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userComplaints/{username}", produces = "application/json")
	@ResponseBody
	public List<Complaint> getUserComplaints(@PathVariable String username){
		logger.info("Inside getUserComplaints method");
		List<Complaint> userComplaints = null;
		try{
			userComplaints = complaintService.getComplaintsForUser(username);
			
		} catch(Exception e){
			logger.error("in getUserComplaints method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return userComplaints;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userRequests/{username}", produces = "application/json")
	@ResponseBody
	public List<Request> getUserRequests(@PathVariable String username){
		logger.info("Inside getUserRequests method");
		List<Request> userRequests = null;
		try{
			userRequests = requestService.getRequetsForUser(username);
			
		} catch(Exception e){
			logger.error("in getUserRequests method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return userRequests;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userTransactions/{username}", produces = "application/json")
	@ResponseBody
	public List<Transaction> getUserTransactions(@PathVariable String username){
		logger.info("Inside getUserTransactions method");
		List<Transaction> userTransactions = null;
		
		try{
			userTransactions = transactionService.getTransactionsForUser(username);
			
		} catch(Exception e){
			logger.error("in getUserTransactions method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
		}
		
		return userTransactions;
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "test", produces = "application/json")
	@ResponseBody
	public Principal testPrincipal(@AuthenticationPrincipal Principal principal){
		logger.info("Inside testPrincipal method");
		return principal;
	}
	
}
