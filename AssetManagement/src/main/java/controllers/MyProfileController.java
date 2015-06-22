package controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@PreAuthorize("isAuthenticated()")
@Controller
public class MyProfileController {
	private static final Logger logger = Logger.getLogger(MyProfileController.class);
	
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
	public Map<String, Object> getUserAssets(@PathVariable String username){
		logger.info("Inside getUserAssets method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Asset> userAssets = null;
		
		try{
			userAssets = assetService.getAssetsByUser(username);
			resultMap.put("status", "true");
			resultMap.put("message", userAssets);
			
		} catch(Exception e){
			logger.error("in getUserAssets method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting user assets!");
		}
		
		return resultMap;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userComplaints/{username}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getUserComplaints(@PathVariable String username){
		logger.info("Inside getUserComplaints method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Complaint> userComplaints = null;
		
		try{
			userComplaints = complaintService.getComplaintsByUser(username);
			resultMap.put("status", "true");
			resultMap.put("message", userComplaints);
			
		} catch(Exception e){
			logger.error("in getUserComplaints method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting user complaints!");
		}
		
		return resultMap;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userRequests/{username}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getUserRequests(@PathVariable String username){
		logger.info("Inside getUserRequests method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Request> userRequests = null;
		
		try{
			userRequests = requestService.getRequetsByUser(username);
			resultMap.put("status", "true");
			resultMap.put("message", userRequests);
			
		} catch(Exception e){
			logger.error("in getUserRequests method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting user requests!");
		}
		
		return resultMap;
	}
	
	@PreAuthorize("(hasRole('ROLE_USER') and #username == principal.username) or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "userTransactions/{username}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getUserTransactions(@PathVariable String username){
		logger.info("Inside getUserTransactions method");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Transaction> userTransactions = null;
		
		
		try{
			userTransactions = transactionService.getTransactionsByUser(username);
			resultMap.put("status", "true");
			resultMap.put("message", userTransactions);
			
		} catch(Exception e){
			logger.error("in getUserTransactions method Exception: " + e.getMessage() + "; Cause: " + e.getCause());
			e.printStackTrace();
			resultMap.put("status", "false");
			resultMap.put("message", "Error getting user transactions!");
		}
		
		return resultMap;
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "testPrincipal", produces = "application/json")
	@ResponseBody
	public Principal testPrincipal(@AuthenticationPrincipal Principal principal){
		logger.info("Inside testPrincipal method");
		return principal;
	}
	
}